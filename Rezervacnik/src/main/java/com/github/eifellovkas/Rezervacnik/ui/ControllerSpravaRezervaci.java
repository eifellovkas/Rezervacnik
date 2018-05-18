
package com.github.eifellovkas.Rezervacnik.ui;

import java.util.ArrayList;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Rezervace;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * @author plev00
 *
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
	@FXML private ComboBox<Integer>  	stulVstup;
	@FXML private CheckBox  	kurackyVstup;
	@FXML private TextField	jmenoVstup;
	@FXML private Button	upravitButton;
	@FXML private Button	resetovatButton;

	

	public void inicializace(Rezervace rezervace,String nazev, Restaurace restaurace) {
		this.rezervace=rezervace;
		this.nazev=nazev;
		this.restaurace=restaurace;
		vypisUdaje();
	}
	
	public void vypisUdaje() {
		String[] slovo = nazev.split(" -");
		Stul stul = restaurace.getStul(slovo[0]);
		String den = String.valueOf(restaurace.getRezervace(nazev).getDatum().getDate());
		String mesic = String.valueOf(restaurace.getRezervace(nazev).getDatum().getMonth()+1);
		String rok = String.valueOf(restaurace.getRezervace(nazev).getDatum().getYear()+1900);
		datumVypis.appendText(den+"."+mesic+"."+rok);
		System.out.println(slovo[0]);
		pocetMistVypis.appendText(String.valueOf(stul.getPocetMist()));
		nekurackyVypis.appendText(String.valueOf(stul.isNekuracky()));
		stulVypis.appendText(String.valueOf(slovo[0]));
		jmenoVypis.appendText(String.valueOf(restaurace.getRezervace(nazev).getJmeno()));
		
		}

	@FXML public void vypisUpravovane(ActionEvent arg0) {
			
		
	}
	}
	
