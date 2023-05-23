package tests;

public class TestDamage extends TestBase
{
	/**
	 * 8.2.1
	 * A szabotőr lyukasztással próbálkozik a pipe1-n állva.
	 */
	public static void TestDamages()
	{
		System.out.println("\nDamages Test");

		saboteur.SetCurrentPosition(pipe1);
		pipe1.AcceptPlayer(saboteur);
		System.out.println("Lyukas-e a " + pipe1.GetId() + "?");
		System.out.println("Hamis értéket várunk");
		System.out.println(pipe1.GetLeaking()? "Igaz" : "Hamis");
		saboteur.Damage();
		
		System.out.println("Lyukasztás után lyukas-e a " + pipe1.GetId() + "?");
		System.out.println("Igaz értéket várunk");
		System.out.println(pipe1.GetLeaking()? "Igaz" : "Hamis");
		
		System.out.println("Lyukas-e a " + pipe2.GetId() + "?");
		System.out.println("Hamis értéket várunk");
		System.out.println(pipe2.GetLeaking()? "Igaz" : "Hamis");
		
		mechanic.SetCurrentPosition(pipe2);
		pipe2.AcceptPlayer(mechanic);
		mechanic.Damage();
		System.out.println("Átmozgatás és lyukasztás után, lyukas-e a " + pipe2.GetId() + "?");
		System.out.println("Igaz értéket várunk");
		System.out.println(pipe2.GetLeaking()? "Igaz" : "Hamis");
		
		saboteur.SetCurrentPosition(pump);
		pump.AcceptPlayer(saboteur);
		saboteur.Damage();
		System.out.println("A szabotőr áthelyezése a pumpára. Majd a pumpa rongálásának próbája:\nElronthatja-e a szabotőr a pumpát?");
		System.out.println(pump.TryDamage()? "Igen" : "Nem");
	}
}
