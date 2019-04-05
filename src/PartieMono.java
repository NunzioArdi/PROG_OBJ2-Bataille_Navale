import java.util.Scanner;

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

		// Tant que coordonée incorrecte
		while (!stop) {
			try {
				this.setTailleGrille();
				this.player = new Joueur(x, y);
				stop = true;
			} catch (CoordoneeException e) {
				e.printStackTrace();
			}
		}

		// Initialisation
		String pseudo = this.getPseudo();
		this.player.setPseudo(pseudo);
		this.addBateauxJoueur(this.player);

		// Démarage partie
		System.out.println("Le jeu commence");
		while (player.isLife()) {
			@SuppressWarnings("resource")
			Scanner sc1 = new Scanner(System.in);

			int action = -1;
			while (action != 0 && action != 1) {
				System.out.println("Choisiser une action:\n" + "\t1) Continuer a jouer\n" + "\t2) Sauvegarder");
				action = sc1.nextInt();
			}

			System.out.println("Choisiser les coordonné du missile");
			int posX = sc.nextInt();
			int posY = sc.nextInt();
			boolean attaque = player.attack(posX, posY);
			System.out.println();
			System.out.println(player.getTire().toString());
			player.getVieListBateau();
			System.out.println(player.getVie());
		}

		System.out.println("Gagner");
	}
}