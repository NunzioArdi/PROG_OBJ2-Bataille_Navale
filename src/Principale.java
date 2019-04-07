import java.util.Scanner;

import exceptions.BateauException;

/**
 * Classe principale lançant le jeu
 */
public class Principale {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws BateauException {

		int id = 0;
		String txt = "";
		Scanner sc = new Scanner(System.in);

		while (id != 1) {
			//Les autres modes de jeu ne sont pas implémentés mais le Main est adapté pour les ajouter
			System.out.println("Choisissez votre mode de jeu : " + "\n\t1) Mono-joueur");
			try {
				id = Integer.parseInt(sc.next()); 
				if (id != 1)
					System.out.println("Mauvais paramètre");
			} catch (NumberFormatException e) {
				System.out.println(e + ": Un chiffre est attendu\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.print("Nouvelle partie (Oui ou Non) ?");
		while (!(txt.equals("OUI") || txt.equals("NON"))) {
			txt = sc.next().toUpperCase();
		}
		
		if (txt.equals("OUI")) {
			if (id == 1) {
				System.out.println("Dans ce mode de jeu, le joueur place ces bateaux et doit les détruir pour gagner");
				Partie game = new PartieMono();
				game.initialiserPartie();
				game.lancerParie();
			}
		} else {
			if (id == 1) {
				Partie game = new PartieMono();
				System.out.println("Selectionner le fichier de sauvegarde correcpondant au mode de jeu choisis");
				String locate = sc.next();
				game.restaurerPartie(locate);
				game.lancerParie();
			}
		}
	}
}

//javadoc */.java -d ../doc -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 -html5