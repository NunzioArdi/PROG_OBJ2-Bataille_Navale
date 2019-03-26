import java.util.Scanner;

/**
 * @author NunzioArdi
 *
 */
public class Partie {
	public static void main(String[] args) {
		int x=0, y=0;
		System.out.println("Touchée coulé en mono-joueur\n"
				+ "Le joueur doit détruir tout les bateaux pour gagner\n");
	
		System.out.print("Donner la taille de la grille (x et y): ");
		
		Scanner sc = new Scanner(System.in);
		x  = sc.nextInt();
		y  = sc.nextInt();
		
		System.out.println("Grille de "+x+"x"+y);
		System.out.println("Donné votre pseudo");
		Joueur player = new Joueur(sc.next(),x,y );
		System.out.println(player.getBateau().toString());
		sc.close();
	}
}