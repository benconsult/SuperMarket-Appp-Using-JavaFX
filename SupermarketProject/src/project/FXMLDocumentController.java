/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Dialog;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author Rebecca
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane paneOuter;
    @FXML
    private Pane paneInner;
    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXPasswordField txtPass;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private ImageView image;
String user = "admin";
String pass = "admin";
    @FXML
    private Label txtError;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(!DashboardController.isSplash){
        loadScreen();
        }
        
        
    }    

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        if(txtUser.getText().contains(user) && (txtPass.getText().contains(pass))){
        
        Parent dashboard = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Dashboard");
    }
        else{
        
        txtError.setText("Incorrect username or password");
        
        }
    }
    public void loadScreen(){
      
        try {
            DashboardController.isSplash=true;
            StackPane pane = FXMLLoader.load(getClass().getResource("Splash.fxml"));//loads splash screen
            anchor.getChildren().setAll(pane);
            FadeTransition fadein = new FadeTransition(Duration.seconds(1), pane);
            fadein.setFromValue(1);
            fadein.setToValue(0);
            fadein.setCycleCount(1);
            
            FadeTransition fadeout = new FadeTransition(Duration.seconds(1), pane);
            fadeout.setFromValue(0);
            fadeout.setToValue(1);
            fadeout.setCycleCount(0);
            
            fadein.play();//activates fade in transition
            //after the fadeIn transition finishes
            fadein.setOnFinished((e)-> {
            fadeout.play();//activates fadeout transition after fade in
            
            });
            //after fadeout transition finishes
            fadeout.setOnFinished((e)->{
                try {
                    AnchorPane next =FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));//loads homepage after splash screen
                    anchor.getChildren().setAll(next);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
    
    }
}
