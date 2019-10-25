package model.betalingsform;

public class Betalingsform implements IBetalingsform {

	private IBetalingsform betalingsform;
	
	public Betalingsform() {
	}
	
	public void setBetalingsform(IBetalingsform betalingsform) {
		this.betalingsform = betalingsform;
	}
	
	public String registrerBetaling() {
		return betalingsform.registrerBetaling();
	}
	
} 
