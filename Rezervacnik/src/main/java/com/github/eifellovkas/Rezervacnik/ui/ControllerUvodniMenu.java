package com.github.eifellovkas.Rezervacnik.ui;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Rezervace;
import com.github.eifellovkas.Rezervacnik.logika.Soubor;

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

/*******************************************************************************
 * Třída ControllerUvodniMenu slouží jako controller pro úvodní menu aplikace.
 *
 * @author     Martin Havlík, havlikmar
 * @version    LS 2017/2018 (upraveno 11.5.2018)
 */
public class ControllerUvodniMenu extends GridPane {
	private Restaurace 					restaurace;
	@FXML private ComboBox<Integer>  	seznamHodin;
	@FXML private DatePicker		  	datumPanel;
	private ObservableList<String>		seznamRezervaci;
	private ArrayList<String> 			dataRezervace;
	@FXML private ListView<String>  	rezervaceSeznam;
	@FXML private MenuBar  				menu;
	private Soubor 						soubor;	
	
	/**
     * Metoda pro iniciaci controlleru.
     * 
     * @param restaurace 	restaurace pro kterou je aplikace postavena
     * @param soubor		třída pro úpravu souborů
     */
	public void inicializuj(Restaurace restaurace, Soubor soubor) {
		this.restaurace = restaurace;
		this.soubor = soubor;
		soubor.nacti("/logika/stoly.txt",1,false);
		boolean nacetlo1 = soubor.isNacetly();
		soubor.nacti("/logika/rezervace.txt",2,false);
		boolean nacetlo2 = soubor.isNacetly();
		seznamHodin.getItems().addAll(11,12,13,14,15,16,17,18,19,20,21,22,23); 
		List<String> list = new ArrayList<String>();
		seznamRezervaci = FXCollections.observableList(list);
		
		if(nacetlo1 && nacetlo2) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Načtení souboru");
			alert.setHeaderText(null);
			alert.setContentText("Všechny záznamy se načetly");
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("chyba při načítání");
			alert.setHeaderText(null);
			alert.setContentText("Alespoň jeden záznam se nepovedlo načíst. Aplikace stále bude fungovat, ale může mít neúplné údaje");
			alert.showAndWait();
		}
	}
	
	/**
     * Metoda pro odemknutí prvků GUI.
     * 
     */
	public void odemkniVyber() {
		menu.setDisable(false);
		rezervaceSeznam.setDisable(false);
	}
	
	/**
     * Metoda pro zamknutí prvků GUI.
     * 
     */
	public void zamkniVyber() {
		menu.setDisable(true);
		rezervaceSeznam.setDisable(true);
	}
	
	/**
     * Metoda pro kliknutí zobrazení okna správa rezervaci
     * 
     * @param   arg0   kliknutí myši na rezervaci
     * 
     */
	@FXML public void klikRezervace(MouseEvent arg0) throws Exception {
		String vyber = rezervaceSeznam.getSelectionModel().getSelectedItem();
		int index = rezervaceSeznam.getSelectionModel().getSelectedIndex();
		if (vyber!=null && restaurace.obsahujeRezervaci(dataRezervace.get(index))) {
			Rezervace rez = restaurace.getRezervace(dataRezervace.get(index));
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/ui/spravaRezervaci.fxml"));    	
			Parent root = loader.load();
			ControllerSpravaRezervaci controller = new ControllerSpravaRezervaci(/**rez, dataRezervace.get(index)**/);
			controller = loader.getController();
			Stage spravaRezervace = new Stage();
			controller.inicializace(rez, dataRezervace.get(index), restaurace,spravaRezervace,this);
			zamkniVyber();
			spravaRezervace.setScene(new Scene(root));
			spravaRezervace.show();
			spravaRezervace.setTitle("Uprava Rezervace");	
			spravaRezervace.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent event) {
					odemkniVyber();
				}
	    	});
		}		
	}
	
	/**
     * Metoda pro otevření okna nový stůl
     * 
     * @param   event   kliknutí na daný prvek
     * 
     */
	@FXML public void klikNovyStul(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/novyStul.fxml"));    	
    	Parent root = loader.load();
    	ControllerStulNovy controller = new ControllerStulNovy();
    	controller = loader.getController(); 
    	controller.inicializace(restaurace);
    	Stage novyStul = new Stage();
    	zamkniVyber();
    	novyStul.setScene(new Scene(root));
    	novyStul.show();
    	novyStul.setTitle("Nový stůl");
    	novyStul.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				odemkniVyber();
			}
    	});
	}
	
	/**
     * Metoda pro otevření okna spravovat stůl
     * 
     * @param   event   kliknutí na daný prvek
     * 
     */
	@FXML public void klikSpravovatStul(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/spravaStolu.fxml"));    	
    	Parent root = loader.load();
    	ControllerSpravaStolu controller = new ControllerSpravaStolu();
    	controller = loader.getController(); 
    	controller.inicializace(restaurace);
    	Stage spravaStolu = new Stage();
    	zamkniVyber();
    	spravaStolu.setScene(new Scene(root));
    	spravaStolu.show();
    	spravaStolu.setTitle("Správa stolů");
    	spravaStolu.setOnCloseRequest(new EventHandler<WindowEvent>() {
    		public void handle(WindowEvent event) {
				odemkniVyber();
			}	
    	});
	}
	
	/**
     * Metoda pro otevření okna nová rezervace
     * 
     * @param   event   kliknutí na daný prvek
     * 
     */
	@FXML public void klikNovaRezervace(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui/novaRezervace.fxml"));    	
    	Parent root = loader.load();
    	ControllerRezervaceNova controller = new ControllerRezervaceNova();
    	controller = loader.getController(); 	
    	controller.inicializace(restaurace);
    	Stage novaRezervace = new Stage();
    	zamkniVyber();
    	novaRezervace.setScene(new Scene(root));
    	novaRezervace.show();
    	novaRezervace.setTitle("Nová rezervace");
    	novaRezervace.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				odemkniVyber();
			}
    	});
	}
	
	/**
     * Metoda pro uložení hry
     * 
     * @param   event   kliknutí na daný prvek
     * 
     */
	@FXML public void klikUlozit(ActionEvent event) {
		soubor.uloz("src/main/resources/logika/stoly.txt",1,false);
		soubor.uloz("src/main/resources/logika/rezervace.txt",2,false);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Uložení");
		alert.setHeaderText(null);
		alert.setContentText("Záznamy uloženy");
		alert.showAndWait();
		}
	
	/**
     * Metoda pro vyhledání rezervací podle zadaných parametrů
     * 
     * @param   arg0   kliknutí na tlačítko vyhledat
     * 
     */
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
					String jmeno = restaurace.getRezervace(nazev).getJmeno();
					String zobraz = stul + jmeno;
					dataRezervace.add(nazev);
					seznamRezervaci.add(zobraz);
				}
			}
		}
		rezervaceSeznam.setItems(seznamRezervaci);
	}
}