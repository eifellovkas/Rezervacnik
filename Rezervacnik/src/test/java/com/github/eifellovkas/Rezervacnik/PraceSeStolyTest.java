package com.github.eifellovkas.Rezervacnik;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Stul;

/*******************************************************************************
 * Testovací třída PraceSeStolyTest slouží ke komplexnímu otestování
 * práce se stoly
 *
 * @author     Martin Havlík, havlikmar
 * @version    LS 2017/2018 (upraveno 11.5.2018)
 */
public class PraceSeStolyTest {
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
     * Metoda pro testování práce se stoly
     *     
     */
    @Test
	public void stolyTest() {
		assertEquals(false, restaurace.obsahujeStul("a"));
		Stul stul = new Stul(5,true);
		restaurace.pridejStul("a", stul);
		assertEquals(true, restaurace.obsahujeStul("a"));
		assertEquals(true, restaurace.obsahujeStul("b"));
    }
}
