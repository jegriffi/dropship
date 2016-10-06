package Services;

import objects.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by james on 9/16/2016.
 */
public class ItemService {

    public boolean addItem(String name, float sellingPrice, float cost, int distributorId,
                           String imgSubDir, int amountInStock, int amountSelling) {
        Service s = new Service();
        Connection conn = s.getSqlConnection();

        Item i = new Item(name, sellingPrice, cost, distributorId, imgSubDir, amountInStock, amountSelling);
        String insertItemStr = "INSERT INTO items (name, selling_price, cost, distributor_id, " +
                "img_sub_directory, amount_being_sold, distributor_amount_in_stock) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(insertItemStr);
            stmt.setString(1, name);
            stmt.setFloat(2, sellingPrice);
            stmt.setFloat(3, cost);
            stmt.setInt(4, distributorId);
            stmt.setString(5, imgSubDir);
            stmt.setInt(6, amountSelling);
            stmt.setInt(7, amountInStock);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("ItemService");
            e.printStackTrace();
            return false;
        } finally  {
            s.closeConnection();
        }
        return true;
    }

    public Item getItem(int itemId) {
        Service s = new Service();
        Connection conn = s.getSqlConnection();

        Item i = null;

        String sqlStr = "SELECT * FROM items WHERE items.id = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            stmt.setInt(1, itemId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float sellingPrice = rs.getFloat("selling_price");
                float cost = rs.getFloat("cost");
                int distributorId = rs.getInt("distributor_id");
                String imgSubDir = rs.getString("img_sub_directory");
                int amountBeingSold = rs.getInt("amount_being_sold");
                int amountInStock = rs.getInt("distributor_amount_in_stock");
                i = new Item(id, name, sellingPrice, cost, distributorId, imgSubDir,
                        amountInStock, amountBeingSold);
            }
        } catch (SQLException e) {
            System.out.print("ItemService ");
            e.printStackTrace();
        } finally {
            s.closeConnection();
        }
        return i;
    }
}
