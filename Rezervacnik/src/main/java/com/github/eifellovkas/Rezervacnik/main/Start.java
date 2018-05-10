package com.github.eifellovkas.Rezervacnik.main;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.ui.ControllerUvodniMenu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Start extends Application{
	private Restaurace restaurace = new Restaurace();
	
	public static void main(String[] args) {
            launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/uvodniMenu.fxml"));    	
    	Parent root = loader.load();
    	restaurace = new Restaurace();
    	
    	ControllerUvodniMenu controller = loader.getController(); 	
    	controller.inicializuj(restaurace);
    	
    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    	primaryStage.setTitle("Úvodní menu aplikace");
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			public void handle(WindowEvent event) {
				Platform.exit();
			}
    		
    	});
	}
	
	@Override
	public void stop() throws Exception {
		 restaurace.uloz("src/main/resources/logika/stoly.txt",1);
		 restaurace.uloz("src/main/resources/logika/rezervace.txt",2);
		 Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Konec aplikace");
			alert.setHeaderText(null);
			alert.setContentText("Aplikace ukončena, všechny záznamy uloženy. Děkujeme že jste ji použili");
			alert.showAndWait();
	}
	
}
