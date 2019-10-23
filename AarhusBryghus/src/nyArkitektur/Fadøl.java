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
		//TODO Hvad skal der ske hvis man prøver at bestille en fadøl på en ikke-fredag
		return fredagsbarPris;
	}

	public double getØlstørrelse() {
		return ølstørrelse;
	}

	public void setØlstørrelse(double ølstørrelse) {
		this.ølstørrelse = ølstørrelse;
	}

	public double getFredagsbarPris() {
		return fredagsbarPris;
	}

	public void setFredagsbarPris(double fredagsbarPris) {
		this.fredagsbarPris = fredagsbarPris;
	}
	
	
}
