/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metalcollection.insertalbum;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metalcollection.albumhandling.AlbumSQL;
import metalcollection.albumhandling.Album;

/**
 * FXML Controller class
 *
 * @author vasouv
 */
public class InsertAlbumController implements Initializable {

    @FXML
    Button insertBtn, cancelBtn;
    
    @FXML
    private TextField insBandTxt, insAlbumTxt, insReleaseTxt, insGenreTxt;
    
    AlbumSQL albumsql = new AlbumSQL();
    
    @FXML
    private void insert(ActionEvent e) throws SQLException {
        
        Album al = new Album();
        
        al.setId(albumsql.getMaxId());
        al.setBand(insBandTxt.getText().toString());
        al.setTitle(insAlbumTxt.getText().toString());
        al.setRelease(insReleaseTxt.getText().toString());
        al.setGenre(insGenreTxt.getText().toString());
        
        albumsql.insertAlbum(al);
        System.out.println("Calling albumsql to insert");
        
        Stage stage = (Stage)insertBtn.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage)cancelBtn.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
