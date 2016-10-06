package objects;

/**
 * Created by james on 9/21/2016.
 */
public class EbayItem extends Item {
    private String ebay_id = null;

    /*** sql ***/

    /*** api ***/
    private String discription;

    public EbayItem(Item i) {
        super(i.getId(), i.getName(), i.getSellingPrice(), i.getCost(), i.getDistributorId(),
                i.getImgSubDir(), i.getAmountInStock() ,i.getAmountSelling());

    }





}
