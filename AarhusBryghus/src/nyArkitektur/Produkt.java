package nyArkitektur;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class Produkt {

	private String kategori;
	private String produktNavn;
	
	public Produkt(String kategori, String produktNavn) {
		this.kategori = kategori.toLowerCase();
		this.produktNavn = produktNavn.toLowerCase();
	}
	
	public abstract double getPris();


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

	
}
