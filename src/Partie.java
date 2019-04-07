import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exceptions.BateauException;
import exceptions.CoordoneeException;
import exceptions.DirectionException;

/**
 * Classe abstraite donnant le modèle pour créer les différents modes de jeu.
 */
public abstract class Partie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4406769469769370072L;

	/**
	 * Attribut de la longueur de la grille.
	 */
	protected int x;

	/**
	 * Attribut de la largeur de la grille.
	 */
	protected int y;

	/**
	 * La liste des Bateaux que chaque joueur peut avoir
	 */
	protected List<Bateau> bateaux;

	/**
	 * Constructeur de la partie. Initialise la liste des modèles de bateaux.
	 * 
	 * @throws BateauException
	 */
	public Partie() throws BateauException {
		bateaux = new ArrayList<Bateau>();
		list();
	}

	/**
	 * Méthode interne servant à remplir le modèle de la liste des bateaux que les
	 * joueurs peuvent avoir.
	 * 
	 * @throws BateauException
	 */
	private void list() throws BateauException {
		bateaux.add(new Bateau("Porte-avions", 5));
		bateaux.add(new Bateau("Cuirassé ", 4));
		bateaux.add(new Bateau("Croiseur", 3));
		bateaux.add(new Bateau("Sous-marin", 3));
		bateaux.add(new Bateau("Destroyer", 2));
	}

	/**
	 * Méthode servant à ajouter au joueur choisi les bateaux aux coordonées voulues
	 * par celui-ci.<br>
	 * Des exceptions sont levées et ratrapppées tant que la direction et/ou les
	 * coordonées indiquées seront invalides.
	 * 
	 * @param j Le joueur
	 * @throws BateauException
	 */
	protected void addBateauxJoueur(Joueur j) throws BateauException {
		int i = 0;

		while (i < this.bateaux.size()) {
			System.out.println("Donner la direction du bateau: \n\tHorizontale=0\n\tVerticale=1");

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
				System.out.println(e);
			} catch (DirectionException e) {
				System.out.println(e);
			} catch (InputMismatchException e) {
				System.out.println(e + ": Un nombre est attendu\n");
			}

			System.out.println(j.getBateau().toString());
		}

	}

	/**
	 * Méthode définisant la taille de la grille du jeu.
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
		System.out.print("Donner votre pseudo : ");
		String tmp = sc.next();
		return tmp;
	}

	/**
	 * Donne la liste des Bateaux du joueur avec sa taille ou sa vie.
	 * 
	 * @param j    le joueur
	 * @param type 1=vie, sinon taille
	 * @return une chaine de caractères formatée avec le nom du bateau et sa vie ou
	 *         sa taille
	 */
	public String AfficherListeBateau(Joueur j, int type) {
		String res = "";
		if (type == 1) {
			for (int i = 0; i < j.getListBateau().size(); i++) {
				res = res + "-" + j.getListBateau().get(i).getNom() + ": " + j.getListBateau().get(i).getVie()
						+ "% de vie\n";
			}

		} else {
			for (int i = 0; i < j.getListBateau().size(); i++) {
				res = res + "-" + j.getListBateau().get(i).getNom() + " " + j.getListBateau().get(i).getTaille() + "\n";
			}

		}
		return res;
	}

	/**
	 * Méthode lancant la partie. Elle est déjà initialisée.
	 */
	public abstract void lancerParie();

	/**
	 * Méthode initialisant une nouvelle partie.
	 * 
	 * @throws BateauException
	 */
	public abstract void initialiserPartie() throws BateauException;

	/**
	 * Méthode servant à restaurer les données d'une partie sauvegardée.
	 * 
	 * @param locate la position du fichier de sauvegarde
	 */
	public abstract void restaurerPartie(String locate);

	/**
	 * Méthode servant à sauvegarder les données de la partie en cours.
	 * 
	 * @param locate la position du fichier de sauvegarde
	 */
	protected abstract void sauvegerderPartie(String locate);

}
