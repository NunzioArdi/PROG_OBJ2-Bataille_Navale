import java.util.ArrayList;
import java.util.List;

/**
 * @author NunzioArdi
 * @version dev0.1
 * Classe représentant un joueur
 */
@SuppressWarnings("unused")
public class Joueur {
	private int vie;
	private List<Bateau> listBateau;
	private Grille bateau;
	private Grille tire;
	private String nomJoueur;
	
	
	/**
	 * Contructeur du joueur avec ses grilles
	 * @param v
	 * @param name
	 * @param t
	 */
	public Joueur(String name, int x, int y) {
		this.nomJoueur = name;
		this.bateau = new Grille(x,y);
		this.tire = new Grille(x,y);
		this.listBateau = new ArrayList<Bateau>();
		this.vie = 5;
	}
	
	/**
	 * Indique si la joueur est toujours en vie
	 * @return true si en vie
	 */
	public boolean isLife () {
		if(vie>0) return true;
		return false;
	}

	public void addBatt(Bateau b, int x, int y, boolean dir) {
		if(this.bateau.addBateau(b, x, y, dir)) listBateau.add(b);
	}
	
	/**
	 * @param x
	 * @param y
	 * @return true si attauqe faite, false si non (remplacer par Exception)
	 */
	public boolean attack(int x, int y) {
		Case tmp = this.tire.getCase(x, y);
		if(tmp.isImpact()) return false;
		tmp.setImpact(true); return true;
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

}
