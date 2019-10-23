package nyArkitektur;

import java.time.DayOfWeek;
import java.util.ArrayList;


public class Anlæg extends Produkt {

	private boolean afleveret;
	private double brugtFustagemængde;
	private double brugtKulsyremængde;
	private ArrayList<Produkt> tilbehør = new ArrayList<>();
	private double pris;
	private String status;
	
	public Anlæg(String kategori, String produktNavn, boolean afleveret, double brugtFustagemængde,
			double brugtKulsyremængde, double anlægsPris) {
		super(kategori, produktNavn);
		this.afleveret = afleveret;
		this.brugtFustagemængde = brugtFustagemængde;
		this.brugtKulsyremængde = brugtKulsyremængde;
		this.pris = anlægsPris;
		status = "anlæg er udlejet";
	}

	public double beregnPris() {
		if(afleveret) {
			for(Produkt p : tilbehør) {
				if(p.getKategori().equals("fustage")) {
					pris += brugtFustagemængde * ((Fustage)p).getPrisPrLiter();
					System.out.println("[Anlæg] anlæg + fustage:" + pris);
				}else if(p.getKategori().equals("kulsyre")) {
					pris += brugtKulsyremængde * ((Kulsyre)p).getPrisPrKg();
					System.out.println("[Anlæg] anlæg + fustage + kulsyre (total):" + pris);
				}
			}
		}else{
			pris = 0;
		}
		return pris;
	}
	
	//beregnPris() "oversættes" til getPris() for at kunne anvende "getPris()" ensartet i Salg
	public double getPris() {
		return beregnPris();
	} 
	
	public boolean isAfleveret() {
		return afleveret;
	}
	public void setAfleveret(boolean afleveret) {
		this.afleveret = afleveret;
	}
	public double getBrugtFustagemængde() {
		return brugtFustagemængde;
	}
	public void setBrugtFustagemængde(double brugtFustagemængde) {
		this.brugtFustagemængde = brugtFustagemængde;
	}
	public double getBrugtKulsyremængde() {
		return brugtKulsyremængde;
	}
	public void setBrugtKulsyremængde(double brugtKulsyremængde) {
		this.brugtKulsyremængde = brugtKulsyremængde;
	}
	
	public void addProdukt(Produkt p) {
		tilbehør.add(p);
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public String getStatus() {
		if(afleveret) {
			status = "anlæg er afleveret";
		}
		return status;
	}

	@Override
	public String toString() {
		return "Anlæg [afleveret=" + afleveret + ", brugtFustagemængde=" + brugtFustagemængde + ", brugtKulsyremængde="
				+ brugtKulsyremængde + ", tilbehør=" + tilbehør + ", pris=" + pris + ", status=" + status + "]";
	}
		
	
}
