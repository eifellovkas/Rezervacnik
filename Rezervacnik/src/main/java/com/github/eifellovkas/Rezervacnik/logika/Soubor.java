package com.github.eifellovkas.Rezervacnik.logika;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*******************************************************************************
 * Třída Soubor slouží ke čtení a zápisu do souborů
 *
 * @author     Martin Havlík, havlikmar
 * @version    LS 2017/2018 (upraveno 19.5.2018)
 */
public class Soubor {
	private Restaurace restaurace;
	private boolean nacetlo = true;
	private BufferedReader vstup;
	BufferedWriter vystup;
	boolean pruchodVstup = false;
	boolean pruchodVystup = false;
	boolean vadnyFormat = false;
	File soubor;
	boolean nacitani1 = false;
	boolean nacitani2 = false;
	
	/**
     * Konstruktor pro vytvoření třídy soubor.
     * 
     * @param   restaurace   třída restaurace
     * 
     */
	public Soubor (Restaurace restaurace) {
		this.restaurace = restaurace;
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
     * Metoda pro načítání stupních dat ze souboru. Načítá stoly a rezervace
     * ze zvláštních souborů.
     * 
     * @param   cestaText   cesta k souboru
     * @param   typVstupu   rozlišení o jaký typ souboru se jedná
     * @param   jeArchiv   	rozlišení zda jde o JAR nebo ne
     */
	@SuppressWarnings("deprecation")
	public void nacti(String cestaText, int typVstupu, boolean jeArchiv) {
		try {	
			vadnyFormat = false;
			nacetlo = true;
			String radek = null;
			
			String[] odkaz = cestaText.split("/");
			String adresar = System.getProperty("user.dir");
			soubor = new File(adresar, odkaz[2]);
			
			if (jeArchiv) {
				if	(!soubor.createNewFile()) {
					soubor.createNewFile();
				}
				
				vstup = new BufferedReader(new FileReader(soubor));
			}
			else {
				if (soubor.exists()) {
					throw new NullPointerException();
				}
				
				InputStreamReader stream = new InputStreamReader(getClass().getResourceAsStream(cestaText));
				vstup = new BufferedReader(stream);	
			}
			vadnyFormat = true;
			
			switch(typVstupu) {
				case 1: 
					while ((radek=vstup.readLine()) != null) {
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
						restaurace.pridejStul(stul,stulInst);
					}
					vstup.close();
					break;
			
				case 2: 
					while ((radek=vstup.readLine()) != null) {
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
							
							if (restaurace.obsahujeStul(stul)) {
								Stul stulInst = restaurace.getStul(stul);
								Rezervace rezervace = new Rezervace(date,hodina,jmeno,stulInst);
								String popis = stul + " - " + datum.format(date) + " - " + hodina /** + " - " + jmeno **/;
								restaurace.pridejRezervaci(popis,rezervace);
							}
							else {
								if (!restaurace.getSeznamRezervaci().isEmpty()) {
									System.out.println("Stul na který se váže rezervace nenalezen");
									nacetlo = false;
								}
							}			
						}					
					}
					vstup.close();
					break;
			}	
		}
		catch (java.lang.NullPointerException e) { 
			nacetlo = false;
			if (vadnyFormat) {
				System.out.println ("Chyba na vstupu souboru: " + cestaText + " Špatný formát hodnot");
			}
			else {
				pruchodVstup = true;
				if (typVstupu == 1) {
					nacti("/logika/stoly.txt",1,true);
					nacitani1 = true;
					
				}
				else {
					nacti("/logika/rezervace.txt",2,true);
					nacitani2 = true;
				}	
			}
		}
		
		catch (Exception e) { 
			System.out.println ("Chyba na vstupu souboru: " + cestaText + " Špatný formát hodnot");
			nacetlo = false;
		}
	}
	
	/**
	 * Metoda pro ukládání dat do souboru. Data se ukládají do specializovaných
	 * souborů.
	 * 
	 * @param   cestaText   cesta k souboru
	 * @param   typVstupu   rozlišení o jaký typ souboru se jedná
	 * @param   jeArchiv   	rozlišení zda jde o JAR nebo ne
	 */
	@SuppressWarnings("deprecation")
	public void uloz(String cestaText, int typVystupu, boolean jeArchiv) {
		try {
			String[] odkaz = cestaText.split("/");
			String adresar = System.getProperty("user.dir");
			File soubor = new File(adresar, odkaz[4]);
			
			if (jeArchiv) {
				
				if	(!soubor.createNewFile()) {
					soubor.createNewFile();
				}
			
				vystup = new BufferedWriter(new FileWriter(soubor));	
			}
			else {
				
				if (soubor.exists()) {
					throw new NullPointerException();
				}
				
				vystup = new BufferedWriter(new FileWriter(cestaText));	
			}
			
			switch(typVystupu) {
				case 1: 
					for (String stul: restaurace.getSeznamStolu().keySet()) {
						String pocetMist = String.valueOf(restaurace.getStul(stul).getPocetMist());
						String nekuracky = String.valueOf(restaurace.getStul(stul).isNekuracky());
						String vystupText = stul + ";" + pocetMist + ";" + nekuracky;
						vystup.write(vystupText);
						vystup.newLine();
					}	
					vystup.close();	
					break;
				
				case 2: 
					for (String rezervace: restaurace.getSeznamRezervaci().keySet()) {
						String stul = null;
						
						for (String seznam: restaurace.getSeznamStolu().keySet()) {
							if (restaurace.getStul(seznam).equals(restaurace.getRezervace(rezervace).getStul())){
								stul = seznam;
							}
						}
						
						String den = String.valueOf(restaurace.getRezervace(rezervace).getDatum().getDate());
						String mesic = String.valueOf(restaurace.getRezervace(rezervace).getDatum().getMonth()+1);
						String rok = String.valueOf(restaurace.getRezervace(rezervace).getDatum().getYear()+1900);
						String hodina = String.valueOf(restaurace.getRezervace(rezervace).getHodina());
						String jmeno = String.valueOf(restaurace.getRezervace(rezervace).getJmeno());
						String vystupText = stul + ";" + den + ";" + mesic + ";" + rok + ";" + hodina + ";" + jmeno;
						vystup.write(vystupText);
						vystup.newLine();
					}	
					vystup.close();	
					break;
			}
		}
		
		catch (Exception e) { 
			if (nacitani1 && typVystupu == 1) {
				uloz("src/main/resources/logika/stoly.txt",1,true);
			}
			else {
				if (nacitani2 && typVystupu == 2) {
					uloz("src/main/resources/logika/rezervace.txt",2,true);
				}
				else {
					if (typVystupu == 1) {
						uloz("src/main/resources/logika/stoly.txt",1,true);
					}
					else {
						uloz("src/main/resources/logika/rezervace.txt",2,true);
					}	
				}
			}
		}
	}
}
