package nyArkitektur;

public class Glas extends Produkt {

	private double butiksPris;

	public Glas(String kategori, String produktNavn, double butiksPris) {
		super(kategori, produktNavn);
		this.butiksPris = butiksPris;
	}

	@Override
	public double getPris() {
		return butiksPris;
	}
	
}
