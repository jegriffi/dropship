package objects;

/**
 * Created by james on 9/16/2016.
 */
public class SellingItem {
    private int id;
    private int itemId;
    private int distributorId;
    private String trackingId;
    private String dateSold;

    public SellingItem(int id, int itemId, int distributorId, String trackingId, String dateSold) {
        this.id = id;
        this.itemId = itemId;
        this.distributorId = distributorId;
        this.trackingId = trackingId;
        this.dateSold = dateSold;
    }

    public SellingItem(int itemId, int distributorId, String trackingId, String dateSold) {
        this.itemId = itemId;
        this.distributorId = distributorId;
        this.trackingId = trackingId;
        this.dateSold = dateSold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getDateSold() {
        return dateSold;
    }

    public void setDateSold(String dateSold) {
        this.dateSold = dateSold;
    }

}
