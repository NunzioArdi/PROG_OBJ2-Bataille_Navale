import java.util.ArrayList;
import java.util.List;

/**
 * @author NunzioArdi
 * @version dev0.1
 * Classe représentant la grille de combat
 */
public class Grille{
	private List<Case> list;
	private int largeur;
	private int hauteur;
	
	public Grille(int l, int h) {
		this.hauteur=h;
		this.largeur=l;
		this.list = new ArrayList<Case>();
		for (int i = 0; i < this.hauteur; i++) {
			for (int j = 0; j < this.largeur; j++) {
				this.list.add(new Case(i,j));
			}
		}
	}
	
	/**
	 * Ajoute une case la liste de Case de la grille
	 * @param c la case a ajouter
	 */
	public void addCase(Case c) {
		list.add(c);
	}
	
	/**
	 * Donne l'index qu'une case de la grille de la liste de case
	 * @param x absisse
	 * @param y ordonnée
	 * @return l'index de la case 
	 */
	public Case getCase(int x, int y) {
		int index = list.indexOf(new Case(x,y));
		return list.get(index);
	}
	
	@Override
	public String toString() {
		Case tmp = null;
		String s = "";
		for (int i = 0; i < this.hauteur; i++) {
			for (int j = 0; j < this.largeur; j++) {
				tmp = getCase(i,j);
				s = s + tmp.toString() + " ";
			}
			s = s+"\n";
		}
		return s;
	}
	
	
	
	
	
	
	
	
	//debug
	public int getHauteur() {
		return hauteur;
	}
	
	public int getLargeur() {
		return largeur;
	}
	
	public List<Case> getList() {
		return list;
	}
	
}