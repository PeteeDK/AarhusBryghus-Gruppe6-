package nyArkitektur;

import java.time.DayOfWeek;

public class Beklædning extends Produkt {

	private double fredagsbarPris;
	private double butiksPris;
	
	public Beklædning(String kategori, String produktNavn, double fredagsbarPris, double butiksPris) {
		super(kategori, produktNavn);
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
