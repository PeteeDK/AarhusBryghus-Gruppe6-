package nyArkitektur;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Produkt {

	private String kategori;
	private String produktNavn;
	private DayOfWeek ugedag;
	private double fredagsbarPris;
	private double butiksPris;
	
	public Produkt(String kategori, String produktNavn, double fredagsbarPris, double butiksPris) {
		this.kategori = kategori;
		this.produktNavn = produktNavn;
		this.fredagsbarPris = fredagsbarPris;
		this.butiksPris = butiksPris;
		this.ugedag = LocalDate.now().getDayOfWeek();
	}
	
	public Produkt(String kategori, String produktNavn, double pris) {
		this.kategori = kategori;
		this.produktNavn = produktNavn;
		setPris(pris);
		this.ugedag = LocalDate.now().getDayOfWeek();
	}
	

	private void setPris(double pris) {
		if(getUgedag().equals(DayOfWeek.FRIDAY)) {
			fredagsbarPris = pris;
		}else {
			butiksPris = pris;
		}
	}
	
	public DayOfWeek getUgedag() {
		return ugedag;
	}
	
	public double getPris() {
		if(getUgedag().equals(DayOfWeek.FRIDAY)) {
			return fredagsbarPris;
		}else {
			return butiksPris;
		}
	}
	
	public double getFredagsbarPris() {
		return fredagsbarPris;
	}

	public double getButiksPris() {
		return butiksPris;
	}

}
