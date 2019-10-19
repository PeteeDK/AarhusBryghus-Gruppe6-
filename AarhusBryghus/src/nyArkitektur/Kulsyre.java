package nyArkitektur;

public class Kulsyre extends Produkt {

	private double mængde;

	public Kulsyre(String kategori, String produktNavn, double fredagsbarPris, double butiksPris, double mængde) {
		super(kategori, produktNavn, fredagsbarPris, butiksPris);
		this.mængde = mængde;
	}
	
}
