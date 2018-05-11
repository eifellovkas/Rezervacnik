package com.github.eifellovkas.Rezervacnik;

import org.junit.Before;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;

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
}
