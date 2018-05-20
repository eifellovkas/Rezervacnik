/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.eifellovkas.Rezervacnik.logika;
import java.util.Date;

/**
 *
 * @author plev00
 */

public class Rezervace {
        
        private Date datum;
	private int hodina;
	private String jmeno;
        private Stul stul;

    public Rezervace(Date datum, int hodina, String jmeno, Stul stul) {
        this.datum = datum;
        this.hodina = hodina;
        this.jmeno = jmeno;
        this.stul = stul;
    }
    /**
    * Getter pro získání stolu
    */
    public Stul getStul() {
        return stul;
    }
    /**
    * Setter pro nastavení stolu
    */
    public void setStul(Stul stul) {
        this.stul = stul;
    }
        
    /**
    * Getter pro získání data
    */
    public Date getDatum() {
        return datum;
    }
    /**
    * Getter pro nastavení data
    * @param Date datum - datum typu Date
    */
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    /**
    * Getter pro získání hodiny rezervace
    */
    public int getHodina() {
        return hodina;
    }
    /**
    * Getter pro nastavení hodiny
    * @param int hodina - hodina typu int
    */
    public void setHodina(int hodina) {
        this.hodina = hodina;
    }
    /**
    * Getter pro získání jména přiděleného k rezervaci
    */
    public String getJmeno() {
        return jmeno;
    }
    /**
    * Getter pro nastavení jména
    * @param String jmeno - jméno typu string
    */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
	
}

