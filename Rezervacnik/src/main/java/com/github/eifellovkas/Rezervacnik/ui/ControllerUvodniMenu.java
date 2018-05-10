package com.github.eifellovkas.Rezervacnik.ui;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Rezervace;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ControllerUvodniMenu extends GridPane{
	private Restaurace restaurace;
	
	@FXML private ComboBox<Integer>  	seznamHodin;
	@FXML private DatePicker		  	datumPanel;
	private ObservableList<String>		seznamRezervaci;
	private ArrayList<String> 			dataRezervace;
	@FXML private ListView<String>  	rezervaceSeznam;
	@FXML private MenuBar  				menu;
	
	
	public void inicializuj(Restaurace restaurace) {
		this.restaurace = restaurace;
		restaurace.nacti("/logika/stoly.txt",1);
		restaurace.nacti("/logika/rezervace.txt",2);
		seznamHodin.getItems().addAll(11,12,13,14,15,16,17,18,19,20,21,22,23); 
		List<String> list = new ArrayList<String>();
		seznamRezervaci = FXCollections.observableList(list);
	}
	
	public void odemkniVyber() {
		menu.setDisable(false);
		rezervaceSeznam.setDisable(false);
	}
	
	public void zamkniVyber() {
		menu.setDisable(true);
		rezervaceSeznam.setDisable(true);
	}
	
	@FXML public void klikRezervace(MouseEvent arg0) throws Exception {
		String vyber = rezervaceSeznam.getSelectionModel().getSelectedItem();
		int index = rezervaceSeznam.getSelectionModel().getSelectedIndex();
		if (vyber!=null && restaurace.obsahujeRezervaci(dataRezervace.get(index))) {
			Rezervace rez = restaurace.getRezervace(vyber);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/ui/spravaRezervaci.fxml"));    	
			Parent root = loader.load();
			ControllerStulNovy controller = new ControllerRezPokus(rez);
			controller = loader.getController(); 	
			Stage spravaRezervace = new Stage();
			zamkniVyber();
			spravaRezervace.setScene(new Scene(root));
			spravaRezervace.show();
			spravaRezervace.setTitle("Uprava Rezervace");	
			
			spravaRezervace.setOnCloseRequest(new EventHandler<WindowEvent>(){

				public void handle(WindowEvent event) {
					odemkniVyber();
				}
	    		
	    	});
		}		
	}
	
	
	@FXML public void klikNovyStul(ActionEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/novyStul.fxml"));    	
    	Parent root = loader.load();
    	ControllerStulNovy controller = new ControllerStulNovy();
    	controller = loader.getController(); 	
    	Stage novyStul = new Stage();
    	zamkniVyber();
    	novyStul.setScene(new Scene(root));
    	novyStul.show();
    	novyStul.setTitle("Nový stůl");
    	
    	novyStul.setOnCloseRequest(new EventHandler<WindowEvent>(){

			public void handle(WindowEvent event) {
				odemkniVyber();
			}
    		
    	});
		}
	
	@FXML public void klikSpravovatStul(ActionEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/spravaStolu.fxml"));    	
    	Parent root = loader.load();
    	ControllerStulNovy controller = new ControllerStulNovy();
    	controller = loader.getController(); 	
    	Stage spravaStolu = new Stage();
    	zamkniVyber();
    	spravaStolu.setScene(new Scene(root));
    	spravaStolu.show();
    	spravaStolu.setTitle("Správa stolů");
    	
    	spravaStolu.setOnCloseRequest(new EventHandler<WindowEvent>(){

			public void handle(WindowEvent event) {
				odemkniVyber();
			}
    		
    	});
		}
	
	@FXML public void klikNovaRezervace(ActionEvent event) throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/novaRezervace.fxml"));    	
    	Parent root = loader.load();
    	ControllerStulNovy controller = new ControllerStulNovy();
    	controller = loader.getController(); 	
    	Stage novaRezervace = new Stage();
    	zamkniVyber();
    	novaRezervace.setScene(new Scene(root));
    	novaRezervace.show();
    	novaRezervace.setTitle("Nová rezervace");
    	
    	novaRezervace.setOnCloseRequest(new EventHandler<WindowEvent>(){

			public void handle(WindowEvent event) {
				odemkniVyber();
			}
    		
    	});
		}
	
	@FXML public void klikUlozit(ActionEvent event){
		restaurace.uloz("src/main/resources/logika/stoly.txt",1);
		restaurace.uloz("src/main/resources/logika/rezervace.txt",2);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Uložení");
		alert.setHeaderText(null);
		alert.setContentText("Záznamy uloženy");
		alert.showAndWait();
		}
	
	@FXML public void vyhledat(ActionEvent arg0) {
		LocalDate date = datumPanel.getValue();
		Integer hodina = seznamHodin.getValue();
		seznamRezervaci.removeAll(seznamRezervaci);
		dataRezervace = new ArrayList<String>();
		if (date!=null && hodina!=null) {
			for (String nazev: restaurace.getSeznamRezervaci().keySet()) {
				Rezervace rezervace = restaurace.getSeznamRezervaci().get(nazev);	
				SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
				String a2 = format.format(rezervace.getDatum());
				DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				String a1 = date.format(format2);
				if (hodina.equals(rezervace.getHodina()) && a2.equals(a1)) {
					String[] slovo = nazev.split("-");
					String stul = slovo[0];
					String jmeno = slovo[3];
					String zobraz = stul + jmeno;
					
					dataRezervace.add(nazev);
					seznamRezervaci.add(zobraz);
				}
			}
		}
		rezervaceSeznam.setItems(seznamRezervaci);
	}
}
