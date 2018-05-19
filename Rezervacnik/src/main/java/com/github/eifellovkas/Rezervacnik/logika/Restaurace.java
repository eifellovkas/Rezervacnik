package com.github.eifellovkas.Rezervacnik.logika;

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
	
	/**
     * Konstruktor pro vytvoření restaurace.
     * 
     */
	public Restaurace() {
		seznamStolu = new HashMap<String, Stul>();
		seznamRezervaci = new HashMap<String, Rezervace>();		
	}
	
	/**
     * Metoda pro úpravu seznamu rezervací. Slouží k úpravě klíče.
     * 
     *  @param   rezervace  daná rezervace
     *  @param   stare		starý klíč
     *  @param   nove		nový klíč
     */
	public void upravSeznamRezervaci(Rezervace rezervace, String stare, String nove) {
		odeberRezervaci(stare, rezervace);
		pridejRezervaci(nove, rezervace);
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
