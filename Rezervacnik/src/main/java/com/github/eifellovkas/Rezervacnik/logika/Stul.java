package com.github.eifellovkas.Rezervacnik.logika;

/**
 *  Třída Stůl - slouží ke správě stolu.
 *
 *
 *@author     Aneta Bukovjanová, buka00
 *@version    1.0
 *@created    LS 2017/2018 (upraveno 21.05.2018)
 */

public class Stul {

	private int pocetMist;
	private boolean nekuracky = false;
	
	/**
    * Konstruktor pro vytvoření rezervace
    * 
    * @param pocetMist 	počet míst u stolu
    * @param nekuracky	nekuřácký stůl
    */
	public Stul (int pocetMist, boolean nekuracky) {
	this.pocetMist = pocetMist;
	this.nekuracky = nekuracky;
	}
	
	/**
	 * Getter pro počtu míst
	 * 
	 * @return vrací počet míst
	*/
	public int getPocetMist() {
		return pocetMist;
	}
	
	/**
	 * Setter pro nastavení počtu míst
	 * 
	 * @param PocetMist 	počet míst u stolu
	 */
	public void setPocetMist(int pocetMist) {
		this.pocetMist = pocetMist;
	}
	
	/**
	 * Metoda pro zjištění zda je stůl nekuřácký
	 * 
	 * @param   	nekuracky  nekuřácký
	 * @return  	vrací zda je nekuřácký
	 */
	public boolean isNekuracky() {
		return nekuracky;
	}
	
	/**
	* Setter pro nastavení, jestli je stůl nekuřácký
	* 
	* @param Nekuracky 	nekuřácký	nekuřácký stůl
    */
	public void setNekuracky(boolean nekuracky) {
		this.nekuracky = nekuracky;
	}
}
