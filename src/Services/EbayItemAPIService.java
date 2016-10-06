package Services;

import Constants.EbayConstants;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.TimeFilter;
import com.ebay.sdk.call.*;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.*;
import objects.Buyer;
import objects.Item;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by james on 9/26/2016.
 */
public class EbayItemAPIService {

    public static void main(String[] args) {
        try {
            List<Buyer> buyers = getSellerTransactionHistory();
            for (Buyer b : buyers) {
                System.out.println(b.getTransactionID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static ApiContext getApiContext() {
        ApiContext apiContext = new ApiContext();

        ApiCredential cred = apiContext.getApiCredential();
        cred.seteBayToken(EbayConstants.TESTUSER_AUTH_CODE);

        apiContext.setApiServerUrl(EbayConstants.SOAP_SERVER_URL);

        return apiContext;
    }

    public static ItemType getEbayItem(String ebayID) throws Exception {
        ApiContext apiContext = getApiContext();
        GetItemCall getItemApi = new GetItemCall(apiContext);
        getItemApi.setItemID(ebayID);

        return getItemApi.getItem();
    }


    public static void relistAllItems(String itemID) {
        List<String> ebayIDList = EbayItemSQLService.getAllItemIDs();
        try {
            for (String id : ebayIDList) {
                if (needsRelisting(id)) {
                    relistItem(id);
                }
            }

        } catch (Exception e) {
            System.out.println("ebayitemapiservice");
            e.printStackTrace();
        }
    }

    private static boolean needsRelisting(String ebayID) throws Exception {
        ItemType item = getEbayItem(ebayID);
        ListingDetailsType listingDetails = item.getListingDetails();
        Calendar endTime = listingDetails.getEndTime();
        Calendar now = Calendar.getInstance();

        if (now.after(endTime)) {
            return true;
        }
        return false;
    }


    private static ShippingDetailsType buildShippingDetails() {
        //Shipping Details
        ShippingDetailsType sd = new ShippingDetailsType();

        sd.setApplyShippingDiscount(new Boolean(true));
        AmountType amount = new AmountType();
        amount.setValue(2.8);
        sd.setPaymentInstructions("ebay java sdk test instructions");

        //TODO: ADD ShippingDetailsType to bypass <ShippingPackage> error

        //Shipping type and service options
        sd.setShippingType(ShippingTypeCodeType.FLAT);
        ShippingServiceOptionsType shippingOptions = new ShippingServiceOptionsType();
        shippingOptions.setShippingService(ShippingServiceCodeType.SHIPPING_METHOD_STANDARD.value());
        amount = new AmountType();
        amount.setValue(2.0);
        shippingOptions.setShippingServiceAdditionalCost(amount);
        amount.setValue(1);
        shippingOptions.setShippingServiceCost(amount);
        shippingOptions.setShippingInsuranceCost(amount);

        sd.setShippingServiceOptions(new ShippingServiceOptionsType[] {shippingOptions});

        return sd;
    }

    private static void relistItem(String ebayID) throws Exception {
        ApiContext apiContext = getApiContext();
        RelistItemCall api = new RelistItemCall(apiContext);
        ItemType item = getEbayItem(ebayID);
        item.setRelisted(true);
        ShipPackageDetailsType shipPack = item.getShippingPackageDetails();

        //TODO: change to fit the items preferences
        shipPack.setShippingPackage(ShippingPackageCodeType.USPS_LARGE_PACK);

        api.setItemToBeRelisted(item);

        //Sets the parent RelistedID
        ItemType newItem = api.getItemToBeRelisted();

        newItem.setRelistParentID(Long.parseLong(ebayID));

        try {
            FeesType fees = api.relistItem();
            System.out.println("Item Listed.");
            double listingFee = eBayUtil.findFeeByName(fees.getFee(), "ListingFee")
                    .getFee()
                    .getValue();
            System.out.println("ListingFee is: " + new Double(listingFee).toString());
            System.out.println("Listed Item ID: " + item.getItemID());
        } catch (ApiException e) {
            System.out.println("COULD NOT RELIST ITEM");
            System.out.println("ebayItemapiservice relistItem");
            e.printStackTrace();
        }
    }

    public static void deleteEbayItem(String ebayID) throws Exception {
        ApiContext apiContext = getApiContext();
        EndItemCall api = new EndItemCall(apiContext);

        api.setItemID(ebayID);
        api.setEndingReason(EndReasonCodeType.NOT_AVAILABLE);
        api.endItem();
    }

    public static List<ItemType> getSellerItemListFromAPI() throws Exception {
        List<ItemType> items = new ArrayList<>();
        ApiContext apiContext = getApiContext();
        GetSellerListCall api = new GetSellerListCall(apiContext);

        api.setUserID(EbayConstants.TESTUSER_USERNAME);

        Calendar c1 = Calendar.getInstance();
        c1.set(2016, Calendar.SEPTEMBER, 22, 12, 45);

        Calendar c2 = Calendar.getInstance();
        c2.set(2016, 9, 27, 13, 47);

        TimeFilter time = new TimeFilter(c1, c2);
        api.setEndTimeFilter(time);
        System.out.println("Getting seller list...");
        ItemType[] itemsIDs = api.getSellerList();

        for (ItemType i : itemsIDs) {
            items.add(getEbayItem(i.getItemID()));
        }
        return items;
    }

    //returns only null parameters of seller list except id's
    public static List<String> getSellerIDListFromAPI() throws Exception {
        List<ItemType> items = getSellerItemListFromAPI();
        List<String> itemIDs = new ArrayList<>();
        for (ItemType i : items) {
            System.out.println(i.getItemID());
            itemIDs.add(i.getItemID());
        }
        return itemIDs;
    }

    public static String getAddressAsString(AddressType at) {
        String address = "";
        if (!at.getStreet().isEmpty())
            address += at.getStreet();

        if (!at.getStreet1().isEmpty())
            address += at.getStreet1();

        if (!at.getStreet2().isEmpty())
            address += at.getStreet2();

        if (!at.getCityName().isEmpty())
            address += at.getCityName();

        if (!at.getStateOrProvince().isEmpty())
            address += at.getStateOrProvince();

        if (!at.getPostalCode().isEmpty())
            address += at.getPostalCode();

        return address;
    }

    // returns a list of buyers name and addresses of items that were recently sold
    public static List<Buyer> getSellerTransactionHistory() throws Exception {
        ApiContext apiContext = getApiContext();
        GetSellerTransactionsCall api = new GetSellerTransactionsCall(apiContext);
        List<Buyer> buyerList = new ArrayList<>();

        Calendar c1 = Calendar.getInstance();
        c1.set(2016, Calendar.SEPTEMBER, 22, 12, 45);

        Calendar c2 = Calendar.getInstance();

        TimeFilter time = new TimeFilter(c1, c2);
        api.setTimeFilter(time);

        TransactionType[] transactionTypes = api.getEntireSellerTransactions();
        for (TransactionType tt : transactionTypes) {
            if (!((Boolean) tt.getAny(0))) { //USED TO CHECK IF THIS ITEM HAS BEEN HANDLED OR NOT
                tt.setAny(0, Boolean.TRUE);
                UserType buyerUser = tt.getBuyer();



                //TODO: figure out how to get specific transaction pertaining to the item+buyer
                ExternalTransactionType[] ett = tt.getExternalTransaction();
                String paypalTransactionID = ett[0].getExternalTransactionID(); //???? why array? have to debug
                // http://developer.ebay.com/devzone/guides/ebayfeatures/Development/PayPal-Sandbox.html



                BuyerType buyer = buyerUser.getBuyerInfo();
                AddressType at = buyer.getShippingAddress();
                String name = at.getFirstName() + at.getLastName();
                Buyer b = new Buyer(name, getAddressAsString(at), tt.getItem().getItemID(), paypalTransactionID);
                buyerList.add(b);
            }
        }
        return buyerList;
    }


    //TODO: integrate paypal in the the seller info
    //verify paypal transaction function
    //sell item class to specific distributor
}
