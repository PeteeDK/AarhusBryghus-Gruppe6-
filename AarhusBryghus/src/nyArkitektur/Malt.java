package nyArkitektur;

public class Malt extends Produkt {

	private double mængde;

	public Malt(String kategori, String produktNavn, double pris, double mængde) {
		super(kategori, produktNavn, pris);
		this.mængde = mængde;
	}
	
	@Override
	public double getPris() {
		return getButiksPris();
	}
	
}
