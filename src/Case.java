
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

	@SuppressWarnings("unused")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (this == null) 
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
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