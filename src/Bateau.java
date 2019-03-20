/**
 * @author romain
 *
 */
@SuppressWarnings("unused")
public class Bateau {
	private int vie;
	private int taille;
	private boolean mort;
	private String nom;
	private int dir;
	private int posX;
	private int posY;
	
	
	/**
	 * Constructeur du bateau
	 * @param n le nom du bateau
	 * @param d la direction (0 =  Horizontal, 1 = Vertical)
	 * @param t La taille du bateau (nombre de case prise) 
	 */
	public Bateau(String n, int d, int t) {
		this.vie = t;
		this.nom = n;
		this.dir = d;
		this.taille = t;
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