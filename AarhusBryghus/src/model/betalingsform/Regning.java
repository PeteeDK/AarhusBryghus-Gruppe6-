package model.betalingsform;

public class Regning implements IBetalingsform {

	@Override
	public String registrerBetaling() {
		return "Betalt med regning";
	}
	
}
