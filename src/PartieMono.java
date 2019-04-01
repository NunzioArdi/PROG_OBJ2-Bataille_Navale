import java.util.Scanner;

/**
 * Classe Représentant le type de Partie en mono-joueur.
 *
 */
@SuppressWarnings({ "serial", "unused" })
public class PartieMono extends Partie {

	/**
	 * Attribut reliant le joueur à la partie(sauvegarde)
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
		// Initialisation
		this.setTailleGrille();
		String pseudo = this.getPseudo();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		this.player = new Joueur(x, y);
		this.player.setPseudo(pseudo);
		this.addBateauxJoueur(this.player);

		// Démarage partie
		System.out.println("Le jeu commence");
		while (player.isLife()) {
			@SuppressWarnings("resource")
			Scanner sc1 = new Scanner(System.in);
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
