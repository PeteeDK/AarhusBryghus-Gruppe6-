package model.betalingsform;

public class Kontant extends Betalingsform {

	@Override
	public String registrerBetaling() {
		return "Betalt med kontant";
	}
	
}
