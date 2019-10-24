package model;

import model.betalingsform.Betalingsform;

public class Kontant extends Betalingsform {

	@Override
	public String registrerBetaling() {
		return "Betalt med kontant";
	}

}
