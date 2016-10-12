package Services;

import objects.Distributor;
import objects.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 9/16/2016.
 */
public class DistributorService extends Service {
    public static void main(String[] args) {
        boolean b = addDistributor("aaname", "a@email.com", "11111111", "www.w.com", "urlfeed");
        if (b) {
            System.out.println("yoooo");
        }
        else {
            System.out.println("nooo");
        }
    }
    private List<Distributor> distributorList = null;

    public List<Distributor> getDistributorList() {
        Service s = new Service();
        Connection conn = s.getSqlConnection();
        distributorList = new ArrayList<>();

        String sqlStr = "SELECT * FROM distributors";

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String website = rs.getString(5);
                String url = rs.getString(6);

                Distributor d = new Distributor(id, name, email, phone, website, url);
                distributorList.add(d);
            }
        } catch (SQLException e) {
            System.out.println("distributorservice.java");
            e.printStackTrace();
            s.closeConnection();
        }
        s.closeConnection();
        return distributorList;
    }

    public Distributor getDistributorById(int id) {
        if (distributorList == null) {
            getDistributorList();
        }
        for (Distributor d : distributorList) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public Distributor getDistributorByName(String name) {
        if (distributorList == null) {
            getDistributorList();
        }
        for (Distributor d : distributorList) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }

    public List<Item> getDistributorItems(int distributorId) {
        List<Item> distributorItems = new ArrayList<>();
        Service s = new Service();
        Connection conn = s.getSqlConnection();
        String sqlStr = "SELECT * FROM items_in_distributors WHERE distributor_id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            stmt.setInt(1, distributorId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float sellingPrice = rs.getFloat("selling_price");
                float cost = rs.getFloat("cost");
                int distId = rs.getInt("distributor_id");
                String imgSubDir = rs.getString("img_sub_directory");
                int amountBeingSold = rs.getInt("amount_being_sold");
                int amountInStock = rs.getInt("distributor_amount_in_stock");
                Item i = new Item(id, name, sellingPrice, cost, distId, imgSubDir,
                        amountInStock, amountBeingSold);

                distributorItems.add(i);
            }
        } catch(SQLException e) {
            System.out.println("distributorservice.java");
            e.printStackTrace();
            s.closeConnection();
        }
        s.closeConnection();
        return distributorItems;
    }

    public static boolean addDistributor(String name, String email, String phone, String website, String feed_url) {
        Distributor d = new Distributor(name, email, phone, website, feed_url);
        Service s = new Service();
        Connection conn = s.getSqlConnection();

        String sqlStr = "INSERT INTO distributors (name, email, phone, website, url_feed) VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, website);
            stmt.setString(5, feed_url);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("distributorservice.java");
            e.printStackTrace();
            return false;
        } finally {
            s.closeConnection();
        }
        return true;

    }
}
