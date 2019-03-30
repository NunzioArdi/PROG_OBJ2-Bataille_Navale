import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un joueur
 */
@SuppressWarnings({ "unused", "serial" })
public class Joueur implements Serializable {
	private int vie;
	private List<Bateau> listBateau;
	private Grille bateau;
	private Grille tire;
	private String pseudo;

	/**
	 * Contructeur du joueur avec ses 2 grilles et ses 5 points de vie
	 * 
	 * @param x longeur grille
	 * @param y largeur grille
	 */
	public Joueur(int x, int y) {
		this.bateau = new Grille(x, y);
		this.tire = new Grille(x, y);
		this.listBateau = new ArrayList<Bateau>();
		this.vie = 5;
	}

	/**
	 * Indique si la joueur est toujours en vie
	 * 
	 * @return true si en vie
	 */
	public boolean isLife() {
		if (vie > 0)
			return true;
		return false;
	}

	public void addBatt(Bateau b, int x, int y, boolean dir) {
		if (this.bateau.addBateau(b, x, y, dir))
			listBateau.add(b);
	}

	/**
	 * @param x
	 * @param y
	 * @return true si attauqe faite, false si non
	 */
	public boolean attack(int x, int y) {
		Case tmp = this.tire.getCase(x, y);
		if (tmp.isImpact()) {
			return false;
		} else {
			tmp.setImpact();
			Bateau b = this.bateau.getCase(x, y).getBat();
			if (b!=null) {
				tmp.setBat(b);
				b.touche();
				this.tire.setCase(x, y, tmp);
				if(b.estMort()) {
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
	 * @return the bateau
	 */
	public Grille getBateau() {
		return bateau;
	}

	/**
	 * @return the tire
	 */
	public Grille getTire() {
		return tire;
	}

	/**
	 * @return the vie
	 */
	public int getVie() {
		return vie;
	}

	public void setPseudo(String string1) {
		this.pseudo = string1;
	}

	
	//DEBUG
	public void getVieListBateau() {
		for (int i = 0; i < this.listBateau.size(); i++) {
			System.out.println(listBateau.get(i).getVie() + listBateau.get(i).getNom());
		}
	}
}
