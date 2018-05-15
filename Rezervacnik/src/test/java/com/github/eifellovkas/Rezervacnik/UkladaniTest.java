package com.github.eifellovkas.Rezervacnik;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Rezervace;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

/*******************************************************************************
 * Testovací třída UkladaniTest slouží ke komplexnímu otestování
 * ukládání do souboru.
 *
 * @author     Martin Havlík, havlikmar
 * @version    LS 2017/2018 (upraveno 11.5.2018)
 */
public class UkladaniTest {
	private Restaurace restaurace;
	
	/**
     * Metoda pro vytvoření podkladů pro testování
     *     
     */
    @Before
    public void setUp() {
        restaurace  = new Restaurace();
    }
    
    /**
     * Metoda pro testování zda se uloží prázdný soubor
     *     
     */
    @Test
	public void uloziPrazdnySoubor() {
    	restaurace.uloz("/logika/testVystup1.txt", 1);
		restaurace.nacti("/logika/testVystup1.txt",1);
		assertTrue(restaurace.isNacetly());
		restaurace.uloz("/logika/testVystup1.txt", 2);
		restaurace.nacti("/logika/testVystup1.txt",2);
		assertTrue(restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se uloží neprázdný soubor
     *     
     */
    @SuppressWarnings("deprecation")
	@Test
	public void uloziSoubor() {
    	Date date = new Date(1900,6,1);
    	Stul stul = new Stul(5,true);
		restaurace.pridejStul("a", stul);
		restaurace.uloz("/logika/testVystup2.txt", 1);
		restaurace.nacti("/logika/testVystup2.txt",1);
		assertTrue(restaurace.isNacetly());		
		assertTrue(restaurace.obsahujeStul("a"));
		Rezervace rezervace = new Rezervace(date,15,"a",stul);
		restaurace.pridejRezervaci("a", rezervace);
		restaurace.uloz("/logika/testVystup3.txt", 2);
		restaurace.nacti("/logika/testVystup3.txt",2);
		assertTrue(restaurace.isNacetly());
		assertTrue(restaurace.obsahujeRezervaci("a"));
    }
}
