package nyArkitektur;

import java.time.LocalDate;
import java.util.Calendar;

public class Salgssituation {

	private double aftaltPris;
	private int procentviseRabat;
	private String kunde;
	private LocalDate dato;
	
	public Salgssituation() {
		this.dato = LocalDate.now();
	}

	
	

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public double getAftaltPris() {
		return aftaltPris;
	}

	public void setAftaltPris(double aftaltPris) {
		this.aftaltPris = aftaltPris;
	}

	public int getProcentviseRabat() {
		return procentviseRabat;
	}

	public void setProcentviseRabat(int procentviseRabat) {
		this.procentviseRabat = procentviseRabat;
	}

	public String getKunde() {
		return kunde;
	}

	public void setKunde(String kunde) {
		this.kunde = kunde;
	}

	//	public void method() {
//
//		LocalDate today = this.dato.now();
//		
//		today.getDayOfWeek().equals(Calendar.FRIDAY);
//		
//	}
	
}
