package com.github.eifellovkas.Rezervacnik.logika;

import java.io.BufferedReader;
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
	
	public void nactiRezervace(String cestaText) {
		try {	
			URL cesta = this.getClass().getResource(cestaText);
			File soubor = new File(cesta.getFile());
			BufferedReader vstup = new BufferedReader(new FileReader(soubor));
			String radek = null;
			
			while ((radek=vstup.readLine()) != null) {
				String[] slovo = radek.split(";");
				
				String stul = slovo[0];
				String pocetMist = slovo[1];
				String kuracky = slovo[2];
				String den = slovo[3];
				String mesic = slovo[4];
				String rok = slovo[5];
				String hodina = slovo[6];
				String jmeno = slovo[7];
				String x = "";
				
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
/**	
		public void pridejStul(String nazev, Stul stul) {
			seznamStolu.put(nazev, stul);
		}
		
		public void odeberStul(String nazev, Stul stul) {
			seznamStolu.remove(nazev, stul);
		}
		
		public Stul getStul(String nazev) {
			return seznamStolu.get(nazev);
		}
		
		public boolean obsahujeStul(String nazev) {
			return seznamStolu.containsKey(nazev);
		}
		
		public void pridejRezervaci(String nazev, Rezervace rezervace) {
			seznamRezervaci.put(nazev, rezervace);
		}
		
		public void odeberRezervaci(String nazev, Rezervace rezervace) {
			seznamRezervaci.remove(nazev, rezervace);
		}
		
		public Rezervace getRezervace(String nazev) {
			return seznamRezervaci.get(nazev);
		}
		
		public boolean obsahujeRezervaci(String nazev) {
			return seznamRezervaci.containsKey(nazev);
		}
**/
}
