
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


/**
*  Třída ControllerSpravaRezervaci slouží jako controller pro úpravu údajů v existujících rezervacích.
*
*@author     Václav Pleskač
*@version    LS 2017/2018 (upraveno 20.5.2018)
*@created    květen 2018
*/
public class ControllerSpravaRezervaci {
	private Rezervace rezervace;
	private String nazev;
	private Restaurace restaurace;
	
	@FXML private TextArea			datumVypis;
	@FXML private TextArea		  	pocetMistVypis;
	@FXML private TextArea			nekurackyVypis;
	@FXML private TextArea 			stulVypis;
	@FXML private TextArea 			jmenoVypis;
	
	@FXML private DatePicker		  	datumVstup;
	@FXML private ComboBox<Integer>  	hodinaVstup;
	@FXML private ComboBox<Integer>  	pocetMistVstup;
	@FXML private ComboBox<String>  	stulVstup;
	@FXML private CheckBox  	kurackyVstup;
	@FXML private TextField	jmenoVstup;
	@FXML private Button	upravitButton;
	@FXML private Button	resetovatButton;

	
	/**
     * Metoda pro iniciaci controlleru.
     * 
     * @param rezervace 	třída pro práci s rezervacemi
     * @param nazev			nazev rezervace
     * @param restaurace 	restaurace pro kterou je aplikace postavena
     */
	public void inicializace(Rezervace rezervace,String nazev, Restaurace restaurace) {
		this.rezervace=rezervace;
		this.nazev=nazev;
		this.restaurace=restaurace;
		pocetMistVstup.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
		hodinaVstup.getItems().addAll(11,12,13,14,15,16,17,18,19,20,21,22,23); 
		vypisUdaje();
		stulVstup.setDisable(true);
	}
	
	/**
     * Metoda pro vypis udaju
     * 
     */
	@SuppressWarnings("deprecation")
	public void vypisUdaje() {
		datumVypis.setText("");
		pocetMistVypis.setText("");
		nekurackyVypis.setText("");
		stulVypis.setText("");
		jmenoVypis.setText("");
		
		String[]slovo = nazev.split(" -");
		
		Stul stul = restaurace.getStul(slovo[0]);
		
		String den = String.valueOf(restaurace.getRezervace(nazev).getDatum().getDate());
		String mesic = String.valueOf(restaurace.getRezervace(nazev).getDatum().getMonth()+1);
		String rok = String.valueOf(restaurace.getRezervace(nazev).getDatum().getYear()+1900);
		
		datumVypis.appendText(den+"."+mesic+"."+rok);
		pocetMistVypis.appendText(String.valueOf(stul.getPocetMist()));
		nekurackyVypis.appendText(String.valueOf(stul.isNekuracky()));
		stulVypis.appendText(String.valueOf(slovo[0]));
		jmenoVypis.appendText(String.valueOf(restaurace.getRezervace(nazev).getJmeno()));
		}

	/**
     * Metoda, ktera po zadani dat upravovane rezervace umozni vypsani vhodnych stolů
     * 
     * @param arg0 	kliknutí na tlacitko
     */
	@FXML public void vypisUpravovane(ActionEvent arg0) {
		LocalDate date = datumVstup.getValue();
		stulVstup.getItems().removeAll();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		Integer mista = pocetMistVstup.getValue();
		boolean kurackyCB = kurackyVstup.isSelected();
		Integer hodina = hodinaVstup.getValue();
		if(hodina != null && mista != null && !date.equals(null) ) {
			if(upravitButton.getText().equals("OK")){
				hodinaVstup.setDisable(true);
				datumVstup.setDisable(true);
				pocetMistVstup.setDisable(true);
				kurackyVstup.setDisable(true);
				stulVstup.setDisable(false);
				upravitButton.setText("upravit");
			}
			else {
				hodinaVstup.setDisable(false);
				datumVstup.setDisable(false);
				pocetMistVstup.setDisable(false);
				kurackyVstup.setDisable(false);
				stulVstup.setDisable(true);
				upravitButton.setText("OK");
			}
			
			String datumFormat = date.format(format);

			for(String nazev: restaurace.getSeznamStolu().keySet())
		{
			Stul stul = restaurace.getStul(nazev);
			if(stul.getPocetMist() == mista && stul.isNekuracky() == kurackyCB) {

				String rezervaceNazev = nazev + " - " + datumFormat + " - " + hodina;
			

				for(String nazev2: restaurace.getSeznamRezervaci().keySet()) {
					if(!nazev2.equals(rezervaceNazev)) {
						if(!stulVstup.getItems().contains(nazev)) {
							
						stulVstup.getItems().add(nazev);
						}


					}
				}

			}}
		
			
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Nedostatek údajů");
			alert.setHeaderText(null);
			alert.setContentText("Nejsou vyplněny všechny údaje!");
			alert.showAndWait();
			
		}
		
			

   
	}
	
	/**
     * Metoda pro upravení rezervace
     * 
     * @param arg0 	kliknutí na tlačítko
     */
	@SuppressWarnings({ "deprecation" })
	@FXML public void upravRezervaci(ActionEvent arg0) {
		
		String stul = stulVstup.getValue();
		String jmeno = jmenoVstup.getText();
		if(!stul.equals(null) && !jmeno.equals("")) {
			
			
			datumVstup.getValue().getDayOfYear();
			int den = datumVstup.getValue().getDayOfMonth();
			int mesic = datumVstup.getValue().getMonthValue();
			int rok = datumVstup.getValue().getYear();
			Date date = new Date(rok-1900,mesic-1,den);
			rezervace.setDatum(date);
			rezervace.setHodina(hodinaVstup.getValue());
			rezervace.setJmeno(jmenoVstup.getText());
			String hodnota = stulVstup.getValue();
			
			
			rezervace.setStul(restaurace.getStul(hodnota));
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			String datum = format.format(date);
			
			String nove = stul + " - " + datum + " - " + hodinaVstup.getValue();
			this.nazev = nove;
			restaurace.upravSeznamRezervaci(rezervace, nazev, nove);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Hodnota byla změněna");
			alert.setHeaderText(null);
			alert.setContentText("Hodnota byla změněna!!!");
			alert.showAndWait();
			vypisUdaje();
			
		}
		
	else  {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Nedostatek údajů");
		alert.setHeaderText(null);
		alert.setContentText("Nejsou vyplněny všechny údaje!");
		alert.showAndWait();
		
	}
		
}
}