/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cd_collections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

/**
 *
 * @author confi
 */
public class AdminGenre {

    private Connection conn;
    private String url = "jdbc:mysql://localhost/music";
    private String username = "root";
    private String password = "root";

    public AdminGenre() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // insert genre
    public void insertGenre(Genre genre) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO genres (genre_name) VALUES (?)");
        stmt.setString(1, genre.getName());
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected + " row(s) inserted.");
        stmt.close();

    }

    // update genre
    public void updateGenre(Genre genre) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE genres SET genre_name = ? WHERE genre_id = ?");
        stmt.setString(1, genre.getName());
        stmt.setInt(2, genre.getId());
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected + " row(s) updated.");
        stmt.close();

    }

    // delete genre
//    public void deleteGenre(Genre genre) throws SQLException{
//       PreparedStatement stmt = conn.prepareStatement("DELETE FROM genres WHERE genre_id = ?");
//            stmt.setInt(1, genre.getId());
//            int rowsAffected = stmt.executeUpdate();
//            System.out.println(rowsAffected + " row(s) deleted.");
//        
//    }
    // get all genre
    public void getAll() throws SQLException {
        Statement stmt = conn.createStatement();
        String selectQuery = "SELECT * FROM genres";
        ResultSet rs = stmt.executeQuery(selectQuery);
        List<Genre> genres = new ArrayList<>();
        while (rs.next()) {
            int genreId = rs.getInt("genre_id");
            String genreName = rs.getString("genre_name");
            genres.add(new Genre(genreId, genreName));
        }
        Genre[] genreArray = genres.toArray(new Genre[genres.size()]);
        for (Genre genre : genreArray) {
            System.out.println(genre.getId() + " " + genre.getName());
        }
        stmt.close();
    }

//    public static void main(String[] args) {
//        AdminGenre admin = new AdminGenre();
//        admin.getAll();
//    }
    public void deleteGenre(int genreId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM genres WHERE genre_id = ?");
        stmt.setInt(1, genreId);
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected + " row(s) deleted.");
        stmt.close();
    }

    public void close() throws SQLException {
        this.conn.close();
    }

}
