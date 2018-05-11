package com.github.eifellovkas.Rezervacnik;

import org.junit.Before;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;

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
}
