
package com.github.eifellovkas.Rezervacnik.ui;

import com.github.eifellovkas.Rezervacnik.logika.Rezervace;

/**
 * @author plev00
 *
 */
public class ControllerSpravaRezervaci {
	private Rezervace rezervace;
	private String nazev;

//	public ControllerSpravaRezervaci(Rezervace rezervace,String nazev) {
//		this.rezervace=rezervace;
//		this.nazev=nazev;
//	}
	
	public void inicializace(Rezervace rezervace,String nazev) {
		this.rezervace=rezervace;
//		this.nazev=nazev;
	}
}
