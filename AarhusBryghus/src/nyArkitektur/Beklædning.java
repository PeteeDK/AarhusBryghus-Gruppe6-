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
		if(getUgedag().equals(DayOfWeek.FRIDAY)) {
			return fredagsbarPris;
		}else {
			return butiksPris;
		}
	}
	
}
