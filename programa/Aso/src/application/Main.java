package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		/*try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/view/Sample.fxml"));
			root.setId("pane");
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("/style/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
			try {
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("/view/Sample.fxml"));
	            Pane ventana = (Pane) loader.load();
	            ventana.setId("pane");
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(ventana);
	            scene.getStylesheets().add(getClass().getResource("/style/application.css").toExternalForm());
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public static void main(String[] args) {
		launch(args);
	}
}