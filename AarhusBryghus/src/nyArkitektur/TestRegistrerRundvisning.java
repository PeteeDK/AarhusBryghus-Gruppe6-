package nyArkitektur;

import java.time.LocalDate;
import java.time.LocalTime;

import controller.Controller;

public class TestRegistrerRundvisning {

	public static void main(String[] args) {

		Kunde k1 = new Kunde("Bo",true);
		Kunde k2 = new Kunde("Lars",false);
		
		//String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt, double aftenPris,
		//double dagsPris, double studierabat
		Rundvisning r1 = new Rundvisning("Rundvisnig","Rundvining 1", LocalDate.now(), LocalTime.of(12, 00), 100, 80, 0.9);
		 
		r1.addKunde(k1);
		r1.addKunde(k2);
		
		System.out.println(r1.getPris());
		
		r1.setBetalt(true, LocalDate.now().plusDays(1));
		
		r1.beregnPris();
		
		System.out.println(r1.getPris());

		System.out.println(r1.toString());
		
		r1.setBetalt(false, LocalDate.now());
		 
		System.out.println(r1.getPris());
		
		System.out.println(r1.toString());
	}

}
