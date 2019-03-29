import java.util.Scanner;


/**
 * Classe principale lançant le jeu
 */
public class Principale {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int id;
		String txt = "";
		int itxt = 0;
		// Nouvelle ou reprise de partie ?
		Scanner sc = new Scanner(System.in);
		System.out.print("Nouvelle partie ? (Oui ou Non)");
		txt = sc.next().toUpperCase();
		while (!(txt.equals("YES") || txt.equals("OUI") || txt.equals("Y") || txt.equals("NO") || txt.equals("NON")
				|| txt.equals("N")))
			txt = sc.next().toUpperCase();

		// Nouvelle partie
		if (txt.equals("YES") || !txt.equals("OUI") || !txt.equals("Y")) {
			System.out.println("Choisissez votre mode de jeu : " + " 1) Mono-joueur");

			// Type de partie
			while (itxt != 1)
				itxt = sc.nextInt();
			sc.close();
			System.out.println("Touchée coulé en mono-joueur"
					+ "Le joueur place ces bateaux et doit détruir les détruir pour gagner");
			id = 1;

			Partie game = new PartieMono();
			game.lancerParie();
		}

	}
}
