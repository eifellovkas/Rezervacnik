package com.github.eifellovkas.Rezervacnik.logika;

import java.util.HashMap;

public class Restaurace {
	private int pocetStolu = 0;
//	private HashMap<String,Stul> seznamStolu;
//	private HashMap<String, Rezervace> seznamRezervaci;

		public Restaurace() {
		}
		
		public void pokus() {
			System.out.println("aaaa");
		}
		
		public int getPocetStolu() {
			return pocetStolu;
		}
		
		public void setPocetStolu(int pocetStolu) {
			this.pocetStolu = pocetStolu;
		}
		
//		public void pridejStul(String nazev, Stul stul) {
//			seznamStolu.put(nazev, stul);
//		}
		
//		public void odeberStul(String nazev) {
//			seznamStolu.remove(nazev, stul);
//		}

}
