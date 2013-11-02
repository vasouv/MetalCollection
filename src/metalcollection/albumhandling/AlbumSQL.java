/*
 * This work is licensed under a 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 */

package metalcollection.albumhandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vasouv
 */
public class AlbumSQL {
    
    private Connection connection = null;
    private Statement statement = null;
    
    private void connected() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:albums.db");
            statement = connection.createStatement();
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void closed() {
        try {
            connection.close();
            statement.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
