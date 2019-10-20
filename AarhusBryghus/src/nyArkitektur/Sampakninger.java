package nyArkitektur;

import java.time.DayOfWeek;

public class Sampakninger extends Produkt {

	private int antalØl;
	private int antalGlas;
	private double fredagsbarPris;
	private double butiksPris;
	
	public Sampakninger(String kategori, String produktNavn, int antalØl, int antalGlas, double fredagsbarPris,
			double butiksPris) {
		super(kategori, produktNavn);
		this.antalØl = antalØl;
		this.antalGlas = antalGlas;
		this.fredagsbarPris = fredagsbarPris;
		this.butiksPris = butiksPris;
	}

	@Override
	public double getPris() {
		if(Salgssituation.isFredagsbarMode()) {
			return fredagsbarPris;
		}else {
			return butiksPris;
		}
	}

	public int getAntalØl() {
		return antalØl;
	}

	public void setAntalØl(int antalØl) {
		this.antalØl = antalØl;
	}

	public int getAntalGlas() {
		return antalGlas;
	}

	public void setAntalGlas(int antalGlas) {
		this.antalGlas = antalGlas;
	}

	public double getFredagsbarPris() {
		return fredagsbarPris;
	}

	public void setFredagsbarPris(double fredagsbarPris) {
		this.fredagsbarPris = fredagsbarPris;
	}

	public double getButiksPris() {
		return butiksPris;
	}

	public void setButiksPris(double butiksPris) {
		this.butiksPris = butiksPris;
	}
	
	
}
