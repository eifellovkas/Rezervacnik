package com.github.eifellovkas.Rezervacnik;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;
import com.github.eifellovkas.Rezervacnik.logika.Soubor;

/*******************************************************************************
 * Testovací třída NacitaniTest slouží ke komplexnímu otestování
 * načítání vstupních dat
 *
 * @author     Martin Havlík, havlikmar
 * @version    LS 2017/2018 (upraveno 11.5.2018)
 */
public class NacitaniTest {
	private Restaurace restaurace;
	private Soubor soubor;
	
	/**
     * Metoda pro vytvoření podkladů pro testování
     *     
     */
    @Before
    public void setUp() {
        restaurace  = new Restaurace();
        soubor = new Soubor(restaurace);
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Chybně zadaný název. Nacitame stul. Zdroj seznam stolů
     *     
     */
    @Test
	public void existujeSoubor1() {
		soubor.nacti("/logika/testVstu.txt",1,false);
		assertTrue(soubor.isNacetly());
		// pozn. test projde jelikož se vytvoří zadaný soubor.
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Správný název. Nacitame stul. Zdroj seznam stolů
     *     
     */
    @Test
	public void existujeSoubor2() {
		soubor.nacti("/logika/testVstup.txt",1,false);
		assertTrue(soubor.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Chybně zadaný název Nacitame rezervace. Zdroj seznam stolů
     *     
     */
    @Test
	public void existujeSoubor3() {
    	soubor.nacti("/logika/testVstup.txt",1,false);
    	soubor.nacti("/logika/testVstu.txt",2,false);
    	assertTrue(soubor.isNacetly());
    	// pozn. test projde jelikož se vytvoří zadaný soubor.
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Správný název. Nacitame rezervace. Zdroj seznam stolů
     *     
     */
    @Test
	public void existujeSoubor4() {
    	soubor.nacti("/logika/testVstup.txt",1,false);
    	soubor.nacti("/logika/testVstup.txt",2,false);
    	assertFalse(soubor.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Chybně zadaný název. Nacitame stul. Zdroj seznam rezervaci
     *     
     */
    @Test
	public void existujeSoubor5() {
    	soubor.nacti("/logika/testVstu.txt",1,false);
		assertTrue(soubor.isNacetly());
		// pozn. test projde jelikož se vytvoří zadaný soubor.
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Správný název. Nacitame stul. Zdroj seznam rezervaci
     *     
     */
    @Test
	public void existujeSoubor6() {
    	soubor.nacti("/logika/testVstup1.txt",1,false);
		assertFalse(soubor.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Chybně zadaný název. Nacitame rezervace. Zdroj seznam rezervaci
     *     
     */
    @Test
	public void existujeSoubor7() {
    	soubor.nacti("/logika/testVstup.txt",1,false);
    	soubor.nacti("/logika/testVstu.txt",2,false);
    	assertTrue(soubor.isNacetly());
    	// pozn. test projde jelikož se vytvoří zadaný soubor.
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Správný název. Nacitame rezervace. Zdroj seznam rezervaci
     *     
     */
    @Test
	public void existujeSoubor8() {
    	soubor.nacti("/logika/testVstup.txt",1,false);
    	soubor.nacti("/logika/testVstup1.txt",2,false);
		assertTrue(soubor.isNacetly());
	}
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Stoly se načetly
     *     
     */
    @Test
	public void nacetloSpravne1() {
    	soubor.nacti("/logika/testVstup.txt",1,false);
		assertTrue(soubor.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Ve stolech je chyba
     *     
     */
    @Test
	public void nacetloSpravne2() {
    	soubor.nacti("/logika/testVstup2.txt",1,false);
		assertFalse(soubor.isNacetly());
    }	
	
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Rezervace se načetly
     *     
     */
    @Test
	public void nacetloSpravne3() {
    	soubor.nacti("/logika/testVstup.txt",1,false);
    	soubor.nacti("/logika/testVstup1.txt",2,false);
		assertTrue(soubor.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * V rezervacich je chyba
     *     
     */
    @Test
	public void nacetloSpravne4() {
    	soubor.nacti("/logika/testVstup.txt",1,false);
    	soubor.nacti("/logika/testVstup3.txt",2,false);
		assertFalse(soubor.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Stul chybí
     *     
     */
    @Test
	public void nacetloSpravne5() {
    	soubor.nacti("/logika/testVstup4.txt",1,false);
		soubor.nacti("/logika/testVstup1.txt",2,false);
		assertFalse(soubor.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Prazdny stoly
     *     
     */
    @Test
	public void nacetloSpravne6() {
    	soubor.nacti("/logika/testVstup5.txt",1,false);
		assertTrue(soubor.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Prazdne rezervace
     *     
     */
    @Test
	public void nacetloSpravne7() {
    	soubor.nacti("/logika/testVstup5.txt",2,false);
		assertTrue(soubor.isNacetly());
    }
}
