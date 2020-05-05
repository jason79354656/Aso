package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author F
 */
public class SampleController implements Initializable {

    @FXML
    private Button btnBoton;

    public SampleController() {
    	btnBoton = new Button (); 
    	btnBoton.setOnAction(e -> click(e));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click(ActionEvent event) {
      
    	System.out.print("rayos");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewGenrator.fxml"));
    
      
    	try {
    		Parent root =  loader.load();
    		Stage stage = new Stage();
    		stage.setScene(new  Scene(root));
    		stage.show();
    		Stage windowstrart = (Stage) this.btnBoton.getScene().getWindow();
    		windowstrart.close();
    	} catch (IOException e) {
		
    	}
    
    }
    
}
