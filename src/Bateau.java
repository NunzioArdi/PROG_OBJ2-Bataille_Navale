import java.io.Serializable;

import exceptions.BateauException;

/**
 * Classe représentant les Bateaux.
 */
public class Bateau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1371518752398993181L;

	/**
	 * Le nom du Bateau.
	 */
	private String nom;
	/**
	 * La vie du Bateau.
	 */
	private int vie;
	/**
	 * La taille du Bateau.
	 */
	private int taille;

	/**
	 * Constructeur du bateau. Au départ, la vie est égale à la taille.
	 * 
	 * @param n le nom du bateau
	 * @param t La taille du bateau (nombre de case prise)
	 * @throws BateauException Cette exception est levée quand la taille est
	 *                         inférieur à 1
	 */
	public Bateau(String n, int t) throws BateauException {
		this.nom = n;
		if (t < 1) {
			throw new BateauException("Taille inférieur à 1");
		}
		this.taille = t;
		this.vie = t;
	}

	/**
	 * Indique si le bateau est mort.
	 * 
	 * @return true si le bateau n'a plus de vie
	 */
	public boolean estMort() {
		if (this.vie == 0)
			return true;
		return false;
	}

	/**
	 * Donne la vie du Bateau en pourcentage.
	 * 
	 * @return la vie en %
	 */
	public double getVie() {
		return (double) this.vie / (double) this.taille * 100.0;
	}

	/**
	 * Donne la taille du Bateau.
	 * 
	 * @return la taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Méthode qui retire 1 point de vie au Bateau lorsque celui-ci est touché par
	 * un missile.
	 */
	public void touche() {
		this.vie--;
	}

	/**
	 * Méthode donnant le nom du Bateau.
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
}