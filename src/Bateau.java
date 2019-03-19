/**
 * @author romain
 *
 */
public class Bateau {
	@SuppressWarnings("unused")
	private int vie;
	private boolean mort;
	private String nom;
	private String dir;
	private int taille;
	
	
	/**
	 * @param vie
	 * @param mort
	 * @param nom
	 * @param dir
	 * @param taille
	 */
	public Bateau(int vie, boolean mort, String nom, String dir, int taille) {
		super();
		this.vie = vie;
		this.mort = false;
		this.nom = " ";
		this.dir = dir;
		this.taille = taille;
	}
	
	/**
	 * @return
	 */
	public boolean estMort() {
		if (this.vie == 0) {
			mort=true;
			
			
			
			
		}else {
			this.taille--;
			mort=false;
		
		
		}
		return mort;
		
	}
	
	/**
	 * @return
	 */
	public int getTaille() {
		return this.taille;
	}
	
	

}