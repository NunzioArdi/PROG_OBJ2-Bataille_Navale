import java.util.Scanner;

/**
 * En mono joueur, les bateau sont placer automatiquement
 *
 */
public class Partie {
	public static void main(String[] args) {
		int x=0, y=0;
		System.out.println("Touch� coul� en mono-joueur\n"
				+ "Les 5 bateaux sont plac� automatiquement sur une grille\n"
				+ "Le joueur doit d�truir tout les bateaux pour gagner\n");
	
		System.out.print("Donner la taille de la grille (x et y): ");
		Scanner sc = new Scanner(System.in);
		x  = sc.nextInt();
		y  = sc.nextInt();
		System.out.println("Grille de "+x+"x"+y);
		System.out.println("Donn� votre pseudo");
		Joueur player = new Joueur(sc.next(),x,y );
		System.out.println(player.getBateau().toString());
		sc.close();
		
	
	
	
	}
}
