

package com.mycompany.cd_collections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author confi
 */
public class CD_collections {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/music";
        String username = "root";
        String password = "nascoict1";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Coonection successful");
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
            
        }
    }

