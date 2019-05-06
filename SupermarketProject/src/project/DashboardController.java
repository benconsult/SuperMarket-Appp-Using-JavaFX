/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rebecca
 */
public class DashboardController implements Initializable {
public static Boolean isSplash=false;
    @FXML
    private JFXButton btnProduct;
    @FXML
    private JFXButton btnCustomers;
    @FXML
    private JFXButton btnSupplier;
    @FXML
    private JFXButton btnInventory;
    @FXML
    private JFXButton btnOrders;
    @FXML
    private Label btnHome;
    @FXML
    private Label btnExit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleProducts(ActionEvent event) throws IOException {
        Parent product = FXMLLoader.load(getClass().getResource("Product.fxml"));
        
        Scene scene = new Scene(product);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app.setScene(scene);
         app.show();
         app.setTitle("Product");
 
    }

    @FXML
    private void handleCustomers(ActionEvent event) throws IOException {
        Parent customer = FXMLLoader.load(getClass().getResource("Customer.fxml"));
        
        Scene scene = new Scene(customer);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app.setScene(scene);
         app.show();
       
    }

    @FXML
    private void handleSupplers(ActionEvent event) throws IOException {
        Parent supplier = FXMLLoader.load(getClass().getResource("Supplier.fxml"));
        
        Scene scene = new Scene(supplier);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app.setScene(scene);
         app.show();
         app.setTitle("Supplier");
 
    }

    @FXML
    private void handleInventory(ActionEvent event) throws IOException {
         Parent inventory = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
        
        Scene scene = new Scene(inventory);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app.setScene(scene);
         app.show();
         app.setTitle("Inventory");
 
    }

    @FXML
    private void handleOrders(ActionEvent event) throws IOException {
        Parent order = FXMLLoader.load(getClass().getResource("Order.fxml"));
        
        Scene scene = new Scene(order);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app.setScene(scene);
         app.show();
         app.setTitle("Order");
 
    }

    @FXML
    private void handleHome(MouseEvent event) throws IOException {
        Parent adminLog = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(adminLog);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app.setScene(scene);
         app.show();
         
    }

    @FXML
    private void handleExit(MouseEvent event) {
        System.exit(0);
    }
    
}
