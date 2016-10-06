package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 9/26/2016.
 */
public class EbayItemSQLService {

    public static List<String> getAllItemIDs() {
        Service s = new Service();
        Connection conn = s.getSqlConnection();

        String sqlStr = "SELECT ebay_id FROM ebay_items_in_items;";
        List <String> ebayIDList = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ebayIDList.add(rs.getString("ebay_id"));
            }
        } catch (SQLException e) {
            System.out.println("ebayItemSQLService.java");
            e.printStackTrace();
            return null;
        } finally {
            s.closeConnection();
        }
        return ebayIDList;
    }

    //add item
    //delete item
    //
}
