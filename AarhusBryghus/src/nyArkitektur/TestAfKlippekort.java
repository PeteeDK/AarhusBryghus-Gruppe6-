package nyArkitektur;

public class TestAfKlippekort {

	public static void main(String[] args) {

		//Rolle 1: Produkt
		Produkt k = new Klippekort("klippekort", "", 100, 100);
		
		Salgssituation ss1 = new Salgssituation();
		
		//Rolle 2: Betalingsform
		IBetalingsform b = (IBetalingsform)k;
		
		Salg s = new Salg(ss1,b);
		
		s.addProdukt(k);
		
		System.out.println(s.beregnSamletPris());
		
		System.out.println(s.getBetalingsform().registrerBetaling());
		System.out.println(s.getBetalingsform().registrerBetaling());
		System.out.println(s.getBetalingsform().registrerBetaling());
		System.out.println(s.getBetalingsform().registrerBetaling());
		System.out.println(s.getBetalingsform().registrerBetaling());

		//Test at IBetalingsform også virker på de andre subklasser for IBetalingsform
		
		IBetalingsform b2 = new Dankort();
		
		Salg s2 = new Salg(ss1,b2);
		
		System.out.println(s2.getBetalingsform().registrerBetaling());
		
		
		
	}

}
