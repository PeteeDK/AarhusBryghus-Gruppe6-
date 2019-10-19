package nyArkitektur;

import java.time.DayOfWeek;

public class Fadøl extends Produkt{

	private double ølStørrelse;

	public Fadøl(String kategori, String produktNavn, double pris, double ølStørrelse) {
		super(kategori, produktNavn, pris);
		this.ølStørrelse = ølStørrelse;
	}
	
	@Override
	public double getPris() {
		return getFredagsbarPris();
	}
}
