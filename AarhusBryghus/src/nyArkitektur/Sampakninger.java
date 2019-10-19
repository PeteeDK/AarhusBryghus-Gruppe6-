package nyArkitektur;

public class Sampakninger extends Produkt {

	private int antalØl;
	private int antalGlas;
	
	public Sampakninger(String kategori, String produktNavn, double fredagsbarPris, double butiksPris, int antalØl,
			int antalGlas) {
		super(kategori, produktNavn, fredagsbarPris, butiksPris);
		this.antalØl = antalØl;
		this.antalGlas = antalGlas;
	}
	
}
