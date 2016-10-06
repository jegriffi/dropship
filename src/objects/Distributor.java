package objects;


import Services.ItemService;

import java.util.List;

/**
 * Created by james on 9/16/2016.
 */
public class Distributor {
    private String name;
    private int id;
    private String email;
    private String phone;
    private String website;
    private String feed_url;
    private List<Item> itemsList;

    public Distributor(int id, String name, String email, String phone, String website, String feed_url) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.feed_url = feed_url;
    }

    public Distributor(String name, String email, String phone, String website, String feed_url) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.feed_url = feed_url;
    }

    public void addItemsList(List<Item> items) {
        this.itemsList = items;
    }

    public List getItemsList() {
        return this.itemsList;
    }

    public void addItem(Item i) {
        itemsList.add(i);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFeed_url() {
        return feed_url;
    }

    public void setFeed_url(String feed_url) {
        this.feed_url = feed_url;
    }
}
