package nyArkitektur;

import java.time.DayOfWeek;

public class Spiritus extends Produkt {

	private double butiksPris;
	private double fredagsbarPris;
	
	public Spiritus(String kategori, String produktNavn, double butiksPris, double fredagsbarPris) {
		super(kategori, produktNavn);
		this.butiksPris = butiksPris;
		this.fredagsbarPris = fredagsbarPris;
	}

	@Override
	public double getPris() {
		if(Salgssituation.isFredagsbarMode()) {
			return fredagsbarPris;
		}else {
			return butiksPris;
		}
	}

	public double getButiksPris() {
		return butiksPris;
	}

	public void setButiksPris(double butiksPris) {
		this.butiksPris = butiksPris;
	}

	public double getFredagsbarPris() {
		return fredagsbarPris;
	}

	public void setFredagsbarPris(double fredagsbarPris) {
		this.fredagsbarPris = fredagsbarPris;
	}

	@Override
	public String toString() {
		return "Spiritus [butiksPris=" + butiksPris + ", fredagsbarPris=" + fredagsbarPris + "]";
	}
	
	
	
}
