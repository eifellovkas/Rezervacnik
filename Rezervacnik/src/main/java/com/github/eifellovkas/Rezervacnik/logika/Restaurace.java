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

/*******************************************************************************
 * Třída Restaurace slouží ke správě restaurace
 *
 * @author     Martin Havlík, havlikmar
 * @version    LS 2017/2018 (upraveno 11.5.2018)
 */
public class Restaurace {
	private int pocetStolu = 0;
	private HashMap<String,Stul> seznamStolu;
	private HashMap<String, Rezervace> seznamRezervaci;
	private boolean nacetlo = true;
	private BufferedReader vstup; 

	/**
     * Konstruktor pro vytvoření restaurace.
     * 
     */
	public Restaurace() {
		seznamStolu = new HashMap<String, Stul>();
		seznamRezervaci = new HashMap<String, Rezervace>();		
	}
	
	/**
     * Getter pro získání seznamu rezervací
     * 
     * @return   vrací seznam rezervací
     */
	public HashMap<String, Rezervace> getSeznamRezervaci() {
		return seznamRezervaci;
	}
	
	/**
     * Getter pro získání seznamu stolu
     * Slouží pro testy
     * 
     * @return   vrací seznam stolu
     */
	public HashMap<String, Stul> getSeznamStolu() {
		return seznamStolu;
	}
	
	/**
     * Metoda pro načítání stupních dat ze souboru. Načítá stoly a rezervace
     * ze zvláštních souborů.
     * 
     * @param   cestaText   cesta k souboru
     * @param   typVstupu   rozlišení o jaký typ souboru se jedná
     */
	@SuppressWarnings("deprecation")
	public void nacti(String cestaText, int typVstupu) {
		try {	
			nacetlo = true;
			URL cesta = this.getClass().getResource(cestaText);
			File soubor = new File(cesta.getFile());
			vstup = new BufferedReader(new FileReader(soubor));
			String radek = null;
			
			switch(typVstupu) {
				case 1: while ((radek=vstup.readLine()) != null) {
					String[] slovo = radek.split(";");

					if (slovo.length != 3) {
						throw new Exception();
					}
						
					String stul = slovo[0];
					String pocetMist = slovo[1];
					boolean nekuracky;
					
					if (slovo[2].equals("true")) {
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
						
					if (slovo.length != 6) {
						throw new Exception();
					}
						
					String stul = slovo[0];
					int den = Integer.parseInt(slovo[1]);
					int mesic = Integer.parseInt(slovo[2]);
					int rok = Integer.parseInt(slovo[3]);
					int hodina = Integer.parseInt(slovo[4]);
					String jmeno = slovo[5];
						
					DateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
					Date dnesniDatum = new Date();
						
					int dnesniRok = dnesniDatum.getYear()+1900;
					int dnesniDen = dnesniDatum.getDate();
					int dnesniMesic = dnesniDatum.getMonth()+1;
						
					if ((rok > dnesniRok) || ((rok == dnesniRok) && (mesic == dnesniMesic) && (den >= dnesniDen)) || ((rok == dnesniRok) && (mesic > dnesniMesic))) {
						Date date = new Date(rok-1900,mesic-1,den);
							
						if (obsahujeStul(stul)) {
							Stul stulInst = getStul(stul);
							Rezervace rezervace = new Rezervace(date,hodina,jmeno,stulInst);
							String popis = stul + " - " + datum.format(date) + " - " + hodina /** + " - " + jmeno **/;
							pridejRezervaci(popis,rezervace);
						}
						else {
							if (!seznamRezervaci.isEmpty()) {
								System.out.println("Stul na který se váže rezervace nenalezen");
								nacetlo = false;
							}
						}			
					}					
				}
				break;
			}
			vstup.close();
		}
		
		catch (Exception e) { 
			System.out.println ("Chyba na vstupu souboru: " + cestaText);
			nacetlo = false;
		}
	}
	
	/**
	 * Getter pro získání atributo, zda se celý soubor načetl. 
	 * Slouží k testování aplikaci a k ověření že se celý soubor načetl
	 * 
	 * @return   vrací zda se souor načetl
	 */
	public boolean isNacetly() {
		return nacetlo;
	}
	
	/**
	 * Metoda pro ukládání dat do souboru. Data se ukládají do specializovaných
	 * souborů.
	 * 
	 * @param   cestaText   cesta k souboru
	 * @param   typVstupu   rozlišení o jaký typ souboru se jedná
	 */
	@SuppressWarnings("deprecation")
	public void uloz(String cestaText, int typVystupu) {
		try {	
			BufferedWriter vystup;
			
			switch(typVystupu) {
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
		
		catch (Exception e) { 
			System.out.println ("Chyba na zapisu souboru");
		}
	}
		
	/**
	 * Getter pro získání počtu stolů
	 * 
	 * @return   vrací počet stolů
	 */
	public int getPocetStolu() {
		return pocetStolu;
	}
		
	/**
	 * Setter pro nastavení počtu stolů
	 * 
	 * @param   pocetStolu   pocet stolů
	 */
	public void setPocetStolu(int pocetStolu) {
		this.pocetStolu = pocetStolu;
	}
	
	/**
	 * Metoda pro přidání stolu
	 * 
	 * @param   nazev   název stolu
	 * @param   stul   	stůl co chceme přidat
	 */
	public void pridejStul(String nazev, Stul stul) {
		seznamStolu.put(nazev, stul);
		pocetStolu = pocetStolu + 1;
	}
		
	/**
	 * Metoda pro odebrání stolu
	 * 
	 * @param   nazev   název stolu
	 * @param   stul   	stůl, který chceme odstranit
	 */
	public void odeberStul(String nazev, Stul stul) {
		seznamStolu.remove(nazev, stul);
		pocetStolu = pocetStolu - 1;
	}
		
	/**
	 * Getter pro získání stolu
	 * 
	 * @param   	nazev   název stolu
	 * @return   	vrací daný stůl
	 */
	public Stul getStul(String nazev) {
		return seznamStolu.get(nazev);
	}
		
	/**
	 * Metoda pro zjištění zda restaurace obsahuje daný stůl
	 * 
	 * @param   	nazev   název rezervace
	 * @return  	vrací zda obsahuje rezervaci
	 */
	public boolean obsahujeStul(String nazev) {
		return seznamStolu.containsKey(nazev);
	}
		
	/**
	 * Metoda pro přidání rezervace
	 * 
	 * @param   nazev   	název rezervace
	 * @param   rezervace   rezervace, kterou chceme přidat
	 */
	public void pridejRezervaci(String nazev, Rezervace rezervace) {
		seznamRezervaci.put(nazev, rezervace);
	}
		
	/**
	 * Metoda pro odebrání rezervace
	 * 
	 * @param   nazev   		název rezervace
	 * @param   rezervace   	rezervace, kterou chceme odstranit
	 */
	public void odeberRezervaci(String nazev, Rezervace rezervace) {
		seznamRezervaci.remove(nazev, rezervace);
	}
		
	/**
	 * Getter pro získání dané rezervaec
	 * 
	 * @param   nazev	název rezervace
	 * @return  vrací danou rezervaci
	 */
	public Rezervace getRezervace(String nazev) {
		return seznamRezervaci.get(nazev);
	}
		
	/**
	 * Metoda pro zjištění zda restaurace obsahuje rezervaci
	 * 
	 * @param   nazev	název rezervace
	 * @return  vrací zda obsahuje rezervaci
	 */
	public boolean obsahujeRezervaci(String nazev) {
		return seznamRezervaci.containsKey(nazev);
	}
}
