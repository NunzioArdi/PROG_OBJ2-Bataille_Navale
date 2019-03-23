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
public class Grille {
	/**
	 * la liste des cases composan la grille
	 */
	private List<Case> list;
	/**
	 * La largeur de la grille
	 */
	private int largeur;
	/**
	 * La hauteur de la grille
	 */
	private int hauteur;

	/**
	 * Constructeur de la grille
	 * 
	 * @param l la largeur
	 * @param h la hauteur
	 */
	public Grille(int l, int h) {
		// TODO les if devrond devenir des exceptions dans le jeu
		if (l < 10)
			l = 10;
		if (h > 10)
			h = 10;
		if (l > 30)
			l = 30;
		if (h > 30)
			h = 30;
		this.hauteur = h;
		this.largeur = l;
		this.list = new ArrayList<Case>();
		for (int i = 0; i < this.hauteur; i++) {
			for (int j = 0; j < this.largeur; j++) {
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
		for (int i = 0; i < this.hauteur; i++) {
			for (int j = 0; j < this.largeur; j++) {
				tmp = getCase(i, j);
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
	 * @param dir la direction du bateau
	 * @return
	 */
	public boolean addBateau(Bateau b, int x, int y, boolean dir) {
		if (positionValide(b, x, y, dir)) {
			for (int i = 0; i < b.getTaille(); i++) {
				Case tmp = new Case(x, y);
				int index = this.list.indexOf(tmp);
				tmp.setBat(b);
				list.set(index, tmp);
				if (dir)
					y++;
				else
					x++;
			}
			return true;
		}
		return false;
	}

	/**
	 * 
	 * //TODO créé exception lorsque positionValide return false
	 * 
	 * @param b
	 * @param x
	 * @param y
	 * @param dir
	 * @return
	 */
	public boolean positionValide(Bateau b, int x, int y, boolean dir) {
		int i = 0;
		boolean res = true;
		while (i < b.getTaille() && res) {
			res = list.contains(new Case(x, y));
			if (dir)
				y++;
			else
				x++;
			i++;
		}
		return res;
	}
}