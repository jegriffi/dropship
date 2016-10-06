package Services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by james on 9/16/2016.
 */
public class Service {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql:///dropshipdb";
    private final String db = "dropshipdb";
    private static final String user = "root";
    private static final String pass = "futurama5";
    private static Connection conn;

    public Service() {
        startConnection();
    }

    public static Connection getSqlConnection() {
        return conn;
    }

    public static void startConnection() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.print("Service.java ");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("Service.java ");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.print("Service.java ");
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            System.out.print("Service.java ");
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.print("Service");
            e.printStackTrace();
        }
    }

    public static void forward(HttpServletRequest request, HttpServletResponse response, String url) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
