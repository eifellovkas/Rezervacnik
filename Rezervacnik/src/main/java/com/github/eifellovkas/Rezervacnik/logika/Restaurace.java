package com.github.eifellovkas.Rezervacnik.logika;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Restaurace {
	private int pocetStolu = 0;
	private HashMap<String,Stul> seznamStolu;
	private HashMap<String, Rezervace> seznamRezervaci;

	public Restaurace() {
		seznamStolu = new HashMap<String, Stul>();
		seznamRezervaci = new HashMap<String, Rezervace>();		
	}
		
	public void pokus() {
		System.out.println("aaaa");
	}
	
	public HashMap<String, Rezervace> getSeznamRezervaci(){
		return seznamRezervaci;
	}
	
	public void nacti(String cestaText, int typVstupu) {
		try {	
			URL cesta = this.getClass().getResource(cestaText);
			File soubor = new File(cesta.getFile());
			BufferedReader vstup = new BufferedReader(new FileReader(soubor));
			String radek = null;
			
			switch(typVstupu){
			case 1: while ((radek=vstup.readLine()) != null) {
						String[] slovo = radek.split(";");
						
						String stul = slovo[0];
						String pocetMist = slovo[1];
						
						boolean nekuracky;
						if (slovo[2].equals("t")) {
							nekuracky = true; 
						} 
						else {
							nekuracky = false; 
						}
						
						Stul stulInst = new Stul(Integer.parseInt(pocetMist),nekuracky);
						pridejStul(stul,stulInst);
					}
					break;
			
			case 2: while ((radek=vstup.readLine()) != null) {
						String[] slovo = radek.split(";");
						
						String stul = slovo[0];
						String den = slovo[1];
						String mesic = slovo[2];
						String rok = slovo[3];
						String hodina = slovo[4];
						String jmeno = slovo[5];
						
						@SuppressWarnings("deprecation")
						Date date = new Date(Integer.parseInt(rok)-1900,Integer.parseInt(mesic)-1,Integer.parseInt(den));
						if (obsahujeStul(stul)) {
							Stul stulInst = getStul(stul);
							Rezervace rezervace = new Rezervace(date,Integer.parseInt(hodina),jmeno,stulInst);
							DateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
							String popis = stul + " - " + datum.format(date) + " - " + hodina + " - " + jmeno;
							pridejRezervaci(popis,rezervace);
						}
						else {
							System.out.println("Stul na který se váže rezervace nenalezen");
						}			
					}
					break;
			}
			vstup.close();
		}
			catch (Exception e){ 
				System.out.println ("Chyba na vstupu souboru: " + cestaText);
			}
		}
	
		@SuppressWarnings("deprecation")
		public void uloz(String cestaText, int typVystupu) {
			try {	
				BufferedWriter vystup;
				
				switch(typVystupu){
				case 1: vystup = new BufferedWriter(new FileWriter(cestaText));	
						for (String stul: seznamStolu.keySet()) {
								String pocetMist = String.valueOf(getStul(stul).getPocetMist());
								String nekuracky = String.valueOf(getStul(stul).isNekuracky());
								String vystupText = stul + ";" + pocetMist + ";" + nekuracky;
								vystup.write(vystupText);
								vystup.newLine();
						}	
						vystup.close();	
						break;
				
				case 2: vystup = new BufferedWriter(new FileWriter(cestaText));	
						for (String rezervace: seznamRezervaci.keySet()) {
							String stul = null;
							for (String seznam: seznamStolu.keySet()) {
								if (getStul(seznam).equals(getRezervace(rezervace).getStul())){
									stul = seznam;
								}
							}
							String den = String.valueOf(getRezervace(rezervace).getDatum().getDate());
							String mesic = String.valueOf(getRezervace(rezervace).getDatum().getMonth()+1);
							String rok = String.valueOf(getRezervace(rezervace).getDatum().getYear()+1900);
							String hodina = String.valueOf(getRezervace(rezervace).getHodina());
							String jmeno = String.valueOf(getRezervace(rezervace).getJmeno());
							String vystupText = stul + ";" + den + ";" + mesic + ";" + rok + ";" + hodina + ";" + jmeno;
							vystup.write(vystupText);
							vystup.newLine();
						}	
						vystup.close();	
						break;
				}
				
			}
			catch (Exception e){ 
				System.out.println ("Chyba na zapisu souboru");
			}
		}
		
		public int getPocetStolu() {
			return pocetStolu;
		}
		
		public void setPocetStolu(int pocetStolu) {
			this.pocetStolu = pocetStolu;
		}
	
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
}
