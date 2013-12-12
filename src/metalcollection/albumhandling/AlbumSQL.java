/*
 * This work is licensed under a 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 */

package metalcollection.albumhandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
            connection = DriverManager.getConnection("jdbc:sqlite:metalalbums.sqlite");
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
    
    public void insertAlbum(Album album) {
        try {
            connected();
            String insertSQL = "insert into collection values(" + album.getId() + ",'" + album.getBand() + "','" + album.getTitle() + "'," + album.getRelease() + ",'" + album.getGenre() + "')";
            statement.executeUpdate(insertSQL);
            System.out.println("Album added");
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            closed();
        }
    }
    
    public void deleteAlbum(int id) {
        try {
            connected();
            statement.executeUpdate("delete from collection where id=" + id);
        } 
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        finally {
            closed();
        }
    }
    
    /*
    * This method retrieves the largest ID value of the table, which is used
    * as the ID of the next album to be inserted.
    */
    public int getMaxId() throws SQLException {
        connected();
        
        int maxId = 0;
        
        ResultSet max = statement.executeQuery("select max(id) from collection");
        
        max.next();
        
        maxId = max.getInt(1);
        
        max.close();
        
        closed();
        
        return maxId + 1;
    }
    
    public ObservableList<Album> listAlbum() {
        try {
            connected();
            ObservableList<Album>list = FXCollections.observableArrayList();
            ResultSet show = statement.executeQuery("select * from collection");
            
            while(show.next()) {
                Album album = new Album();
                
                album.setId(show.getInt(1));
                album.setBand(show.getString(2));
                album.setTitle(show.getString(3));
                album.setRelease(show.getString(4));
                album.setGenre(show.getString(5));
                
                list.add(album);
            }
            
            return list;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        finally {
            closed();
        }
    }
}
