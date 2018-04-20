package com.github.eifellovkas.Rezervacnik.ui;

import java.io.IOException;
import java.util.Calendar;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ControllerUvodniMenu extends GridPane{
	private Restaurace restaurace;
	
	@FXML private ComboBox<Integer>  	seznamRoku;
	@FXML private ComboBox<Integer>  	seznamMesicu;
	@FXML private ComboBox<Integer>  	seznamDnu;
	@FXML private ComboBox<Integer>  	seznamHodin;
	
	public void inicializuj(Restaurace restaurace) {
		this.restaurace = restaurace;
		
		int rok = Calendar.getInstance().get(Calendar.YEAR);
		Integer[] roky = { rok, rok+1};
		seznamRoku.getItems().addAll(roky);
		
		seznamMesicu.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12); 
		seznamDnu.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31); 
		seznamHodin.getItems().addAll(11,12,13,14,15,16,17,18,19,20,21,22,23); 
	}
	
	
	
	@FXML public void klikNovyStul(ActionEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/novyStul.fxml"));    	
    	Parent root = loader.load();
    	ControllerStulNovy controller = new ControllerStulNovy();
    	controller = loader.getController(); 	
    	Stage novyStul = new Stage();
    	novyStul.setScene(new Scene(root));
    	novyStul.show();
    	novyStul.setTitle("Nový stůl");
		}
	
	@FXML public void klikSpravovatStul(ActionEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/spravaStolu.fxml"));    	
    	Parent root = loader.load();
    	ControllerStulNovy controller = new ControllerStulNovy();
    	controller = loader.getController(); 	
    	Stage spravaStolu = new Stage();
    	spravaStolu.setScene(new Scene(root));
    	spravaStolu.show();
    	spravaStolu.setTitle("Správa stolů");
		}
	
	@FXML public void klikNovaRezervace(ActionEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/novaRezervace.fxml"));    	
    	Parent root = loader.load();
    	ControllerStulNovy controller = new ControllerStulNovy();
    	controller = loader.getController(); 	
    	Stage novaRezervace = new Stage();
    	novaRezervace.setScene(new Scene(root));
    	novaRezervace.show();
    	novaRezervace.setTitle("Nová rezervace");
		}
	
}
