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
		if(getUgedag().equals(DayOfWeek.FRIDAY)) {
			return fredagsbarPris;
		}else {
			return butiksPris;
		}
	}
	
	
	
	
	
}
