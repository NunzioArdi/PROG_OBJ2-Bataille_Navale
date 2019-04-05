import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe représentant un joueur.
 */
@SuppressWarnings({ "unused", "serial" })
public class Joueur implements Serializable {
	/**
	 * La vie du joueur.
	 */
	private int vie;
	/**
	 * La liste des Bateaux du Joueur.
	 */
	private List<Bateau> listBateau;
	/**
	 * La Grille des Bateaux du Joueur.
	 */
	private Grille bateau;
	/**
	 * La Grille de tire du Joueur.
	 */
	private Grille tire;
	/**
	 * Le pseudonyme du joueur.
	 */
	private String pseudo;

	/**
	 * Constructeur du Joueur avec ses 2 Grilles et 5 points de vie.
	 * 
	 * @param x longeur grille
	 * @param y largeur grille
	 * @throws CoordoneeException Cette Exception est levée si les valeurs de la
	 *                            taille de Grille sont inférieurs au MIN ou
	 *                            supérieurs au MAX
	 */
	public Joueur(int x, int y) throws CoordoneeException {
		this.bateau = new Grille(x, y);
		this.tire = new Grille(x, y);
		this.listBateau = new ArrayList<Bateau>();
		this.vie = 5;
	}

	/**
	 * Méthode indique si le Joueur est toujours en vie.
	 * 
	 * @return true si en vie
	 */
	public boolean isLife() {
		if (vie > 0)
			return true;
		return false;
	}

	/**
	 * Méthode ajoutant un Bateau à la liste de Bateau du joueur et place se bateau
	 * sur la Grille Bateau.
	 * 
	 * @param b   le bateau à ajouter
	 * @param x   l'abscisse de la position
	 * @param y   l'ordonnée de la position
	 * @param dir la direction du bateau (0=horizontal/1=verticale)
	 * @throws CoordoneeException Cette Exception est levée si les paramètres de
	 *                            coordonnées donnés dépassent la taille maximum MAX
	 *                            ou la taille minimum MIN de la Grille, si les
	 *                            coordonnées font dépasser le Bateau de Grille, si
	 *                            un Bateau se trouve déjà aux coordonnées indiquées
	 * @throws DirectionException Cette Exception est levée quand le paramètre de
	 *                            direction donné n'est pas ce qui est attendu
	 */
	public void addBatt(Bateau b, int x, int y, int dir) throws CoordoneeException, DirectionException {
		this.bateau.addBateau(b, x, y, dir);
		listBateau.add(b);
	}

	/**
	 * Méthode permetant au Joueur d'attaquer.
	 * 
	 * @param x l'abscisse de la position
	 * @param y l'ordonnée de la position
	 * @return true si attauqe faite, false si non
	 */
	public boolean attack(int x, int y) {
		Case tmp = this.tire.getCase(x, y);
		if (tmp.isImpact()) {
			return false;
		} else {
			tmp.setImpact();
			Bateau b = this.bateau.getCase(x, y).getBat();
			if (b != null) {
				tmp.setBat(b);
				b.touche();
				this.tire.setCase(x, y, tmp);
				if (b.estMort()) {
					this.vie--;
				}
			}
		}
		return true;
	}

	public void coulee() {
		vie--;
	}

	/**
	 * Méthode retournant la Grille de Bateau.
	 * 
	 * @return the bateau
	 */
	public Grille getBateau() {
		return bateau;
	}

	/**
	 * Méthode retournant la Grille de Tire.
	 * 
	 * @return the tire
	 */
	public Grille getTire() {
		return tire;
	}

	/**
	 * Méthode retournant la vie du Joueur.
	 * 
	 * @return the vie
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * Méthode qui donne un nom au Joueur.
	 * 
	 * @param string le pseudo
	 */
	public void setPseudo(String string) {
		this.pseudo = string;
	}

	// DEBUG
	public void getVieListBateau() {
		for (int i = 0; i < this.listBateau.size(); i++) {
			System.out.println(listBateau.get(i).getVie() + listBateau.get(i).getNom());
		}
	}

	/**
	 * Méthode triant les Bateaux par leur taille
	 */
	public void triListeBateauTaille() {

		/**
		 * Classe interne de méthode servant de classe de comparaison pour la méthode
		 * sort. Compare la taille des Bateaux et les trie par ordres décroissant.
		 */
		class BateauTailleComparator implements Comparator<Bateau> {

			@Override
			public int compare(Bateau o1, Bateau o2) {
				int to1 = o1.getTaille();
				int to2 = o2.getTaille();
				if (to1 > to2)
					return -1;
				if (to1 < to2)
					return 1;
				return 0;
			}
		}

		Collections.sort(this.listBateau, new BateauTailleComparator());
	}

	/**
	 * Méthode triant les Bateaux par leur taille
	 */
	public void triListeBateauVie() {

		/**
		 * Classe interne de méthode servant de classe de comparaison pour la méthode
		 * sort. Compare la vie des Bateaux et les trie par ordres décroissant.
		 */
		class BateauVieComparator implements Comparator<Bateau> {

			@Override
			public int compare(Bateau o1, Bateau o2) {
				double to1 = o1.getVie();
				double to2 = o2.getVie();
				if (to1 > to2)
					return -1;
				if (to1 < to2)
					return 1;
				return 0;
			}
		}

		Collections.sort(this.listBateau, new BateauVieComparator());
	}

}
