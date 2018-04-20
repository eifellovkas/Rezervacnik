package com.github.eifellovkas.Rezervacnik.main;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.ui.ControllerUvodniMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application{

	public static void main(String[] args) {
            launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/uvodniMenu.fxml"));    	
    	Parent root = loader.load();
    	Restaurace restaurace = new Restaurace();
    	
    	ControllerUvodniMenu controller = loader.getController(); 	
    	controller.inicializuj(restaurace);
    	
    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    	primaryStage.setTitle("Úvodní menu aplikace");
	}
}
