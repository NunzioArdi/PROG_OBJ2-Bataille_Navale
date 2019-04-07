import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Exceptions.CoordoneeException;
import Exceptions.DirectionException;

/**
 * Classe représentant une grille de combat. Une grille est composé de Cases.
 */
public class Grille implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2200767690615613920L;
	/**
	 * La liste des Cases composant la Grille.
	 */
	private List<Case> list;
	/**
	 * La largeur de la Grille.
	 */
	private int longueur;
	/**
	 * La hauteur de la Grille.
	 */
	private int largeur;

	/**
	 * Constructeur de la grille. Une grille est composée d'une liste de Cases. Elle
	 * a une limite de taille minimum et maximum.
	 * 
	 * @param lon longueur
	 * @param lar la largeur
	 * @throws CoordoneeException Cette Exception est levée si les valeurs de la
	 *                            taille de Grille sont inférieurs au MIN ou
	 *                            supérieurs au MAX
	 */
	public Grille(int lon, int lar) throws CoordoneeException {
		// Vérification des paramètres
		if (lon < 10) {
			throw new CoordoneeException("longeur inférieur à 10 cases");
		} else if (lon > 50) {
			throw new CoordoneeException("longeur supérieur à 50 cases");
		} else if (lar < 10) {
			throw new CoordoneeException("largeur inférieur à 10 cases");
		} else if (lar > 50) {
			throw new CoordoneeException("largeur ssupérieur à 50 cases");
		}

		this.longueur = lon;
		this.largeur = lar;

		// Construction de la liste
		this.list = new ArrayList<Case>();
		for (int i = 0; i < this.largeur; i++) {
			for (int j = 0; j < this.longueur; j++) {
				this.list.add(new Case(i, j));
			}
		}
	}

	/**
	 * Méthode donnant l'index de la liste de Case de la Grille.
	 * 
	 * @param x absisse
	 * @param y ordonnée
	 * @return l'index de la liste des Cases.
	 */
	public Case getCase(int x, int y) {
		int index = list.indexOf(new Case(x, y));
		return list.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Case tmp = null;
		String s = "";
		for (int i = 0; i < this.longueur; i++) {
			for (int j = 0; j < this.largeur; j++) {
				tmp = getCase(j, i);
				s = s + tmp.toString() + " ";
			}
			s = s + "\n";
		}
		return s;
	}

	/**
	 * Méthode ajoutant un Bateau aux Cases de la Grille.
	 * 
	 * @param b   le bateau à ajouter
	 * @param x   l'abscisse de la position
	 * @param y   l'ordonnée de la position
	 * @param dir la direction du bateau (0=horizontal/1=verticale)
	 * @throws CoordoneeException Cette Exception est levée si les paramètres de coordonnées
	 *                            donnés dépassent la taille maximum MAX ou la taille minimum MIN de la Grille, si
	 *                            les coordonnées font dépasser le Bateau de Grille,
	 *                            si un Bateau se trouve déjà aux coordonnées indiquées
	 * @throws DirectionException Cette Exception est levée quand le paramètre de
	 *                            direction donné n'est pas ce qui est attendu
	 */
	public void addBateau(Bateau b, int x, int y, int dir) throws CoordoneeException, DirectionException {
		// Vérificaton des paramètres
		if (x < 0)
			throw new CoordoneeException("position x inférieur à 0");
		else if (x >= this.longueur)
			throw new CoordoneeException("position x dépasse la taille de la grille");
		else if (y < 0)
			throw new CoordoneeException("position y inférieur à 0");
		else if (y >= this.largeur)
			throw new CoordoneeException("position y dépasse la taille de la grille");
		if (!(dir == 0 || dir == 1))
			throw new DirectionException("Mauvais paramère de direction");

		// Placement
		for (int i = 0; i < b.getTaille(); i++) {
			// Vérification dépassement
			if (x >= this.longueur)
				throw new CoordoneeException("le bateau dépasse la grille en x");
			else if (y >= this.largeur)
				throw new CoordoneeException("le bateau dépasse la grille en y");

			Case tmp = new Case(x, y);
			int index = this.list.indexOf(tmp);

			// Vérification place libre
			if (list.get(index).getBat() != null) {
				throw new CoordoneeException("Un bateau est déjà sur la case" + x + " " + y);
			}

			tmp.setBat(b);
			list.set(index, tmp);
			if (dir == 1)
				y++;
			else
				x++;
		}
	}

	/**
	 * Méthode qui met à jour une Case.
	 * 
	 * @param x   absisse
	 * @param y   ordonee
	 * @param tmp la nouvelle Case
	 */
	public void setCase(int x, int y, Case tmp) {
		int i = this.list.indexOf(new Case(x, y));
		this.list.set(i, tmp);
	}

}