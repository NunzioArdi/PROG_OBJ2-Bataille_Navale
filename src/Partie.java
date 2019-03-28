import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe donnant le modèle pour les différent mode de jeu
 */
public abstract class Partie implements Serializable {
	/**
	 * Attribut de la longueur de la grille
	 */
	protected int x;

	/**
	 * Attribut de la largeur de la grille
	 */
	protected int y;

	protected List<Bateau> bateaux;

	
	/**
	 * Constructeur initialisant la liste des modèle de bateaux.
	 */
	public Partie() {
		bateaux = new ArrayList<Bateau>();
		list();
	}

	/**
	 * Méthode interne servant à initialisé le modèle de la liste des bateaux que les
	 * joueurs peuvent avoir.
	 */
	private void list() {
		bateaux.add(new Bateau("Porte-avions", 5));
		bateaux.add(new Bateau("Cuirassé ", 4));
		bateaux.add(new Bateau("Croiseur", 3));
		bateaux.add(new Bateau("Sous-marin", 3));
		bateaux.add(new Bateau("Destroyer ", 2));
	}

	/**
	 * Méthode servant à ajouter au joueur désirer les bateaux au coordonée voulu
	 * par celui-ci.<br>
	 * Des éxceptions sont levées tant que la direction et/ou les coordonées indiqué seront
	 * invalide.
	 * 
	 * @param j Le joueur
	 */
	protected void addBateauxJoueur(Joueur j) {
		int i = 0;

		while (i < this.bateaux.size()) {
			boolean dir = false;
			System.out.println("Donner la direction du bateau: \n \tHorizontal=0\n\tVertical=1");
			Scanner sc = new Scanner(System.in);
			int tmp = sc.nextInt();
			if (tmp == 1)
				dir = true;
			
			System.out.print("Donner la position du bateau\nx=");
			x = sc.nextInt();
			System.out.print("Donner la position du bateau\ny=");
			y = sc.nextInt();
			sc.close();
			
			j.addBatt(bateaux.get(i), x, y, dir);
			i++;
		}

	}

	/**
	 * Méthode définisant la taille de la grille de jeu.<br>
	 * Une éxception est levée tant que la taille de la grille sera invalide.
	 */
	protected void setTailleGrille() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Donner la taille de la grille (x et y): ");
		x = sc.nextInt();
		y = sc.nextInt();
		sc.close();
	}

	/**
	 * Méthode définisant le nom d'un ou plusieur joueur.
	 */
	protected abstract void getPseudo();

	/**
	 * Méthode qui lance la partie
	 */
	public abstract void lancerParie();

}
