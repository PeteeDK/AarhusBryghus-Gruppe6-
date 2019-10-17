package model;

public class ProduktLeaf extends Produkt {
	
	private String katagori; 
	private String produktNavn; 
	private double mængde; 
	private double fredagsbarPris; 
	private double butiksPris; 
	private double ølStørrelse; 
	private double pant; 
	private String pakketIndhold;
	private int antal;
	
	
	public ProduktLeaf(String katagori, String produktNavn, double mængde, double fredagsbarPris, double butiksPris,
			double ølStørrelse, double pant, String pakketIndhold, int antal) {
		this.katagori = katagori;
		this.produktNavn = produktNavn;
		this.mængde = mængde;
		this.fredagsbarPris = fredagsbarPris;
		this.butiksPris = butiksPris;
		this.ølStørrelse = ølStørrelse;
		this.pant = pant;
		this.pakketIndhold = pakketIndhold;
	}


	public String getKatagori() {
		return katagori;
	}


	public String getProduktNavn() {
		return produktNavn;
	}


	public double getMængde() {
		return mængde;
	}


	public double getFredagsbarPris() {
		return fredagsbarPris;
	}


	public double getButiksPris() {
		return butiksPris;
	}


	public double getØlStørrelse() {
		return ølStørrelse;
	}


	public double getPant() {
		return pant;
	}


	public String getPakketIndhold() {
		return pakketIndhold;
	}


	public int getAntal() {
		return antal;
	}

	
	
	
}
