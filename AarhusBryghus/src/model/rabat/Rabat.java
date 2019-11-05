package model.rabat;

public class Rabat {

	private Rabat rabat;
	
	public Rabat() {
	}
	
	//TODO Strategy pattern i superklassen Rabat anvendes ikke rigtigt. Enten benytter vi os af strategy-pattern eller polymorfi
	public void setRabat(Rabat rabat) {
		this.rabat = rabat;
	}
	
	public double tildelRabat(double pris) {
		return rabat.tildelRabat(pris);
	}
	
	
}
