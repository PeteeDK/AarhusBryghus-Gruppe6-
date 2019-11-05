package model.betalingsform;

public class Dankort implements IBetalingsform {

	@Override
	public String registrerBetaling() {
		return "Betalt med dankort";
	}
	
}
