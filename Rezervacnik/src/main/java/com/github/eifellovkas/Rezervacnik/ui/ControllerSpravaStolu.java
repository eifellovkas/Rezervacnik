package com.github.eifellovkas.Rezervacnik.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Rezervace;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

public class ControllerSpravaStolu extends GridPane{
	
	
	@FXML private ListView<String> 	seznamstolu;
	@FXML private ComboBox<Integer> pocetmist;
	@FXML private CheckBox 			nekuracky;
	private Restaurace 				restaurace;
	private ObservableList<String> 	stoly;
	
	
public void inicializace(Restaurace restaurace) {
	this.restaurace = restaurace;
	List<String> list = new ArrayList<String>();
	stoly = FXCollections.observableList(list);
	pocetmist.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
	vypisStoly();
}

public void vypisStoly() {
	stoly.removeAll(stoly);
	for (String nazev: restaurace.getSeznamStolu().keySet()) {
		stoly.add(nazev);
	}
	seznamstolu.setItems(stoly);
}

@FXML public void vyber(MouseEvent arg0) {
	String vyber = seznamstolu.getSelectionModel().getSelectedItem(); 
	if (!vyber.equals(null)) {
		pocetmist.setValue(restaurace.getStul(vyber).getPocetMist());
		nekuracky.setSelected(restaurace.getStul(vyber).isNekuracky());	
	}
}

@FXML public void upravit(ActionEvent arg0) {
	boolean vybrano = false;
	String vyber = seznamstolu.getSelectionModel().getSelectedItem(); 
	if (!vyber.equals(null)) {
		int vyberMista = pocetmist.getValue();
		boolean vyberNekuracky = nekuracky.isSelected();
		Stul stul = restaurace.getStul(vyber);
		for (Rezervace rezervace: restaurace.getSeznamRezervaci().values()) {
			if (rezervace.getStul().equals(stul) && vyberMista < stul.getPocetMist()) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("Potvrzení úpravy");
				alert.setContentText("Počet měněných míst je menší než počet vyžadovaný objednávkou. Jste si opravdu jisti, že chcete upravit stůl");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					stul.setNekuracky(vyberNekuracky);
					stul.setPocetMist(vyberMista);
					
					pocetmist.setValue(restaurace.getStul(vyber).getPocetMist());
					nekuracky.setSelected(restaurace.getStul(vyber).isNekuracky());
				}
				
			vybrano = true;	
			break;
			}
		}	
		if (!vybrano)  {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Potvrzení úpravy");
			alert.setHeaderText(null);
			alert.setContentText("Jste si opravdu jisti, že chcete upravit stůl");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				stul.setNekuracky(vyberNekuracky);
				stul.setPocetMist(vyberMista);
				pocetmist.setValue(restaurace.getStul(vyber).getPocetMist());
				nekuracky.setSelected(restaurace.getStul(vyber).isNekuracky());
			} 
	}
}	
	
	
}

@FXML public void odstranit(ActionEvent arg0) {
	try {
		boolean vybrano = false;
		String vyber = seznamstolu.getSelectionModel().getSelectedItem(); 
		if (!vyber.equals(null)) {
			Stul stul = restaurace.getStul(vyber);
			for (Rezervace rezervace: restaurace.getSeznamRezervaci().values()) {
				if (rezervace.getStul().equals(stul)) {
					
					vybrano = true;
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setHeaderText(null);
					alert.setTitle("Potvrzení smazání");
					alert.setContentText("Na stůl se vážou objednávky. Jste si opravdu jisti, že chcete smazat stůl");
	
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK){
						for (String nazevRezervace: restaurace.getSeznamRezervaci().keySet()) {
							Rezervace rezervace1 = restaurace.getRezervace(nazevRezervace);
							if (rezervace1.getStul().equals(stul)) {
								restaurace.odeberRezervaci(nazevRezervace, rezervace1);
							
							}
						}
						
						restaurace.odeberStul(vyber, stul);
						vypisStoly();
					} 
				}
				break;
			}
			
			if (!vybrano)  {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Potvrzení smazání");
				alert.setHeaderText(null);
				alert.setContentText("Jste si opravdu jisti, že chcete smazat stůl");
	
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					restaurace.odeberStul(vyber, stul);
					vypisStoly();
				} 
			}	
		}
	}
	catch (ConcurrentModificationException e) {
		}
	catch (Exception e) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Stůl nebyl vybrán");
		alert.setHeaderText(null);
		alert.setContentText("Žádný stůl nebyl vybrán");
		alert.showAndWait();
	}
	}
}

