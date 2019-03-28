import java.util.Scanner;


/**
 * Classe Représentant le type de Partie en mono-joueur.
 *
 */
public class PartieMono extends Partie {
	/**
	 * Le nom du joueur de la partie
	 */
	private String pseudo;
	
	/**
	 * Attribut reliant le joueur à la partie(sauvegarde)
	 */
	private Joueur j;

	
	/**
	 * @see Partie#Partie()
	 */
	public PartieMono() {
		super();
	}
	
	@Override
	protected void getPseudo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Donné votre pseudo: ");
		this.pseudo = sc.next();
		sc.close();

	}

	@Override
	public void lancerParie() {
		//TODO
	}

}
