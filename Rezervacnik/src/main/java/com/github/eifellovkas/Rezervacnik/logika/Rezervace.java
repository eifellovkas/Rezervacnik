/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.eifellovkas.Rezervacnik.logika;
import java.util.Date;

/**
 *
 * @author plesk
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
        
    public Stul getStul() {
        return stul;
    }

    public void setStul(Stul stul) {
        this.stul = stul;
    }
        

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getHodina() {
        return hodina;
    }

    public void setHodina(int hodina) {
        this.hodina = hodina;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
	
}

