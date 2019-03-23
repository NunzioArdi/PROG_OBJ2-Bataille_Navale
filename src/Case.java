
/**
 * @author NunzioArdi
 * @version dev0.2
 * Classe reprsentant les cases de la grille
 */
public class Case {
	/**
	 * Position x de la case
	 */
	private int x;
	
	/**
	 * Position y de la case
	 */
	private int y;

	/**
	 * Le bateau sur la case ou null si pas Bateau
	 */
	private Bateau bat;

	/**
	 * true si la case a été tiré
	 */
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
	
	public void setBat(Bateau bat) {
		this.bat = bat;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
				return "�";
		}
	}

	/**
	 * @return the bat
	 */
	public Bateau getBat() {
		return bat;
	}

	/**
	 * @return the impact
	 */
	public boolean isImpact() {
		return impact;
	}

	/**
	 * @param impact the impact to set
	 */
	public void setImpact(boolean impact) {
		this.impact = impact;
	}
	
	
}