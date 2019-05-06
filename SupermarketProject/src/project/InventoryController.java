/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import project.Inventory;
/**
 * FXML Controller class
 *
 * @author Rebecca
 */
public class InventoryController implements Initializable {

    @FXML
    private AnchorPane anchorInventory;
    @FXML
    private Pane paneUp;
    @FXML
    private TableView<Inventory> tableInventory;
    @FXML
    private TableColumn<Inventory, String> colId;
    @FXML
    private TableColumn<Inventory, String> colbname;
    private TableColumn<Inventory, String> quColumn;
    @FXML
    private TableColumn<Inventory, String> colP;
    @FXML
    private TableColumn<Inventory, String> colVal;
    @FXML
    private TableColumn<Inventory, String> colIsRet;
    @FXML
    private TableColumn<Inventory, String> colDate;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private ImageView closeImage;
    @FXML
    private Pane paneDown;
    @FXML
    private JFXButton btn_save;
    @FXML
    private JFXButton btn_clear;
    @FXML
    private JFXButton btn_delete;

    @FXML
    private TableColumn<Inventory, String> colQ;
    @FXML
    private JFXTextField txtBn;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txPrice;
    @FXML
    private JFXTextField txQty;
    @FXML
    private JFXTextField txtDate;
    @FXML
    private JFXTextField txVal;
    @FXML
    private JFXTextField txtIsR;

    ObservableList com = FXCollections.observableArrayList(
    new Inventory("A", "Beverages", "2", "400", "800", "Yes", LocalDate.now()),
    new Inventory("B", "Frozen Foods", "78", "700", "800", "No", LocalDate.now()),
    new Inventory("C", "Personal Care", "23", "800", "800", "Yes", LocalDate.now()),
    new Inventory("A", "Beverages", "89", "900", "800", "Yes", LocalDate.now()), 
    new Inventory("C", "Personal care", "24", "300", "800", "Yes", LocalDate.now()),
    new Inventory("B", "Frozen Food", "56", "400", "800", "Yes", LocalDate.now())       
            
);
    FilteredList filter = new FilteredList(com, e-> true);
    @FXML
    private ChoiceBox<String> choicebox;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //comboRet.getItems().addAll("Yes","No");
       //.addAll("Yes","No");  
      
        choicebox.getItems().addAll("Yes","No");
        colId.setCellValueFactory(new PropertyValueFactory<> ("id"));
        colbname.setCellValueFactory(new PropertyValueFactory<> ("batchname"));
        colQ.setCellValueFactory(new PropertyValueFactory<> ("quantity"));
        colP.setCellValueFactory(new PropertyValueFactory<> ("price"));
        colVal.setCellValueFactory(new PropertyValueFactory<> ("value"));
        colIsRet.setCellValueFactory(new PropertyValueFactory<> ("isreturned"));
        colDate.setCellValueFactory(new PropertyValueFactory<> ("date"));
        tableInventory.setEditable(true);
        tableInventory.setItems(com);//to load dummy table into the tableview
    }    
   
//SAVE METHOD
    @FXML
    private void handleSave(ActionEvent event) {
        Inventory invent = new Inventory(txtId.getText(), txtBn.getText(), txQty.getText(), txPrice.getText(), txVal.getText(), txtIsR.getText(), LocalDate.now());
       tableInventory.getItems().addAll(invent);//adding new entry table objects into tableview
    }
//CLEAR METHOD
    @FXML
    private void handleClear(ActionEvent event) {
        txtId.clear();
        txtBn.clear();
        txQty.clear();
        txPrice.clear();
        txVal.clear();
        txtIsR.clear();
        txtDate.clear();
    }
//DELETE METHOD
    @FXML
    private void handleDelete(ActionEvent event) {
        //method to delete observable dummy object and new entry elements
        ObservableList inventorySelected, allInvent;
        allInvent = tableInventory.getItems();
        inventorySelected= tableInventory.getSelectionModel().getSelectedItems();
        inventorySelected.forEach(allInvent::remove);
    }
//METHOD TO ADD COMBO VALUES INTO TEXTFIELD

    @FXML
    private void handleChoice(MouseEvent event) {
        txtIsR.setText(choicebox.getValue().toString());
    }

    @FXML
    private void handleSearch(KeyEvent event) {
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate((Predicate<? super Inventory>) (Inventory invent)-> {
            if(newValue.isEmpty() || newValue==null){
            return true;
            }
            else if(invent.getId().contains(newValue) || invent.getBatchname().contains(newValue)){
                return true;
            }
            return false;//set predicate return value to false
        });
            
        });
        //sort elements
        SortedList sort = new SortedList(filter);//sort the filtered element
        sort.comparatorProperty().bind(tableInventory.comparatorProperty());//read only
        tableInventory.setItems(sort);//set sorted items
    
    }

    @FXML
    private void handleClose(MouseEvent event) throws IOException {
         Parent dashboard = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        
        Scene scene = new Scene(dashboard);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app.setScene(scene);
         app.show();
       app.setTitle("Dashboard");
        
    }
}
