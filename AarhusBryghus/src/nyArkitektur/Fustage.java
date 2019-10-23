package nyArkitektur;

public class Fustage extends Produkt {

	private double liter;
	private double butiksPris;
	private double pant;
	
	//fustage har egentlig ikke et produktNavn, men der taget højde for det ved at angive produktnavn med
	//" ",  når varen registreres
	public Fustage(String kategori, String produktNavn, double liter, double butiksPris, double pant) {
		super(kategori, produktNavn);
		this.liter = liter;
		this.butiksPris = butiksPris;
		this.pant = pant;
	}

	 
	public double getLiter() {
		return liter;
	}

	public void setLiter(double liter) {
		this.liter = liter;
	}

	public double getButiksPris() {
		return butiksPris;
	}

	public double getPant() {
		return pant;
	}

	public double getPrisPrLiter() {
		return (getPris()/getLiter());
	}

	@Override
	public double getPris() {
		return butiksPris;
	}


	public void setButiksPris(double butiksPris) {
		this.butiksPris = butiksPris;
	}


	public void setPant(double pant) {
		this.pant = pant;
	}
	
	
	
}
