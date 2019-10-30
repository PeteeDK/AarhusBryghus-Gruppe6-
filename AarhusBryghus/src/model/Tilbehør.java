package model;

public class Tilbehør extends Produkt {

	private double mængde;
	private double pant;
	
	public Tilbehør(String kategori, String produktNavn, double mængde) {
		super(kategori, produktNavn);
		this.mængde = mængde;
		//pant for fustage- og kulsyre-produkter kan kun være hhv. 200 og 1000. Hvis der bliver behov for at specificere en anden værdi, kan man udvidde klassen med en ekstra constructor, der tager pant som parameter 
		if(kategori.equals("fustage")) {
			pant = 200;	
		}else if(kategori.equals("kulsyre")) {
			pant = 1000; 
		}
	}

	public double getMængde() {
		return mængde;
	}

	public void setMængde(double mængde) {
		if(mængde < 0) {
			throw new IllegalArgumentException("Mængden kan ikke være negativ");
		}
		this.mængde = mængde;
	}

	public double getPant() {
		return pant;
	}

	public void setPant(double pant) {
		if(pant < 0) {
			throw new IllegalArgumentException("Panten kan ikke være negativ");
		}
		this.pant = pant;
	}


	
	
	
}
