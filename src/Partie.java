import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Exceptions.CoordoneeException;
import Exceptions.DirectionException;

/**
 * Classe abstraite donnant le modèle pour créer les différent mode de jeu.
 */
@SuppressWarnings("serial")
public abstract class Partie implements Serializable {
	/**
	 * Attribut de la longueur de la grille
	 */
	protected int x;

	/**
	 * Attribut de la largeur de la grille
	 */
	protected int y;

	/**
	 * La liste des Bateaux que chaque joueur peux avoir
	 */
	protected List<Bateau> bateaux;

	/**
	 * Constructeur de la partie. Initialise la liste des modèle de bateaux.
	 */
	public Partie() {
		bateaux = new ArrayList<Bateau>();
		list();
	}

	/**
	 * Méthode interne servant à remplir le modèle de la liste des bateaux que les
	 * joueurs peuvent avoir.
	 */
	private void list() {
		bateaux.add(new Bateau("Porte-avions", 5));
		bateaux.add(new Bateau("Cuirassé ", 4));
		bateaux.add(new Bateau("Croiseur", 3));
		bateaux.add(new Bateau("Sous-marin", 3));
		bateaux.add(new Bateau("Destroyer", 2));
	}

	/**
	 * Méthode servant à ajouter au joueur désirer les bateaux aux coordonées
	 * voulues par celui-ci.<br>
	 * Des exceptions sont levées et ratrapppées tant que la direction et/ou les
	 * coordonées indiquées seront invalides.
	 * 
	 * @param j Le joueur
	 */
	protected void addBateauxJoueur(Joueur j) {
		int i = 0;

		while (i < this.bateaux.size()) {
			System.out.println("Donner la direction du bateau: \n \tHorizontal=0\n\tVertical=1");

			try {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int dir = sc.nextInt();
				System.out.print("Donner la position du bateau\nx=");
				x = sc.nextInt();
				System.out.print("Donner la position du bateau\ny=");
				y = sc.nextInt();
				j.addBatt(bateaux.get(i), x, y, dir);
				i++;
			} catch (CoordoneeException e) {
				e.printStackTrace();
			} catch (DirectionException e) {
				e.printStackTrace();
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Un nombre est attendu\n");
			}

			System.out.println(j.getBateau().toString());
		}

	}

	/**
	 * Méthode définisant la taille de la grille de jeu.
	 */
	protected void setTailleGrille() {
		boolean stop = false;
		while (!stop) {
			try {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.print("Donner la taille de la grille (x et y): ");
				x = sc.nextInt();
				y = sc.nextInt();
				stop = true;
			} catch (InputMismatchException e) {
				System.out.println(e + ": Un nombre est attendu\n");
			}
		}
	}

	/**
	 * Méthode définisant le pseudo d'un Joueur.
	 */
	protected String getPseudo() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Donné votre pseudo : ");
		String tmp = sc.next();
		return tmp;
	}

	/**
	 * Méthode lancant la partie.
	 */
	public abstract void lancerParie();

}
