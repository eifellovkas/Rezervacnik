package com.github.eifellovkas.Rezervacnik.ui;

import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

/**
 *  Třída ControllerStulNovy - slouží jako controller pro přidání stolu.
 *
 *@author     Aneta Bukovjanová, buka00
 *@version    1.0
 *@created    LS 2017/2018 (upraveno 15.05.2018)
 */

public class ControllerStulNovy extends GridPane{
	
	
	@FXML private ComboBox<Integer> pocetmist;
	@FXML private CheckBox nekuracky;
	private Restaurace restaurace;
	
	/**
	* Metoda pro iniciaci controlleru.
	* 
	* @param restaurace 	restaurace pro kterou je aplikace postavena
	*/
	public void inicializace(Restaurace restaurace) {
		pocetmist.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
		this.restaurace = restaurace;
}
	
	/**
	* Metoda pro založení stolu.
	* 
	* @param arg0 	kliknutím na založit
	*/
	@FXML public void zalozit(ActionEvent arg0) {
		try {
			int mista = pocetmist.getValue();
			boolean checkbox = nekuracky.isSelected();
			int pocetStolu = restaurace.getPocetStolu();
			for(int index = 1; index <= (pocetStolu + 2); index ++) {
				String nazev = "Stul " + index;
				if (!restaurace.obsahujeStul(nazev)){
					
					Stul stul = new Stul(mista,checkbox);
					restaurace.pridejStul(nazev, stul);
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Stůl Přidán");
					alert.setHeaderText(null);
					alert.setContentText("Do aplikace byl přidán stůl.");
					alert.showAndWait();
					break;
				}
			}
		}
		catch (Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Stůl Nepřidán");
			alert.setHeaderText(null);
			alert.setContentText("Stůl nepřidán. Údaje nebyly vyplněny!");
			alert.showAndWait();
		}
		
	}

}

