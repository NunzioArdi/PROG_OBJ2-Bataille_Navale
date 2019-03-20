import java.util.ArrayList;
import java.util.List;

/**
 * @author NunzioArd
 * Classe représentant un joueur
 */
public class Joueur {
	private int vie;
	private ArrayList<Bateau> listBateau;
	private String nomJoueur;
	
	
	public Joueur(int v, String name) {
		this.vie = v;
		this.nomJoueur = name;
	}
	
	public boolean isLife () {
		if(vie>0) return true;
		return false;
	}
}
