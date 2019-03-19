
/**
 * @author NunzioArdi
 * @version dev0.1 Classe reprsentant les cases de la grille
 */
public class Case {
	/**
	 * Position x de la case
	 */
	private int x;
	/**
	 * Pasotion y de la case
	 */
	private int y;

	private Bateau bat;

	private boolean impact;

	/**
	 * Constructeur de la case
	 * 
	 * @param posx x
	 * @param posy y
	 */
	public Case(int posx, int posy) {
		this.x = posx;
		this.y = posy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int res = 1;
		res = prime * res + x;
		res = prime * res + y;
		return res;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) //obj est Case et x,y egal
			return true;
		if (this == null) //obj est null
			return false;
		if (getClass() != obj.getClass()) //obj est non Case
			return false;
		Case other = (Case) obj; //convert obj en Case
		if (x != other.x) //obj.x diff (non exist?) de x
			return false;
		if (y != other.y) //obj.y diff (non exist?) de y
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (impact) {
			if (bat == null)
				return "X";
			else
				return "#";
		} else {
			if (bat == null)
				return ".";
			else
				return "§";
		}
	}
}