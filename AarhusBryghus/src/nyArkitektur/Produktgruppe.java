package nyArkitektur;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Produktgruppe {

	private String kategori;
	private String produktnavn;
	private double mængde;
	private double fredagsbarPris;
	private double butiksPris;
	private double ølstørrelse;
	private double pant;
	private String pakkeindhold;
	private DayOfWeek ugedag;
	
	public Produktgruppe(String kategori, String produktnavn, double mængde, double fredagsPris, double butiksPris,
			double ølstørrelse, double pant, String pakkeindhold) {
		this.kategori = kategori.trim();
		this.produktnavn = produktnavn.trim();
		this.mængde = mængde;
		this.fredagsbarPris = fredagsPris;
		this.butiksPris = butiksPris;
		this.ølstørrelse = ølstørrelse;
		this.pant = pant;
		this.pakkeindhold = pakkeindhold.trim();
		this.ugedag = LocalDate.now().getDayOfWeek();
	}

	//nogle af produkterne har kun en enkelt pris. Muligvis kan man gruppere dem efter og evt. bruge adapter pattern
	public double beregnPris() {
		if(ugedag.equals(DayOfWeek.FRIDAY)) {
			if(kategori.equals("flaske") || kategori.equals("fadøl") || kategori.equals("spiritus") || kategori.equals("kulsyre") || 
					kategori.equals("beklædning") || (kategori.equals("sampakninger"))){
				return fredagsbarPris;
			}
		}
		else {
			if(kategori.equals("flaske") || kategori.equals("spiritus") || kategori.equals("fustage") || kategori.equals("kulsyre") || 
					kategori.equals("malt") || kategori.equals("glas") || (kategori.equals("sampakninger"))){
				return butiksPris;
			}
		}
		//produktet lever ikke op til en af kategorierne
		return -1;
	}
	
	
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public String getProduktnavn() {
		return produktnavn;
	}
	public void setProduktnavn(String produktnavn) {
		this.produktnavn = produktnavn;
	}
	public double getMængde() {
		return mængde;
	}
	public void setMængde(double mængde) {
		this.mængde = mængde;
	}
	public double getFredagsPris() {
		return fredagsbarPris;
	}
	public void setFredagsPris(double fredagsPris) {
		this.fredagsbarPris = fredagsPris;
	}
	public double getButiksPris() {
		return butiksPris;
	}
	public void setButiksPris(double butiksPris) {
		this.butiksPris = butiksPris;
	}
	public double getØlstørrelse() {
		return ølstørrelse;
	}
	public void setØlstørrelse(double ølstørrelse) {
		this.ølstørrelse = ølstørrelse;
	}
	public double getPant() {
		return pant;
	}
	public void setPant(double pant) {
		this.pant = pant;
	}
	public String getPakkeindhold() {
		return pakkeindhold;
	}
	public void setPakkeindhold(String pakkeindhold) {
		this.pakkeindhold = pakkeindhold;
	}
	
	
	
}
