package com.github.eifellovkas.Rezervacnik;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.eifellovkas.Rezervacnik.logika.Restaurace;

import junit.framework.TestCase;

public class NacitaniTest {
	private Restaurace restaurace;
	
    @Before
    public void setUp() {
        restaurace  = new Restaurace();
    }
    
    @Test
	public void existujeSoubor1() {
    	// chybně zadaný název. Nacitame stul. Zdroj seznam stolů
		restaurace.nacti("/logika/testVystu.txt",1);
		assertEquals(false, restaurace.isNacetly());
    }
    
    @Test
	public void existujeSoubor2() {
		// správný název. Nacitame stul. Zdroj seznam stolů
		restaurace.nacti("/logika/testVystup.txt",1);
		assertEquals(true, restaurace.isNacetly());
    }
    
    @Test
	public void existujeSoubor3() {
		// chybně zadaný název Nacitame rezervace. Zdroj seznam stolů
    	restaurace.nacti("/logika/testVystup.txt",1);
    	restaurace.nacti("/logika/testVystu.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    @Test
	public void existujeSoubor4() {
		// správný název. Nacitame rezervace. Zdroj seznam stolů
    	restaurace.nacti("/logika/testVystup.txt",1);
    	restaurace.nacti("/logika/testVystup.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    @Test
	public void existujeSoubor5() {
    	// chybně zadaný název. Nacitame stul. Zdroj seznam rezervaci
		restaurace.nacti("/logika/testVystu.txt",1);
		assertEquals(false, restaurace.isNacetly());
    }
    
    @Test
	public void existujeSoubor6() {
		// správný název. Nacitame stul. Zdroj seznam rezervaci
		restaurace.nacti("/logika/testVystup1.txt",1);
		assertEquals(false, restaurace.isNacetly());
    }
    
    @Test
	public void existujeSoubor7() {
		// chybně zadaný název. Nacitame rezervace. Zdroj seznam rezervaci
    	restaurace.nacti("/logika/testVystup.txt",1);
    	restaurace.nacti("/logika/testVystu.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    @Test
	public void existujeSoubor8() {
		// správný název. Nacitame rezervace. Zdroj seznam rezervaci
		restaurace.nacti("/logika/testVystup.txt",1);
		restaurace.nacti("/logika/testVystup1.txt",2);
		assertEquals(true, restaurace.isNacetly());
	}
    
    @Test
	public void nacetloSpravne1() {
    	//stoly se načetly
		restaurace.nacti("/logika/testVystup.txt",1);
		assertEquals(true, restaurace.isNacetly());
    }
    
    @Test
	public void nacetloSpravne2() {
		//ve stolech je chyba
		restaurace.nacti("/logika/testVystup2.txt",1);
		assertEquals(false, restaurace.isNacetly());
    }	
	
    @Test
	public void nacetloSpravne3() {
    	//rezervace se načetly
		restaurace.nacti("/logika/testVystup.txt",1);
		restaurace.nacti("/logika/testVystup1.txt",2);
		assertEquals(true, restaurace.isNacetly());
    }
    
    @Test
	public void nacetloSpravne4() {
		//v rezervacich je chyba
    	restaurace.nacti("/logika/testVystup.txt",1);
		restaurace.nacti("/logika/testVystup3.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    @Test
	public void nacetloSpravne5() {
		//stul chybí
		restaurace.nacti("/logika/testVystup4.txt",1);
		restaurace.nacti("/logika/testVystup1.txt",2);
		assertEquals(false, restaurace.isNacetly());
    }
    
    @Test
	public void nacetloSpravne6() {
		//prazdny stoly
		restaurace.nacti("/logika/testVystup5.txt",1);
		assertEquals(true, restaurace.isNacetly());
    }
    
    @Test
	public void nacetloSpravne7() {
		//prazdne rezervace
		restaurace.nacti("/logika/testVystup5.txt",2);
		assertEquals(true, restaurace.isNacetly());
    }

}
