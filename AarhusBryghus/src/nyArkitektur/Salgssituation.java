package nyArkitektur;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class Salgssituation {

	private double aftaltPris;
	private int procentviseRabat;
	private String kunde;
	private LocalDate dato;
	private static boolean fredagsbarMode;
	
	public Salgssituation() {
		dato = LocalDate.now();
		fredagsbarModeAuto();		//TODO hvordan kan systemet selv holde øje med at det skifter fra torsdag til fredag
	}
	
	

	private void fredagsbarModeAuto() {
		if(dato.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
			fredagsbarMode = true;
		}else{
			fredagsbarMode = false;
		}
	}
	
	public void setFredagsbarMode(boolean fredagsbarMode) {
		this.fredagsbarMode = fredagsbarMode;
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

	//TODO Dette hack gør det muligt for subklasserne under Produkt at tilgå isFredagsbarMode uden en
	//association. Vi ser om vi løber ind i problemer eller om Peter vender tomlen nedad
	public static boolean isFredagsbarMode() {
		return fredagsbarMode;
	}

	
}
