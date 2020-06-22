package view;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;
import java.io.File;

import static javafx.geometry.Pos.CENTER;

public class MainWindow  extends Application{
    private Alert alert;
    private Button scriptButton,copyButton,run;
    private Label scriptLabel,copyLabel;
    private Text loopFile;
    private FileChooser fileChooser;
    private String pathCopy,pathScript;
    private boolean readyCopy,readyScript;

    @Override public void init(){
        loopFile = new Text("Busque los archivos");
        scriptButton = new Button("Add Script");
        copyButton = new Button("Add copyright");
        scriptLabel = new Label("label1");
        copyLabel = new Label("label2");
        run = new Button("Ejecutar");
        scriptButton.setOnAction(e -> findScript());
        copyButton.setOnAction(e -> findCopy());
        stateDefaultComponents();
    }

    @Override public void start(Stage stage){

        GridPane gridpane = new GridPane();
        //gridpane.setMinSize(300,300);
        gridpane.setPadding(new Insets(10,10,10,10));
        gridpane.setHgap(5);
        gridpane.setVgap(15);
        gridpane.setAlignment(CENTER);

        gridpane.add(scriptButton,0,0,2,1);
        gridpane.add(scriptLabel,2,0);
        gridpane.add(copyButton,0,1,2,1);
        gridpane.add(copyLabel,2,1);

        BorderPane root = new BorderPane();
        root.setMinSize(400,200);
        root.setAlignment(loopFile,Pos.BOTTOM_CENTER);
        root.setTop(loopFile);
        root.setCenter(gridpane);
        root.setAlignment(run,Pos.CENTER);
        root.setMargin(run,new Insets(10,10,10,10));
        root.setBottom(run);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("practica 4");
        stage.show();
    }


    private void stateDefaultComponents(){
        loopFile.setFont(new Font("Monospaced", 20));
        scriptLabel.setText("no esta preparado");
        scriptLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12;");
        copyLabel.setText("no esta preparado");
        copyLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12;");
        run.setMinSize(60,40);
        run.setDisable(true);
    }



    public void findScript(){
        fileChooser = new FileChooser();
        fileChooser.setTitle("busqueda del script bash");
        //add los filtros
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("bash","*.sh"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null){
            pathScript = selectedFile.getAbsolutePath();
            readyScript = true;
            scriptLabel.setText("preparado");
            scriptLabel.setStyle("-fx-text-fill: green; -fx-font-size: 12;");
        }
        if(isReady())
            run.setDisable(false);


    }

    public void findCopy(){
        fileChooser = new FileChooser();
        fileChooser.setTitle("busqueda de un copyright");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("texto","*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null){
            pathCopy = selectedFile.getAbsolutePath();
            readyCopy = true;
            copyLabel.setText("preparado");
            copyLabel.setStyle("-fx-text-fill: green; -fx-font-size: 12;");
        }
        if(isReady())
            run.setDisable(false);
    }

    public boolean isReady(){
        boolean flag = false;
        if (readyCopy && readyScript){
            flag = true;
            run.setOnAction(e -> runScript(pathScript,pathCopy));
        }
        return flag;
    }

    public void runScript(String script,String copyright){
        String command = "./ejecutador.sh";
        try{
            Process process = new ProcessBuilder(command,script,copyright).start();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("realizado");
        alert.setHeaderText("realizado exitosamente");
        alert.setContentText("fueron agredas las lineas del archivo .txt");
        alert.showAndWait();
        stateDefaultComponents();
    }

    public static void main(String[] args){ launch(); }
}
