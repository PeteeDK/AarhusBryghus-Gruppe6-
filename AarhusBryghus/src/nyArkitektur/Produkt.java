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
	
	//for produkter med enten fredagsbarpriser eller butikspriser. Om man kan vælge produkterne den
	//pågældende dag, må evt. placeres under salgssituation
	public Produkt(String kategori, String produktNavn, double pris) {
		this.kategori = kategori;
		this.produktNavn = produktNavn;
		this.ugedag = LocalDate.now().getDayOfWeek();
		setPris(pris);
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

	public String getKategori() {
		return kategori;
	}

	public String getProduktNavn() {
		return produktNavn;
	}

	@Override
	public String toString() {
		return "Produkt [kategori=" + kategori + ", produktNavn=" + produktNavn + ", ugedag=" + ugedag
				+ ", fredagsbarPris=" + fredagsbarPris + ", butiksPris=" + butiksPris + "]";
	}

	
	
}
