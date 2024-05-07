package project.alphasolutionsproject.repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection con;

    public static Connection getConnection(String url, String user, String pass) {

        if (con != null) return con;

        try {

        con = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            System.out.println("Couldnt connect. Try again later.");
            e.printStackTrace();
        }
        return con;
    }
}
