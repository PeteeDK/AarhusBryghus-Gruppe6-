package nyArkitektur;

public class Betalingsform {

	private Betalingsform betalingsform;
	
	public Betalingsform() {
	}
	
	public void setBetalingsform(Betalingsform betalingsform) {
		this.betalingsform = betalingsform;
	}
	
	public String registrerBetaling() {
		return betalingsform.registrerBetaling();
	}
	
}
