package com.github.eifellovkas.Rezervacnik.main;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Soubor;
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

/*******************************************************************************
 * Třída Start slouží ke spuštění aplikace
 *
 * @author     Martin Havlík, havlikmar
 * @version    LS 2017/2018 (upraveno 11.5.2018)
 */
public class Start extends Application {
	private Restaurace restaurace;
	private Soubor soubor;
	
	/**
     * Metoda pro spuštění aplikace.
     * 
     * @param args Parametry příkazového řádku
     */
	public static void main(String[] args) {
            launch(args);
    }
	
	/**
     * Metoda pro spuštění grafické verze haplikace. Spouští hlavní okno.
     * 
     * @param primaryStage hlediště hry
     */
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/uvodniMenu.fxml"));    	
    	Parent root = loader.load();
    	restaurace = new Restaurace();
    	soubor = new Soubor(restaurace);
    	
    	ControllerUvodniMenu controller = loader.getController(); 	
    	controller.inicializuj(restaurace,soubor);
    	
    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    	primaryStage.setTitle("Úvodní menu aplikace");
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				Platform.exit();
			}
    	});
	}
	
	/**
     * Metoda spuštěná po ukončení hlavního okna. Slouží
     * k uložení aplikace.
     * 
     */
	@Override
	public void stop() throws Exception {
		soubor.uloz("src/main/resources/logika/stoly.txt",1,false);
		soubor.uloz("src/main/resources/logika/rezervace.txt",2,false);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Konec aplikace");
		alert.setHeaderText(null);
		alert.setContentText("Aplikace ukončena, všechny záznamy uloženy. Děkujeme že jste ji použili");
		alert.showAndWait();
	}
}
