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
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class GeneratorController implements Initializable {

    @FXML
    private Button btnBoton;
    private MenuItem itmCreate;
   
    
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
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewAddproces.fxml"));
    	try {
    		Parent root =  loader.load();
    		Stage stage = new Stage();
    		stage.initModality(Modality.APPLICATION_MODAL);
    		stage.setScene(new  Scene(root));
    		stage.show();
		
    		} catch (IOException e) {
		
    	}
    
    }
}







