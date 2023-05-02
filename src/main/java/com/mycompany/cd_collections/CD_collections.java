

package com.mycompany.cd_collections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author confi
 */
public class CD_collections {

    public static void main(String[] args) {
        AdminGenre admin = new AdminGenre();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add new genre");
            System.out.println("2. Update genre");
            System.out.println("3. Delete genre");
            System.out.println("4. Show all genres");
            System.out.println("5. Exit");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter genre name:");
                    String name = sc.next();
                    Genre genre = new Genre(name);
                {
                    try {
                        admin.insertGenre(genre);
                    } catch (SQLException ex) {
                      System.out.println(ex);
                    }
                }
       
                    break;

                case 2:
                    System.out.println("Enter genre id:");
                    int id = sc.nextInt();
                    System.out.println("Enter new genre name:");
                    String newName = sc.next();
                    Genre updatedGenre = new Genre(id, newName);
                    try {
                    admin.updateGenre(updatedGenre);
                    }catch(SQLException ex){
                     System.out.println(ex);
                    }
                    break;
                case 3:
                    System.out.println("Enter genre id:");
                    int genreId = sc.nextInt();
                    try{
                    admin.deleteGenre(genreId);
                    }catch(SQLException ex){
                    System.out.println(ex);
                    }
                    break;
                case 4:
                {
                    try {
                        admin.getAll();
                    } catch (SQLException ex) {
                       System.out.println(ex);
                        
                    }
                }
                    break;

                case 5:
                {
                    try {
                        admin.close();
                    } catch (SQLException ex) {
                        System.out.println("Error closing");
                    }
                }
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
    }

