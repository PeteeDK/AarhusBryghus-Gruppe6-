package nyArkitektur;

public class Malt extends Produkt {

	private double kg;
	private double butiksPris;
	
	public Malt(String kategori, String produktNavn, double kg, double butiksPris) {
		super(kategori, produktNavn);
		this.kg = kg;
		this.butiksPris = butiksPris;
	}

	@Override
	public double getPris() {
		return butiksPris;
	}
	
	public double getKg() {
		return kg;
	}

	public double getButiksPris() {
		return butiksPris;
	}

	public void setButiksPris(double butiksPris) {
		this.butiksPris = butiksPris;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}
	
	
}
