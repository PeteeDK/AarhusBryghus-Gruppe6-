package nyArkitektur;


public class Fadøl extends Produkt{

	private double ølstørrelse;
	private double fredagsbarPris;
	
	public Fadøl(String kategori, String produktNavn, double ølstørrelse, double fredagsbarPris) {
		super(kategori, produktNavn);
		this.ølstørrelse = ølstørrelse;
		this.fredagsbarPris = fredagsbarPris;
	}

	@Override
	public double getPris() {
		return fredagsbarPris;
	}
	
}
