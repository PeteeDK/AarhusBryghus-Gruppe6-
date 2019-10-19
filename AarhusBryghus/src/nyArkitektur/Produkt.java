package nyArkitektur;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class Produkt {

	private String kategori;
	private String produktNavn;
	private DayOfWeek ugedag;
	
	public Produkt(String kategori, String produktNavn) {
		this.kategori = kategori;
		this.produktNavn = produktNavn;
		this.ugedag = LocalDate.now().getDayOfWeek();
	}

	
	
	public abstract double getPris();

	public DayOfWeek getUgedag() {
		return ugedag;
	}

	public String getKategori() {
		return kategori;
	}

	public String getProduktNavn() {
		return produktNavn;
	}
	
	
}
