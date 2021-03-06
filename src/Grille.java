import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exceptions.BateauException;
import exceptions.CaseException;
import exceptions.CoordoneeException;
import exceptions.DirectionException;

/**
 * Classe représentant une grille de combat. Une grille est composée de Cases.
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
	 * Valeur arbitraire fixant la taille maximale de la grille
	 */
	private final int MAX = 50;
	/**
	 * Valeur arbitraire fixant la taille minimale de la grille
	 */
	private final int MIN = 10;

	/**
	 * Constructeur de la grille. Une grille est composée d'une liste de Cases. Elle
	 * a une limite de taille minimum et maximum.
	 * 
	 * @param lon la longueur
	 * @param lar la largeur
	 * @throws CoordoneeException Cette Exception est levée si les valeurs de la
	 *                            taille de Grille sont inférieurs au MIN ou
	 *                            supérieurs au MAX
	 */
	public Grille(int lon, int lar) throws CoordoneeException {
		// Vérification des paramètres
		if (lon < MIN) {
			throw new CoordoneeException("longeur inférieur à " + MIN + " cases");
		} else if (lon > MAX) {
			throw new CoordoneeException("longeur supérieur à " + MAX + " cases");
		} else if (lar < MIN) {
			throw new CoordoneeException("largeur inférieur à " + MIN + " cases");
		} else if (lar > MAX) {
			throw new CoordoneeException("largeur supérieur à " + MAX + " cases");
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
	 * Méthode donnant l'index d'une Case de la liste de Cases.
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
	 * @param dir la direction du bateau (0=horizontale/1=verticale)
	 * @throws CoordoneeException Cette Exception est levée si les paramètres de
	 *                            coordonnées donnés dépassent la taille maximum MAX
	 *                            ou la taille minimum MIN de la Grille, si les
	 *                            coordonnées font dépasser le Bateau de Grille, si
	 *                            un Bateau se trouve déjà aux coordonnées indiquées
	 * @throws DirectionException Cette Exception est levée quand le paramètre de
	 *                            direction donné n'est pas ce qui est attendu
	 */
	public void addBateau(Bateau b, int x, int y, int dir)
			throws CoordoneeException, DirectionException, BateauException {
		if (b == null) {
			throw new BateauException("Ajout d'un Bateau NULL");
		} else if (b.estMort()) {
			throw new BateauException("Ajout d'un Bateau mort");
		}
		// Vérificaton des paramètres
		if (x < 0)
			throw new CoordoneeException("position x inférieur à 0");
		if (x >= this.longueur)
			throw new CoordoneeException("position x dépasse la taille de la grille");
		if (y < 0)
			throw new CoordoneeException("position y inférieur à 0");
		if (y >= this.largeur)
			throw new CoordoneeException("position y dépasse la taille de la grille");
		if (!(dir == 0 || dir == 1))
			throw new DirectionException("Mauvais paramètre de direction");

		// Vérification de la place libre sur toute la place que prend le bateau
		int tmpX = x;
		int tmpY = y;
		for (int i = 0; i < b.getTaille(); i++) {
			// Vérification dépassement
			if (tmpX >= this.longueur)
				throw new CoordoneeException("le bateau dépasse la grille en x");
			if (tmpY >= this.largeur)
				throw new CoordoneeException("le bateau dépasse la grille en y");

			// Vérification place libre
			Case tmp = new Case(tmpY, tmpY);
			int index = this.list.indexOf(tmp);
			if (list.get(index).getBat() != null) {
				throw new CoordoneeException("Un bateau est déjà sur la case " + tmpX + " " + tmpY);
			}
			if (dir == 1)
				tmpY++;
			else
				tmpX++;
		}

		// Placement
		for (int i = 0; i < b.getTaille(); i++) {
			Case tmp = new Case(x, y);
			int index = this.list.indexOf(tmp);

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
	 * @param y   ordonée
	 * @param c la nouvelle Case
	 * @throws CoordoneeException
	 * @throws CaseException
	 */
	public void setCase(int x, int y, Case c) throws CoordoneeException, CaseException {
		if (x < 0)
			throw new CoordoneeException("position x inférieur à 0");
		if (x >= this.longueur)
			throw new CoordoneeException("position x dépasse la taille de la grille");
		if (y < 0)
			throw new CoordoneeException("position y inférieur à 0");
		if (y >= this.largeur)
			throw new CoordoneeException("position y dépasse la taille de la grille");
		if (c == null)
			throw new CaseException("Set Case null");

		int i = this.list.indexOf(new Case(x, y));
		this.list.set(i, c);
	}

	/**
	 * @return the list
	 */
	public List<Case> getList() {
		return list;
	}

	/**
	 * @return the longueur
	 */
	public int getLongueur() {
		return longueur;
	}

	/**
	 * @return the largeur
	 */
	public int getLargeur() {
		return largeur;
	}

}