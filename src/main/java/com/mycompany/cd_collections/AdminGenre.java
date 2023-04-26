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

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/music";
        String username = "root";
        String password = "nascoict1";
            try {
            Connection conn = DriverManager.getConnection(url, username, password);
            
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
            
        
        }
  
    //methods
            //insert genre
       public void insertGenre(Genre genre){
           try{
           Statement stmt = conn.createStatement();
            String insertQuery = "INSERT INTO genres (genre_name) VALUES ('James')";
            int rowsAffected = stmt.executeUpdate(insertQuery);
            System.out.println(rowsAffected + " row(s) inserted.");
           }catch(SQLException e){
               System.out.println("Error: " + e.getMessage());
           }
       }
        //update genre
        public void updateGenre(Genre genre){
            try{
           Statement stmt = conn.createStatement();
            String updateQuery = "UPDATE genres  SET genre_name 'BeastNation' WHERE genre_id = 4;";
            int rowsAffected = stmt.executeUpdate(updateQuery);
            System.out.println(rowsAffected + " row(s) inserted.");
           }catch(SQLException e){
               System.out.println("Error: " + e.getMessage());
           }
        }
        
        //delete genre
        public void deleteGenre(Genre genre){
            try{
           Statement stmt = conn.createStatement();
            String updateQuery = "DELETE * FROM  WHERE genre_id = 4;";
            int rowsAffected = stmt.executeUpdate(updateQuery);
            System.out.println(rowsAffected + " row(s) inserted.");
           }catch(SQLException e){
               System.out.println("Error: " + e.getMessage());
           }
        }
        
        //get all genre
        public void getAll(){
            
        }
}

