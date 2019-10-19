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
		if(getUgedag().equals(DayOfWeek.FRIDAY)) {
			return fredagsbarPris;
		}else {
			return butiksPris;
		}
	}
	
}
