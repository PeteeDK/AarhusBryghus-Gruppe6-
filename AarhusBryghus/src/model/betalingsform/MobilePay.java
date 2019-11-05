package model.betalingsform;

public class MobilePay implements IBetalingsform {

	@Override
	public String registrerBetaling() {
		return "Betalt med MobilePay";
	}
	
}
