/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static com.sun.javafx.image.impl.ByteArgb.accessor;
import com.sun.javafx.tk.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.imageio.stream.FileImageInputStream;

/**
 * FXML Controller class
 *
 * @author Rebecca
 */
public class SupplierController implements Initializable {

   

    /**
     * Initializes the controller class.
     */
    private FileChooser filechooser;
    private File filePath;
    private Supplier selectedSupplier;
    @FXML
    private JFXButton btnBrowse;
    @FXML
    private AnchorPane anchorSupplier;
    @FXML
    private ImageView photos;
    @FXML
    private Pane paneUp;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtFirstname;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtLast;
    @FXML
    private JFXTextField txtCoy;
    @FXML
    private JFXTextField txtPhone;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtPhoto;
    @FXML
    private Pane paneDown;
    @FXML
    private TableColumn<Supplier, String> colId;
    @FXML
    private TableColumn<Supplier, String> colFirst;
    @FXML
    private TableColumn<Supplier, String> colLast;
    @FXML
    private TableColumn<Supplier, String> colCoy;
    @FXML
    private TableColumn<Supplier, String> colEmail;
    @FXML
    private TableColumn<Supplier, String> colPhone;
    @FXML
    private TableColumn<Supplier, String> colAdd;
    @FXML
    private TableColumn<Supplier, Image> colPhoto;
    @FXML
    private TableView<Supplier> table;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnCLear;
    FileInputStream fis;
    ObservableList sup = FXCollections.observableArrayList(
    
    new Supplier("1", "Wale", "Lanre", "Latex Holdings", "walex123@yahoo.com", "09075647576", "Oluyole",Image.impl_fromPlatformImage(selectedSupplier)),
    new Supplier("2", "Ibrahim", "Efuntoye", "Albert Nig LTD", "albergmail.com", "7064535637", "Olorunsogo",Image.impl_fromPlatformImage(selectedSupplier))
    );
    @FXML
    private JFXButton loady;
    @FXML
    private JFXButton btnExit;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colId.setCellValueFactory(new PropertyValueFactory<> ("id"));
       colFirst.setCellValueFactory(new PropertyValueFactory<> ("firstname"));
       colLast.setCellValueFactory(new PropertyValueFactory<> ("lastname"));
       colCoy.setCellValueFactory(new PropertyValueFactory<> ("companyname"));
       colEmail.setCellValueFactory(new PropertyValueFactory<> ("email"));
       colPhone.setCellValueFactory(new PropertyValueFactory<> ("phonenumber"));
       colAdd.setCellValueFactory(new PropertyValueFactory<> ("address"));
       colPhoto.setCellValueFactory(new PropertyValueFactory<> ("photo"));
       table.setItems(sup);
       //colPhoto.setGraphic(txtPhoto);
    }    

    @FXML
    private void chooseImageButtonPushed(ActionEvent event) {
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        filechooser = new FileChooser();
        filechooser.setTitle("open image");
        
        //set to user's directory or go to default C drive if cannot access
        String userDirectoryString  = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);
        
        if(!userDirectory.canRead())
            userDirectory = new File("c:/");
        
        filechooser.setInitialDirectory(userDirectory);
        this.filePath = filechooser.showOpenDialog(stage);
        
        //try to update the image by loading the new image
        try{
        BufferedImage bufferedimage = ImageIO.read(filePath);
        Image image = SwingFXUtils.toFXImage(bufferedimage, null);
        photos.setImage(image);
        photos.setImage(photos.getImage());
       
        }
        catch(IOException e){
        System.err.println(e.getMessage());
        }
        
    }

    @FXML
    private void handleDeleteButton(ActionEvent event) {
        ObservableList supplierSelected, allSupplier;
        allSupplier = table.getItems();
        supplierSelected= table.getSelectionModel().getSelectedItems();
        supplierSelected.forEach(allSupplier::remove);
    
    }

    @FXML
    private void handleClearButton(ActionEvent event) {
        txtId.clear();
        txtFirstname.clear();
        txtLast.clear();
        txtCoy.clear();
        txtEmail.clear();
        txtPhone.clear();
        txtAddress.clear();
    }

    @FXML
    private void handleSaveButton(ActionEvent event){
        Supplier supplier = new Supplier(txtId.getText(), txtFirstname.getText(), txtLast.getText(), txtCoy.getText(), 
                txtEmail.getText(), txtPhone.getText(),txtAddress.getText(), Image.impl_fromPlatformImage(selectedSupplier));
        table.getItems().addAll(supplier);
        //FileInputStream fis = new FileInputStream(filePath);
      //Image.impl_fromPlatformImage(selectedSupplier)
    }

    @FXML
    private void handleLoad(ActionEvent event) throws FileNotFoundException {
        //fis = new FileInputStream(filePath);
        //colPhoto.setText(photos.toString());
        //txtPhoto.setText(photos.toString());
        //Image.impl_fromPlatformImage(photos);
        //photos.setImage(new Image(txtPhoto.getText()));
        
      txtPhoto.setText(photos.getImage().toString());
    }

    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        
        Scene scene = new Scene(dashboard);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app.setScene(scene);
         app.show();
       app.setTitle("Dashboard");
    }
}
