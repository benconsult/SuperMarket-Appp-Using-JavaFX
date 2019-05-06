/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rebecca
 */
public class OrderController implements Initializable {

    @FXML
    private JFXTextField paymentmode;
    @FXML
    private JFXTextField receiptid;
    @FXML
    private JFXTextField tendering;
    @FXML
    private JFXTextField change;
    @FXML
    private JFXTextField issued;
    @FXML
    private JFXTextField amount;
    @FXML
    private TextArea textarea;
    @FXML
    private JFXTextField total;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton print;
    @FXML
    private ImageView imgClose;
    @FXML
    private JFXTextArea textOutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveHandle(ActionEvent event) throws IOException {
        //to save to file for printing
        Stage stage = new Stage();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("save file");
        File selectedfile = chooser.showOpenDialog(stage);
        FileWriter fw = new FileWriter(selectedfile.getAbsolutePath());
        fw.write("------------------------"+"\n");
        fw.write("BENSON SUPERMAKKET"+"\n"+"\n");
        fw.write("------------------------"+"\n");
        fw.write(receiptid.getText()+"\n");
        fw.write(paymentmode.getText()+"\n");
        fw.write("------------------------"+"\n");
        fw.write(textarea.getText()+"\n");
        fw.write(tendering.getText()+"\n");
        fw.write(change.getText()+"\n");
        fw.write("------------------------"+"\n");
        fw.write(amount.getText()+"\n");
        fw.write(total.getText()+"\n");
        fw.write("------------------------"+"\n");
        fw.write(issued.getText()+"\n");
        fw.write(tendering.getText()+"\n");
        fw.write("-------------------------"+"\n");
   fw.write("Thanks for your patronage....\n"+"Goods bought are not refundable");
       
        fw.close();  
    }

    @FXML
    private void printHandle(ActionEvent event) throws IOException {
        //to read from file and view through textarea
        Stage stage = new Stage();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("open file");
        File selectedfile = chooser.showOpenDialog(stage);
        FileReader fr = new FileReader(selectedfile.getAbsolutePath().toString());
        BufferedReader br = new BufferedReader(fr);
        StringBuilder bd = new StringBuilder();
        String myText="";
        while((myText=br.readLine()) !=null){
         bd.append(myText + "\n");
    }
        textOutput.setText(bd.toString());
        ;    
    }

    @FXML
    private void handleExit(MouseEvent event) throws IOException {
       Parent dashboard = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        
        Scene scene = new Scene(dashboard);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app.setScene(scene);
         app.show();
         app.setTitle("DashBoard");
 
    }
    
}
