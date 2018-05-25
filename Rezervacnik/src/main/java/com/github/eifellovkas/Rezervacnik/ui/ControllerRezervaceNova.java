/**
 * 
 */
package com.github.eifellovkas.Rezervacnik.ui;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Rezervace;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/*******************************************************************************
 * Třída ControllerRezervaceNova slouží jako controller pro vytváření nové rezervace
 *
 * @author     Václav Pleskač, plev00
 * @version    LS 2017/2018 (upraveno 20.5.2018)
 */

public class ControllerRezervaceNova {
	private Restaurace restaurace;

	@FXML private DatePicker		  	datumVstup;
	@FXML private ComboBox<Integer>  	hodinaVstup;
	@FXML private ComboBox<Integer>  	pocetMistVstup;
	@FXML private CheckBox  			kurackyCB;
	@FXML private Button				upravitButton;
	@FXML private ComboBox<String>  	stulVstup;
	@FXML private TextField				jmenoVstup;
	@FXML private Button				zalozitButton;

	
	/**
     * Metoda pro iniciaci controlleru.
     * 
     * @param restaurace 	restaurace pro kterou je aplikace postavena
     */
	public void inicializace(Restaurace restaurace) {
		this.restaurace=restaurace;

		pocetMistVstup.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
		hodinaVstup.getItems().addAll(11,12,13,14,15,16,17,18,19,20,21,22,23); 
		stulVstup.setDisable(true);		
	}
	
	/**
     * Metoda vypisující stoly, které se hodí k zadaným hodnotám
     * 
     * @param arg0 kliknutí myší na tlacitko OK
     */
	@FXML public void vypisUpravovane(ActionEvent arg0) {
		LocalDate date = datumVstup.getValue();
		stulVstup.getItems().clear();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		Integer mista = pocetMistVstup.getValue();
		boolean kuracky = kurackyCB.isSelected();
		Integer hodina = hodinaVstup.getValue();
		if(hodina != null && mista != null && !date.equals(null) ) {
			if(upravitButton.getText().equals("OK")) {
				hodinaVstup.setDisable(true);
				datumVstup.setDisable(true);
				pocetMistVstup.setDisable(true);
				kurackyCB.setDisable(true);
				stulVstup.setDisable(false);
				upravitButton.setText("upravit");
			}
			else {
				hodinaVstup.setDisable(false);
				datumVstup.setDisable(false);
				pocetMistVstup.setDisable(false);
				kurackyCB.setDisable(false);
				stulVstup.setDisable(true);
				upravitButton.setText("OK");
			}
			
			String datumFormat = date.format(format);

			for(String nazev: restaurace.getSeznamStolu().keySet()) {
				boolean pruchod = false;
				Stul stul = restaurace.getStul(nazev);
				if(stul.getPocetMist() == mista && stul.isNekuracky() == kuracky) {
					String rezervaceNazev = nazev + " - " + datumFormat + " - " + hodina;
			
					if(restaurace.getSeznamRezervaci().keySet().size()==0) {
						stulVstup.getItems().addAll(nazev);
					}
					
					for(String nazev2: restaurace.getSeznamRezervaci().keySet()) {
						if(nazev2.equals(rezervaceNazev)) {
							pruchod = true;
							break;
						}
					}
					
					if (!pruchod) {
						if(!stulVstup.getItems().contains(nazev)) {
							stulVstup.getItems().addAll(nazev);
						}
					}
				}
			}	
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Nedostatek údajů");
			alert.setHeaderText(null);
			alert.setContentText("Nejsou vyplněny všechny údaje!");
			alert.showAndWait();	
		}
		stulVstup.getSelectionModel().clearSelection();
	}
	
	/**
     * Metoda pro zalozeni rezervace
     * 
     * @param arg0 kliknutí na tlacitko Založit
     */
	@SuppressWarnings("deprecation")
	@FXML public void zalozRezervaci(ActionEvent arg0) {
		
		String stul = stulVstup.getValue();
		String jmeno = jmenoVstup.getText();
		if(!stul.equals(null) && !jmeno.equals("")) {
			datumVstup.getValue().getDayOfYear();
			int den = datumVstup.getValue().getDayOfMonth();
			int mesic = datumVstup.getValue().getMonthValue();
			int rok = datumVstup.getValue().getYear();
			int hodina = hodinaVstup.getValue();
			Date date = new Date(rok-1900,mesic-1,den);
			
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			String datum = format.format(date);
			
			String popis = stul + " - " + datum + " - " + hodinaVstup.getValue();
			Stul stulInstance = restaurace.getStul(stul);
			Rezervace rezervace = new Rezervace(date, hodina, jmeno, stulInstance);
			restaurace.pridejRezervaci(popis, rezervace);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Vložení nové rezervace");
			alert.setHeaderText(null);
			alert.setContentText("Rezervace byla založena!!!");
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Nedostatek údajů");
			alert.setHeaderText(null);
			alert.setContentText("Nejsou vyplněny všechny údaje!");
			alert.showAndWait();
		}
	}
}