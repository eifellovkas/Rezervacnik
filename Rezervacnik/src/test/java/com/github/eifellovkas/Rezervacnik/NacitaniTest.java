package com.github.eifellovkas.Rezervacnik;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;

/*******************************************************************************
 * Testovací třída NacitaniTest slouží ke komplexnímu otestování
 * načítání vstupních dat
 *
 * @author     Martin Havlík, havlikmar
 * @version    LS 2017/2018 (upraveno 11.5.2018)
 */
public class NacitaniTest {
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
     * Metoda pro testování zda soubor existuje.
     * Chybně zadaný název. Nacitame stul. Zdroj seznam stolů
     *     
     */
    @Test
	public void existujeSoubor1() {
		restaurace.nacti("/logika/testVystu.txt",1);
		assertEquals(false, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Správný název. Nacitame stul. Zdroj seznam stolů
     *     
     */
    @Test
	public void existujeSoubor2() {
		restaurace.nacti("/logika/testVystup.txt",1);
		assertEquals(true, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Chybně zadaný název Nacitame rezervace. Zdroj seznam stolů
     *     
     */
    @Test
	public void existujeSoubor3() {
    	restaurace.nacti("/logika/testVystup.txt",1);
    	restaurace.nacti("/logika/testVystu.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Správný název. Nacitame rezervace. Zdroj seznam stolů
     *     
     */
    @Test
	public void existujeSoubor4() {
    	restaurace.nacti("/logika/testVystup.txt",1);
    	restaurace.nacti("/logika/testVystup.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Chybně zadaný název. Nacitame stul. Zdroj seznam rezervaci
     *     
     */
    @Test
	public void existujeSoubor5() {
		restaurace.nacti("/logika/testVystu.txt",1);
		assertEquals(false, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Správný název. Nacitame stul. Zdroj seznam rezervaci
     *     
     */
    @Test
	public void existujeSoubor6() {
		restaurace.nacti("/logika/testVystup1.txt",1);
		assertEquals(false, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Chybně zadaný název. Nacitame rezervace. Zdroj seznam rezervaci
     *     
     */
    @Test
	public void existujeSoubor7() {
    	restaurace.nacti("/logika/testVystup.txt",1);
    	restaurace.nacti("/logika/testVystu.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda soubor existuje.
     * Správný název. Nacitame rezervace. Zdroj seznam rezervaci
     *     
     */
    @Test
	public void existujeSoubor8() {
		restaurace.nacti("/logika/testVystup.txt",1);
		restaurace.nacti("/logika/testVystup1.txt",2);
		assertEquals(true, restaurace.isNacetly());
	}
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Stoly se načetly
     *     
     */
    @Test
	public void nacetloSpravne1() {
		restaurace.nacti("/logika/testVystup.txt",1);
		assertEquals(true, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Ve stolech je chyba
     *     
     */
    @Test
	public void nacetloSpravne2() {
		restaurace.nacti("/logika/testVystup2.txt",1);
		assertEquals(false, restaurace.isNacetly());
    }	
	
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Rezervace se načetly
     *     
     */
    @Test
	public void nacetloSpravne3() {
		restaurace.nacti("/logika/testVystup.txt",1);
		restaurace.nacti("/logika/testVystup1.txt",2);
		assertEquals(true, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * V rezervacich je chyba
     *     
     */
    @Test
	public void nacetloSpravne4() {
    	restaurace.nacti("/logika/testVystup.txt",1);
		restaurace.nacti("/logika/testVystup3.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Stul chybí
     *     
     */
    @Test
	public void nacetloSpravne5() {
		restaurace.nacti("/logika/testVystup4.txt",1);
		restaurace.nacti("/logika/testVystup1.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Prazdny stoly
     *     
     */
    @Test
	public void nacetloSpravne6() {
		restaurace.nacti("/logika/testVystup5.txt",1);
		assertEquals(true, restaurace.isNacetly());
    }
    
    /**
     * Metoda pro testování zda se soubor načetl správně.
     * Prazdne rezervace
     *     
     */
    @Test
	public void nacetloSpravne7() {
		restaurace.nacti("/logika/testVystup5.txt",2);
		assertEquals(true, restaurace.isNacetly());
    }

}
