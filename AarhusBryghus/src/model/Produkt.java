package model;

import java.util.ArrayList;

public class Produkt {

	private String kategori;
	private String produktNavn;
	
	public Produkt(String kategori, String produktNavn) {
		this.kategori = kategori.toLowerCase().trim();
		this.produktNavn = produktNavn.toLowerCase().trim();
	} 
	
	public String getKategori() {
		return kategori;
	}

	public String getProduktNavn() {
		return produktNavn;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public void setProduktNavn(String produktNavn) {
		this.produktNavn = produktNavn;
	}

	@Override
	public String toString() {
		return "Produkt [kategori=" + kategori + ", produktNavn=" + produktNavn + "]";
	}

	
	
}
