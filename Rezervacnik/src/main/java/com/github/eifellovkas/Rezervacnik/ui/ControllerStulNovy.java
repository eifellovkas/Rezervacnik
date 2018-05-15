package com.github.eifellovkas.Rezervacnik.ui;

import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

public class ControllerStulNovy extends GridPane{
	private Stul stul;
	
	@FXML private ComboBox<Integer> pocetmist;
	@FXML private Button zalozit;
	@FXML private CheckBox kuracky;
	
	public void inicializuj(/**Stul stul**/) {
		pocetmist.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
}
}

