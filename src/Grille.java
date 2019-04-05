import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NunzioArdi
 * @version dev0.2
 * Classe représentant une grille de combat
 */
/**
 * @author Utilisateur
 *
 */
@SuppressWarnings("serial")
public class Grille implements Serializable {
	/**
	 * la liste des cases composan la grille
	 */
	private List<Case> list;
	/**
	 * La largeur de la grille
	 */
	private int longueur;
	/**
	 * La hauteur de la grille
	 */
	private int largeur;

	/**
	 * Constructeur de la grille
	 * 
	 * @param lon la longueur
	 * @param lar la largeur
	 */
	public Grille(int lon, int lar) throws CoordoneeException {
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
		this.list = new ArrayList<Case>();
		for (int i = 0; i < this.largeur; i++) {
			for (int j = 0; j < this.longueur; j++) {
				this.list.add(new Case(i, j));
			}
		}
	}

	/**
	 * Donne l'index qu'une case de la grille
	 * 
	 * @param x absisse
	 * @param y ordonnée
	 * @return l'index de la case
	 */
	public Case getCase(int x, int y) {
		int index = list.indexOf(new Case(x, y));
		return list.get(index);
	}

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
	 * //TODO mettre des excepton pour les non ajout
	 * 
	 * @param b   le bateau
	 * @param x   posX
	 * @param y   posY
	 * @param dir la direction du bateau (0=horizontal)
	 * @return
	 */
	public boolean addBateau(Bateau b, int x, int y, int dir) throws CoordoneeException, DirectionException {
		// Vérificaton des arguments
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

		for (int i = 0; i < b.getTaille(); i++) {
			if (x >= this.longueur)
				throw new CoordoneeException("le bateau dépasse la grille en x");
			else if (y >= this.largeur)
				throw new CoordoneeException("le bateau dépasse la grille en y");
			Case tmp = new Case(x, y);
			int index = this.list.indexOf(tmp);
			if (list.get(index).getBat() != null) {
				throw new CoordoneeException("Un bateau est déjà sur la case"+x+" "+y);
			}

			tmp.setBat(b);
			list.set(index, tmp);
			if (dir == 1)
				y++;
			else
				x++;

		}
		return true;
	}

	public void setCase(int x, int y, Case tmp) {
		int i = this.list.indexOf(new Case(x, y));
		this.list.set(i, tmp);
	}

}