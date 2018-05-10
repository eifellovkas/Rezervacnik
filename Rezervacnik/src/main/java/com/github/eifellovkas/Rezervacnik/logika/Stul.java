package com.github.eifellovkas.Rezervacnik.logika;

public class Stul {

	private int pocetMist;
	private boolean nekuracky = false;
	
	public Stul (int pocetMist, boolean nekuracky) {
	this.pocetMist = pocetMist;
	this.nekuracky = nekuracky;
	}
	
	public int getPocetMist() {
		return pocetMist;
	}
	
	public void setPocetMist(int pocetMist) {
		this.pocetMist = pocetMist;
	}
	
	public boolean isNekuracky() {
		return nekuracky;
	}
	
	public void setNekuracky(boolean nekuracky) {
		this.nekuracky = nekuracky;
	}
}
