package model.betalingsform;

public class Regning extends Betalingsform {

	@Override
	public String registrerBetaling() {
		return "Betalt med regning";
	}
	
}
