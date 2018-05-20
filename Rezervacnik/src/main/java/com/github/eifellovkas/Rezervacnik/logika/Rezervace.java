package com.github.eifellovkas.Rezervacnik.logika;
import java.util.Date;

/*******************************************************************************
 * Třída Rezervace slouží ke správě rezervací
 *
 * @author     Václav Pleskač
 * @version    LS 2017/2018 (upraveno 20.5.2018)
 */
public class Rezervace {
        private Date 	datum;
        private int 	hodina;
        private String 	jmeno;
        private Stul 	stul;

        /**
         * Konstruktor pro vytvoření rezervace
         * 
         * @param datum		datum rezervace
         * @param hodina	hodina rezervace
         * @param jmeno		jmeno na které je rezervace
         * @param stul		cislo stolu rezervace
         */
    public Rezervace(Date datum, int hodina, String jmeno, Stul stul) {
        this.datum = datum;
        this.hodina = hodina;
        this.jmeno = jmeno;
        this.stul = stul;
    }
    
    /**
    * Getter pro získání stolu
    * 
    * @return vrací stůl
    */
    public Stul getStul() {
        return stul;
    }
    
    /**
    * Setter pro nastavení stolu
    * 
    * @param	stul	stůl co přidáváme
    */
    public void setStul(Stul stul) {
        this.stul = stul;
    }
        
    /**
    * Getter pro získání data
    * 
    * @return	vrací datum
    */
    public Date getDatum() {
        return datum;
    }
    
    /**
    * Setter pro nastavení data
    * 
    * @param Date 	datum	datum rezervace
    */
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    /**
    * Getter pro získání hodiny rezervace
    * 
    * @return vrací hodinu
    */
    public int getHodina() {
        return hodina;
    }
    
    /**
    * Setter pro nastavení hodiny
    * 
    * @param int hodina - hodina typu int
    */
    public void setHodina(int hodina) {
        this.hodina = hodina;
    }
    
    /**
    * Getter pro získání jména přiděleného k rezervaci
    * 
    * @return vrací jméno
    */
    public String getJmeno() {
        return jmeno;
    }
    
    /**
    * Getter pro nastavení jména
    * 
    * @param String jmeno - jméno typu string
    */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
}

