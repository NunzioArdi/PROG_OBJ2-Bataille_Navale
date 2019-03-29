import java.util.Scanner;


/**
 * Classe Représentant le type de Partie en mono-joueur.
 *
 */
@SuppressWarnings({"serial", "unused"})
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
		//Initialisation
		this.setTailleGrille();
		String pseudo = this.getPseudo();
		Scanner sc = new Scanner(System.in);
		this.player = new Joueur(x, y);
		this.player.setPseudo(pseudo);
		this.addBateauxJoueur(this.player);
		sc.close();
		
		//Démarage partie
		System.out.println("Le jeu commence");
		while(player.isLife()) {
			Scanner sc1 = new Scanner(System.in);
				System.out.println("Choisiser les coordonné du missile");
				int posX = sc.nextInt();
				int posY = sc.nextInt();
				player.attack(posX, posY);
			
			
			
			sc1.close();
		}
		
		System.out.println("Bienvenue ");
		sc.close();
	}

}
