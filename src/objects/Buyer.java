package objects;

import com.sun.istack.NotNull;

/**
 * Created by james on 9/30/2016.
 */
public class Buyer {
    private String address;
    private String transactionID;
    private String itemBought;


    private String name;

    public Buyer(String name, String address, String itemBought, String transactionID) {
        this.address = address;
        this.itemBought = itemBought;
        this.transactionID = transactionID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getItemBought() {
        return itemBought;
    }

    public void setItemBought(String itemBought) {
        this.itemBought = itemBought;
    }
}
