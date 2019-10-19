package nyArkitektur;

public class Fustage extends Produkt {

	private double mængde;
	
	public Fustage(String kategori, String produktNavn, double pris, double mængde) {
		super(kategori, produktNavn, pris);
		// TODO Auto-generated constructor stub
		this.mængde = mængde;
	}
	
	
	
	
	public double getPrisPrLiter() {
		return (getButiksPris()/getMængde());
	}

	public double getMængde() {
		return mængde;
	}
	
}
