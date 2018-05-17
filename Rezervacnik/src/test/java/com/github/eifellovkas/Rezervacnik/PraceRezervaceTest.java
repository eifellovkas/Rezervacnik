package com.github.eifellovkas.Rezervacnik;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Rezervace;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

/*******************************************************************************
 * Testovací třída PraceRezervaceTest slouží ke komplexnímu otestování
 * práce s rezervace
 *
 * @author     Martin Havlík, havlikmar
 * @version    LS 2017/2018 (upraveno 11.5.2018)
 */
public class PraceRezervaceTest {
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
     * Metoda pro testování práce s rezervacemi
     *     
     */
	@Test
	@SuppressWarnings("deprecation")
	public void rezervaceTest() {
    	assertTrue(restaurace.getSeznamRezervaci().isEmpty());
    	assertFalse(restaurace.obsahujeRezervaci("a"));
    	
    	Date date = new Date(1900,6,1);
    	Stul stul = new Stul(5,true);
		Rezervace rezervace = new Rezervace(date,15,"a",stul);
		restaurace.pridejRezervaci("a", rezervace);
		assertFalse(restaurace.getSeznamRezervaci().isEmpty());
		assertTrue(restaurace.obsahujeRezervaci("a"));
		assertFalse(restaurace.obsahujeRezervaci("b"));
		
		restaurace.odeberRezervaci("a", rezervace);
		assertTrue(restaurace.getSeznamRezervaci().isEmpty());
    }
}
