package com.github.eifellovkas.Rezervacnik.ui;

import java.io.IOException;
import java.util.Calendar;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

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
		restaurace.nacti("/logika/stoly.txt",1);
		restaurace.nacti("/logika/rezervace.txt",2);
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
