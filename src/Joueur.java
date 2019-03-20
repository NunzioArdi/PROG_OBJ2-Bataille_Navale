import java.util.ArrayList;
import java.util.List;

/**
 * @author NunzioArd
 * Classe représentant un joueur
 */
@SuppressWarnings("unused")
public class Joueur {
	private int vie;
	private ArrayList<Bateau> listBateau;
	private ArrayList<Bateau> listBateau2;
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
	}
	
	/**
	 * Mise en place des bateaux pour le joueur(mono-joueur uniquement)
	 */
	public void setAllBateaux() {
		
	}
	
	
	public boolean isLife () {
		if(vie>0) return true;
		return false;
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

}
