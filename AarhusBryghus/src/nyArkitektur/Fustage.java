package nyArkitektur;

public class Fustage extends Produkt {

	private double mængde;
	
	public Fustage(String kategori, String produktNavn, double pris, double mængde) {
		super(kategori, produktNavn, pris);
		// TODO Auto-generated constructor stub
		this.mængde = mængde;
	}
	
	@Override
	public double getPris() {
		return getButiksPris();
	}
	
}
