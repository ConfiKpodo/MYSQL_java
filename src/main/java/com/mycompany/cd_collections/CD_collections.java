

package com.mycompany.cd_collections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



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
                    admin.insertGenre(genre);
                    break;
                case 2:
                    System.out.println("Enter genre id:");
                    int id = sc.nextInt();
                    System.out.println("Enter new genre name:");
                    String newName = sc.next();
                    Genre updatedGenre = new Genre(id, newName);
                    admin.updateGenre(updatedGenre);
                    break;
                case 3:
                    System.out.println("Enter genre id:");
                    int genreId = sc.nextInt();
                    admin.deleteGenre(genreId);
                    break;
                case 4:
                    admin.getAll();
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
    }

