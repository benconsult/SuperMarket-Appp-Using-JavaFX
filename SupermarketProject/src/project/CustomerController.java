/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rebecca
 */
public class CustomerController implements Initializable {

    @FXML
    private AnchorPane anchorCustomer;
    @FXML
    private Pane paneFirst;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtFname;
    @FXML
    private JFXTextField txtLname;
    @FXML
    private JFXTextField txtJtitle;
    @FXML
    private JFXTextField txtPnum;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtSx;
    @FXML
    private JFXButton btnDel;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnRefresh;
    @FXML
    private JFXRadioButton radioFemale;
    @FXML
    private JFXRadioButton radioMale;
    @FXML
    private Pane paneSec;
    @FXML
    private TableView<Customer> table;
    @FXML
    private TableColumn<Customer, String> colId;
    @FXML
    private TableColumn<Customer, String> colFna;
    @FXML
    private TableColumn<Customer, String> colLn;
    @FXML
    private TableColumn<Customer, String> colJt;
    @FXML
    private TableColumn<Customer, String> colPhn;
    @FXML
    private TableColumn<Customer, String> colAddress;
    @FXML
    private TableColumn<Customer, String> colSex;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private ImageView imgClose;
ObservableList cust = FXCollections.observableArrayList(
   new Customer("1", "Aliu", "David", "Teacher", "07064529675", "Adeleke street", "male"),
   new Customer("2", "Wumi", "Sokeye", "Student", "07084729675", "Oja oba street", "female"),
    new Customer("3", "Quazim", "Raheem", "Trader", "0810645275", "Eleyele street", "male"),
    new Customer("4", "Aliu", "David", "Fashion Designer", "09006452675", "Jericho mall ", "female"),
    new Customer("5", "Muyiwa", "Dauda", "Nurse", "09064529675", "Dugbestreet", "male"),
    new Customer("6", "Tope", "Adeyemi", "Bricl layer", "08064529675", "Agbeni street", "male")


);
 FilteredList filter = new FilteredList(cust, e-> true);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colSex.setText(radioFemale.getText());
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFna.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        colLn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        colJt.setCellValueFactory(new PropertyValueFactory<>("jobtittle"));
        colPhn.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        table.setItems(cust);
    }    

    @FXML
    private void handleDelete(ActionEvent event) {
        ObservableList customerSelected, allCustomer;
        allCustomer = table.getItems();
        customerSelected= table.getSelectionModel().getSelectedItems();
        customerSelected.forEach(allCustomer::remove);
    
    }

    @FXML
    private void handleSave(ActionEvent event) {
        Customer customer = new Customer(txtId.getText(), txtFname.getText(), txtLname.getText(), txtJtitle.getText(), 
                txtPnum.getText(), txtAddress.getText(), txtSx.getText());
        table.getItems().addAll(customer);
        
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
        txtId.clear();
        txtFname.clear();
        txtLname.clear();
        txtJtitle.clear();
        txtPnum.clear();
        txtAddress.clear();
        txtSx.clear();
    }

    @FXML
    private void handleSearch(KeyEvent event) {
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate((Predicate<? super Customer>) (Customer customer)-> {
            if(newValue.isEmpty() || newValue==null){
            return true;
            }
            else if(customer.getId().contains(newValue) || customer.getFirstname().contains(newValue) || customer.getSex().contains(newValue)){
                return true;
            }
            return false;//set predicate return value to false
        });
            
        });
        //sort elements
        SortedList sort = new SortedList(filter);//sort the filtered element
        sort.comparatorProperty().bind(table.comparatorProperty());//read only
        table.setItems(sort);//set sorted items
    
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

    @FXML
    private void radioFemale(MouseEvent event) {
         txtSx.setText(radioFemale.getText());
    }

    @FXML
    private void handleMale(MouseEvent event) {
         txtSx.setText(radioMale.getText());
    }
    
}
