package nyArkitektur;

import java.time.DayOfWeek;

public class Kulsyre extends Produkt {

	private double kg;
	private double fredagsbarPris;
	private double butiksPris;
	private double pant;
	
	public Kulsyre(String kategori, String produktNavn, double kg, double fredagsbarPris, double butiksPris,
			double pant) {
		super(kategori, produktNavn);
		this.kg = kg;
		this.fredagsbarPris = fredagsbarPris;
		this.butiksPris = butiksPris;
		this.pant = pant;
	}

	@Override
	public double getPris() {
		if(getUgedag().equals(DayOfWeek.FRIDAY)) {
			return fredagsbarPris;
		}else {
			return butiksPris;
		}
	}
	
	public double getPrisPrKg() {
		return (getPris()/getKg());
	}
	
	public double getKg() {
		return kg;
	}
		
}
