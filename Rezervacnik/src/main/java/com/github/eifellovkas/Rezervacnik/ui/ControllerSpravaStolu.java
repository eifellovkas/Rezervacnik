package com.github.eifellovkas.Rezervacnik.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

public class ControllerSpravaStolu extends GridPane{
	private Stul stul;
	
	@FXML private ListView<String> 	seznamstolu;
	@FXML private Button 			upravit;
	@FXML private Button 			odstranit;
	@FXML private ComboBox<Integer> pocetmist;
	@FXML private CheckBox 			kuracky;
	
	
	
public void inicializuj(Stul stul) {

}
}
