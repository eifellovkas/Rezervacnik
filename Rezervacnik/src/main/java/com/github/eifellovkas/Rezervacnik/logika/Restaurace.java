package com.github.eifellovkas.Rezervacnik.logika;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class Restaurace {
	private int pocetStolu = 0;
//	private HashMap<String,Stul> seznamStolu;
//	private HashMap<String, Rezervace> seznamRezervaci;

	public Restaurace() {
	}
		
	public void pokus() {
		System.out.println("aaaa");
	}
		
	public void nactiRezervace() {
		try {	
			URL cesta = this.getClass().getResource("/logika/databaze.txt");
			File soubor = new File(cesta.getFile());
			FileReader vstup = new FileReader (soubor);
			int cisloZnak;
			
			while ((cisloZnak=vstup.read()) != -1) {
				String stul = "Stůl ";
				String pocetMist = "";
				String kuracky = "";
				String den = "";
				String mesic = "";
				String rok = "";
				String hodina = "";
				String jmeno = "";
				String x = "";
				
				while ((cisloZnak=vstup.read()) != 59) {
					char znak = (char) cisloZnak;
					stul = stul + znak;
				}
				
				while ((cisloZnak=vstup.read()) != 59) {
					char znak = (char) cisloZnak;
					pocetMist = pocetMist + znak;
				}
				
				while ((cisloZnak=vstup.read()) != 59) {
					char znak = (char) cisloZnak;
					kuracky = kuracky + znak;
				}
				
				while ((cisloZnak=vstup.read()) != 59) {
					char znak = (char) cisloZnak;
					den = den + znak;
				}
				
				while ((cisloZnak=vstup.read()) != 59) {
					char znak = (char) cisloZnak;
					mesic = mesic + znak;
				}
				
				while ((cisloZnak=vstup.read()) != 59) {
					char znak = (char) cisloZnak;
					rok = rok + znak;
				}
				
				while ((cisloZnak=vstup.read()) != 59) {
					char znak = (char) cisloZnak;
					hodina = hodina + znak;
				}
				
				while ((cisloZnak=vstup.read()) != 59) {
					char znak = (char) cisloZnak;
					jmeno = jmeno + znak;
				}
				
				cisloZnak=vstup.read();
				
				x = stul + ";" + pocetMist + ";" + kuracky + ";" + den + ";" + mesic + ";" + rok + ";" + hodina + ";" + jmeno; 
				System.out.println(x);	
			}
			vstup.close();
		}	
			catch (IOException e){ 
				System.out.println ("Chyba na vstupu souboru databaze.txt");
			}
		}
		
		public int getPocetStolu() {
			return pocetStolu;
		}
		
		public void setPocetStolu(int pocetStolu) {
			this.pocetStolu = pocetStolu;
		}
		
//		public void pridejStul(String nazev, Stul stul) {
//			seznamStolu.put(nazev, stul);
//		}
		
//		public void odeberStul(String nazev) {
//			seznamStolu.remove(nazev, stul);
//		}

}
