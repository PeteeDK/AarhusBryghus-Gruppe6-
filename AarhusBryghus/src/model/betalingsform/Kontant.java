package model.betalingsform;

public class Kontant implements IBetalingsform {

	@Override
	public String registrerBetaling() {
		return "Betalt med kontant";
	}
	
}
