package nyArkitektur;

import controller.Controller;

public class TestRegistrerSalg {

	public static void main(String[] args) {

		//Salgssituation: procentvisRabat & aftaltPris
		Salgssituation situation = new Salgssituation();
		situation.setProcentviseRabat(20);
		
		//Produkter
		Produkt flaske = Controller.createFlaske("flaske", "ale", 50, 36);		
		Produkt fadøl = Controller.createFadøl("flaske", "ale", 40, 30);		
		Produkt spiritus = Controller.createSpiritus("spiritus", "Spirit of Aarhus", 300, 300);

		//Betalingsform
		Betalingsform b = new Betalingsform();
		Betalingsform d = new Dankort();
		b.setBetalingsform(d);
		
		//Salg
		Salg s = Controller.createSalg(situation, b);
		
		//Tilføj Produkter til Salg
		s.setSalgssituation(situation);

		s.addProdukt(flaske);
		s.addProdukt(fadøl);
		s.addProdukt(spiritus);
		
		s.beregnSamletPris();
		
		//Testen viser fejl, da den regner fadøl med. I controlleren 
		System.out.println(s.getSamletPris());
		
	
	}
}
