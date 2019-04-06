import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.CoordoneeException;

/**
 * Classe représentant une Partie en mono-joueur.
 */
@SuppressWarnings({ "serial", "unused" })
public class PartieMono extends Partie {

	/**
	 * Le joueur de la partie.
	 */
	private Joueur player;

	/**
	 * @see Partie#Partie()
	 */
	public PartieMono() {
		super();
	}

	@Override
	public void lancerParie() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		String pseudo = this.getPseudo();
		
		// Tant que coordonée incorrecte
		while (!stop) {
			try {
				this.setTailleGrille();
				this.player = new Joueur(x, y, pseudo);
				stop = true;
			} catch (CoordoneeException e) {
				e.printStackTrace();
			}
		}

		// Initialisation
		this.addBateauxJoueur(this.player);

		// Démarage partie
		System.out.println("Le jeu commence");
		while (player.isLife()) {
			@SuppressWarnings("resource")
			Scanner sc1 = new Scanner(System.in);

			int action = -1;
			while (action != 0 && action != 1 && action != 2 && action != 3 && action != 4) {
				System.out.println("Choisiser une action:\n" 
						+ "\t1) Continuer à jouer\n" 
						+ "\t2) Sauvegarder"
						+ "\t3) Afficher la vie Bateau"
						+ "\t3) Affiche la taille des bateaux");
				try {
					action = sc1.nextInt();
				}catch (InputMismatchException e) {
					System.out.println(e + ": Un nombre est attendu\n");
				}
			}
			
			if(action==1) {
				System.out.println("Choisiser les coordonné du missile");
				int posX = sc.nextInt();
				int posY = sc.nextInt();
				try {
					player.attack(posX, posY);
				} catch (CoordoneeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println(player.getTire().toString());
			}
			else if (action==2) {
				
			}
			else if(action==3) {
				player.triListeBateauVie();
				System.out.println(AfficherListeBateau(player,1));
			}
			else {
				player.triListeBateauTaille();
				System.out.println(AfficherListeBateau(player,2));
			}

			
		}

		System.out.println("Gagner");
	}
}