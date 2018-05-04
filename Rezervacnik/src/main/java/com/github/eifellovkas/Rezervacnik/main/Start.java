package com.github.eifellovkas.Rezervacnik.main;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.ui.ControllerUvodniMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
	}
	
	@Override
	public void stop() throws Exception {
		 restaurace.uloz(1);
		 restaurace.uloz(2);
	     System.out.println("konec");
	}
	
}
