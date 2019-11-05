package model.rabat;

/**
 * Klassen AftalsPrisRabat dækker over en rabat-type, hvor man kan angive det beløb, der skal trækkes fra den samlede
 * pris af produktlinjerne i objekter af klassen Salg. Dog kan den samlede pris ikke være højere end det fratrukkede beløb
 * @author Erik Kato Ipsen
 *
 */
public class AftaltPrisRabat extends Rabat {

	private double fratrukketPris;
	 
	public AftaltPrisRabat(double fratrukketPris) {
		this.fratrukketPris = fratrukketPris; 
	}
	
	@Override 
	public double tildelRabat(double pris) {
		if(pris < fratrukketPris) {
			throw new IllegalArgumentException("Fratrukket pris kan ikke overstige prisen på bestillingen. Sæt et mindre beløb, der skal trækkes fra.");
		}
		return pris - fratrukketPris;
	}
 
	
	public double getFratrukketPris() {
		return fratrukketPris;
	}

	public void setFratrukketPris(double fratrukketPris) {
		this.fratrukketPris = fratrukketPris;
	} 
	
}
