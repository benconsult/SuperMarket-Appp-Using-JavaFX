/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.awt.Dialog;
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
public class ProductController implements Initializable {

    @FXML
    private AnchorPane anchorProduct;
    @FXML
    private Pane paneUp;
    @FXML
    private TableView<Product> tableProduct;
    @FXML
    private TableColumn<Product, String> colId;
    @FXML
    private TableColumn<Product, String> colBnam;
    @FXML
    private TableColumn<Product, String> colProdn;
    @FXML
    private TableColumn<Product, String> colQty;
    @FXML
    private TableColumn<Product, String> colCprice;
    @FXML
    private TableColumn<Product, String> colSprice;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private JFXListView<String> listview;
    @FXML
    private Pane paneDown;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXTextField txtBname;
    @FXML
    private JFXTextField txtPname;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtSp;
    @FXML
    private JFXTextField txtCp;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnAdd;
ObservableList prod = FXCollections.observableArrayList(

    new Product("01","Beverages","cereals","78","148","500"),
new Product("02","Cleaners","liquid detergent","300","150","200"),
new Product("03","Frozen Food","ice cream","67","250","280"),
new Product("04","Paper Goods","paper towels","98","200","250"),
new Product("05","personal Care","shampoo","234","500","50"),
new Product("06","Persnal Care","dettol soap","328","150","180"),
new Product("07","Personal Care","Maclaens","40","300","350"),
new Product("08","Others","baby items","400","1500","1600"),
new Product("09","Paper Goods","Sandwich bags","900","1200","1500"),
new Product("10","Beverages","ginger tea","48","750","800"),
new Product("11","Dairy","cheese","34","230","250"),
new Product("12","Baking Goods","sugar","600","300","350"),
new Product("13","Baking Goods","flour","350","600","680"),
new Product("14","Canned Goods","spaghetti","500","200","220"),
new Product("15","Canned Goods","ketchup","200","100","150"),
new Product("16","Dairy","butter","170","250","300"),
new Product("17","Bakery","sandwich loaves","168","180","200"),
new Product("18","Bakery","dinner rolls","345","150","200"),
new Product("19","Bakery","bagels","232","200","220"),
new Product("20","Beverages","soda","323","400","450"),
new Product("21","Beverages","juice","655","300","320"),
new Product("22","Cannned","spaghetti sauce","243","300","350"),
new Product("23","Baking Goods","mixes","675","400","450"),
new Product("24","Cleaners","dishwashing","453","500","550"),
new Product("24","Produce","fruits","767","220","250"),
new Product("25","Produce","vegetables","435","250","300")





);
 FilteredList filter = new FilteredList(prod, e-> true);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateData();
        colId.setCellValueFactory(new PropertyValueFactory<> ("id"));
        colBnam.setCellValueFactory(new PropertyValueFactory<> ("batchname"));
        colProdn.setCellValueFactory(new PropertyValueFactory<> ("productname"));
        colQty.setCellValueFactory(new PropertyValueFactory<> ("quantity"));
        colCprice.setCellValueFactory(new PropertyValueFactory<> ("costprice"));
        colSprice.setCellValueFactory(new PropertyValueFactory<> ("sellingprice"));
        tableProduct.setItems(prod);
    }    
public void populateData(){
String[] arr= {"cofee","tea","milk","pasta","laundry detergent","ice cream","toilet paper","liquid detergent",
    "paper towel","cereals"
        + "flour","indomie","sparghetti","aluminium foil","batteries","greeting cards","baby items","pet items",
        "shampoo","canoe soap"
,"Viju milk","hollandia youghourt","apple cream"};
  for(String catalog: arr){
      listview.getItems().add(catalog);//create a listview to hold these items
      
  }
}
public void clickList(){
     listview.setOnMouseClicked(event -> {
       String selectedItem=listview.getSelectionModel().getSelectedItem().toString();
     //Dialog d = new Alert(Alert.AlertType.INFORMATION);
     
     });



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
    private void handleClear(ActionEvent event) {
        txtId.clear();
        txtBname.clear();
        txtPname.clear();
        txtQty.clear();
        txtCp.clear();
        txtSp.clear();
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        ObservableList inventorySelected, allProduct;
        allProduct = tableProduct.getItems();
        inventorySelected= tableProduct.getSelectionModel().getSelectedItems();
        inventorySelected.forEach(allProduct::remove);
    
    }

    @FXML
    private void handleAdd(ActionEvent event) {
        
        Product product = new Product(txtId.getText(), txtBname.getText(), txtPname.getText(), txtQty.getText(), 
                txtCp.getText(), txtSp.getText());
        tableProduct.getItems().addAll(product);
        
    }

    @FXML
    private void handleSearch(KeyEvent event) {
         txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate((Predicate<? super Product>) (Product product)-> {
            if(newValue.isEmpty() || newValue==null){
            return true;
            }
            else if(product.getId().contains(newValue) || product.getBatchname().contains(newValue) || product.getProductname().contains(newValue)){
                return true;
            }
            return false;//set predicate return value to false
        });
            
        });
        //sort elements
        SortedList sort = new SortedList(filter);//sort the filtered element
        sort.comparatorProperty().bind(tableProduct.comparatorProperty());//read only
        tableProduct.setItems(sort);//set sorted items
    
    }
    
}
