import java.io.Serializable;

/**
 * Classe représentant les cases de la grille.
 */
public class Case implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 269968396375602404L;

	/**
	 * Attribut de la position x de la case sur une Grille.
	 */
	private int x;

	/**
	 * Attribut de la position y de la case sur une Grille.
	 */
	private int y;

	/**
	 * Attribut permettant de lier un Bateau sur une Case.
	 */
	private Bateau bat;

	/**
	 * Attribut permettant d'indiquer si la Case à déjà été tirée.
	 */
	private boolean impact;

	/**
	 * Constructeur de la Case. Sans Bateau et sans impact.
	 * 
	 * @param posx x
	 * @param posy y
	 */
	public Case(int posx, int posy) {
		this.x = posx;
		this.y = posy;
		impact = false;
	}

	/**
	 * Méthode permettant de lier un Bateau à une case.
	 * 
	 * @param bat
	 */
	public void setBat(Bateau bat) {
		this.bat = bat;
	}

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
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
				return "B";
		}
	}

	/**
	 * Méthode retournant le Bateau de la Case.
	 * 
	 * @return un Bateau
	 */
	public Bateau getBat() {
		return bat;
	}

	/**
	 * Méthode indiquant si la Case a déjà été tirée.
	 * 
	 * @return true si déjà tirée
	 */
	public boolean isImpact() {
		return impact;
	}

	/**
	 * Méthode indiquant que la Case a été tirée.
	 */
	public void setImpact() {
		this.impact = true;
	}
}