package objects;

/**
 * Created by james on 9/16/2016.
 */
public class Item {
    private String name;
    private int id;
    private float sellingPrice;
    private float cost;
    private String distributor;
    private int distributorId;
    private String imgSubDir;
    private int amountInStock;
    private int amountSelling;

    public Item(String name, float sellingPrice, float cost, int distributorId, String imgSubDir, int amountInStock, int amountSelling) {
        this.name = name;
        this.distributorId = distributorId;
        this.sellingPrice = sellingPrice;
        this.cost = cost;
        this.imgSubDir = imgSubDir;
        this.amountInStock = amountInStock;
        this.amountSelling = amountSelling;
    }

    public Item(int id, String name, float sellingPrice, float cost, int distributorId, String imgSubDir, int amountInStock, int amountSelling) {
        this.id = id;
        this.name = name;
        this.distributorId = distributorId;
        this.sellingPrice = sellingPrice;
        this.cost = cost;
        this.imgSubDir = imgSubDir;
        this.amountInStock = amountInStock;
        this.amountSelling = amountSelling;
    }
    //TODO: get ID from sql command
    public int getId() {
        return this.id;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public String getImgSubDir() {
        return imgSubDir;
    }

    public void setImgSubDir(String imgSubDir) {
        this.imgSubDir = imgSubDir;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public int getAmountSelling() {
        return amountSelling;
    }

    public void setAmountSelling(int amountSelling) {
        this.amountSelling = amountSelling;
    }
}
