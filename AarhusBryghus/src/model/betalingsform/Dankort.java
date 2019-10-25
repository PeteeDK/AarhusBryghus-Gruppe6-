package model.betalingsform;

public class Dankort extends Betalingsform {

	@Override
	public String registrerBetaling() {
		return "Betalt med dankort";
	}
	
}
