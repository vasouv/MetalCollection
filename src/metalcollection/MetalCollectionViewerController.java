/*
 * This work is licensed under a 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 */

package metalcollection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import metalcollection.albumhandling.Album;
import metalcollection.albumhandling.AlbumSQL;
import metalcollection.insertalbum.*;

/**
 *
 * @author vasouv
 */
public class MetalCollectionViewerController implements Initializable {
    
    @FXML
    public TableView<Album> table;
    
    @FXML
    public TableColumn<Album,String> band, title, genre;
    
    @FXML
    public TableColumn<Album,Integer> id, release;
    
    @FXML
    public ObservableList<Album> list = FXCollections.observableArrayList();
    
    AlbumSQL albumSQL = new AlbumSQL();
    
    @FXML
    public Button btnAdd, btnDelete, btnRefresh;
    
    @FXML
    private void insert(ActionEvent e) throws IOException {
        new InsertAlbumMain().start(new Stage());
    }
    
    @FXML
    private void refresh(ActionEvent e){
        list = albumSQL.listAlbum();
        table.setItems(list);
        System.out.println("Refresh button pressed");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<Album,Integer>("id"));
        band.setCellValueFactory(new PropertyValueFactory<Album,String>("band"));
        title.setCellValueFactory(new PropertyValueFactory<Album,String>("title"));
        release.setCellValueFactory(new PropertyValueFactory<Album,Integer>("release"));
        genre.setCellValueFactory(new PropertyValueFactory<Album,String>("genre"));        
        //table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //list = ssql.listStudent();
        list = albumSQL.listAlbum();
        table.setItems(list);
    }    
    
}
