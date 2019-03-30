/**
 * @author romain
 * @author NunzioArdi
 * @version dev0.2
 */

public class Bateau {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Bateau))
			return false;
		Bateau other = (Bateau) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@SuppressWarnings("unused")
	private String nom;
	private int vie;
	private int taille;
	@SuppressWarnings("unused")
	private boolean mort;
	
	
	/**
	 * Constructeur du bateau
	 * @param n le nom du bateau
	 * @param t La taille du bateau (nombre de case prise)
	 */
	public Bateau(String n, int t) {
		this.nom = n;
		this.taille = t;
		this.vie = t;
	}
	
	/**
	 * Indique si le bateau est mort
	 * @return true si le bateau n'a plus de vie
	 */
	public boolean estMort() {
		if (this.vie == 0) return true;
		return false;
	}
	
	/**
	 * Donne la vie du Bateau en pourcentage
	 * @return la vie en %
	 */
	public double getVie() {
		return (double)this.vie/(double)this.taille*100.0 ;
	}
	
	/**
	 * Donne la taille du Bateau
	 * @return la taille
	 */
	public int getTaille() {
		return taille;
	}
	
	public void touche() {
		this.vie--;
	}
	
	
	public String getNom() {
		return nom;
	}
}