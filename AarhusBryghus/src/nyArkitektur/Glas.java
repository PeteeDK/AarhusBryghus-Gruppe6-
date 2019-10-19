package nyArkitektur;

public class Glas extends Produkt {

	public Glas(String kategori, String produktNavn, double pris) {
		super(kategori, produktNavn, pris);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPris() {
		return getButiksPris();
	}
	
}
