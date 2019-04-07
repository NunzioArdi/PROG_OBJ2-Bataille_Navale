import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Exceptions.BateauException;
import Exceptions.CaseException;
import Exceptions.CoordoneeException;

/**
 * Classe représentant une Partie en mono-joueur.
 */
@SuppressWarnings({ "serial", "unused" })
public class PartieMono extends Partie {

	/**
	 * Le joueur de la partie.
	 */
	private Joueur player;

	/**
	 * @throws BateauException 
	 * @see Partie#Partie()
	 */
	public PartieMono() throws BateauException {
		super();
	}
	
	public void initialiserPartie() throws BateauException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		String pseudo = this.getPseudo();
		
		// Tant que coordonée incorrecte
		while (!stop) {
			try {
				this.setTailleGrille();
				this.player = new Joueur(x, y, pseudo);
				stop = true;
			} catch (CoordoneeException e) {
				e.printStackTrace();
			}
		}

		// Initialisation
		this.addBateauxJoueur(this.player);
	}

	@Override
	public void lancerParie() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		// Démarage partie
		System.out.println("Le jeu commence");
		while (player.isLife()&&!stop) {
			int action = -1;
			while (action != 0 && action != 1 && action != 2 && action != 3 && action != 4 && action!=5) {
				System.out.println("Choisiser une action:\n" 
						+ "\t1) Continuer à jouer\n" 
						+ "\t2) Sauvegarder"
						+ "\t3) Afficher la vie Bateau"
						+ "\t4) Affiche la taille des bateaux"
						+ "\t5) Quitter");
				try {
					@SuppressWarnings("resource")
					Scanner sc1 = new Scanner(System.in);
					action = sc1.nextInt();
				}catch (InputMismatchException e) {
					System.out.println(e + ": Un nombre est attendu\n");
				}
			}
			
			if(action==1) {
				System.out.println("Choisiser les coordonné du missile");
				int posX = sc.nextInt();
				int posY = sc.nextInt();
				try {
					player.attack(posX, posY);
				} catch (CoordoneeException e) {
					e.printStackTrace();
				} catch (CaseException e) {
					e.printStackTrace();
				}
				System.out.println();
				System.out.println(player.getTire().toString());
			}
			else if (action==2) {
				System.out.println("Entrer un chemin de sauvegarde ");
				String locate = sc.next();
				this.sauvegerderPartie(locate);
			}
			else if(action==3) {
				player.triListeBateauVie();
				System.out.println(AfficherListeBateau(player,1));
			}
			else if(action==4) {
				player.triListeBateauTaille();
				System.out.println(AfficherListeBateau(player,2));
			}
			else if (action==5) {
				stop=true;
			}

			
		}

		System.out.println("Gagner");
	}
	
	
	@SuppressWarnings("unchecked")
	public void restaurerPartie(String locate) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(locate));
			player = (Joueur) (ois.readObject());
			x = (Integer) (ois.readObject());
			y = (Integer) (ois.readObject());
			bateaux = (ArrayList<Bateau>) (ois.readObject());
			ois.close();
		} catch (IOException e) {
			System.out.println("erreur d’E/S");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("erreur hors E/S");
			e.printStackTrace();
		}
	}
	
	protected void sauvegerderPartie(String locate) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(locate));
			oos.writeObject(player);
			oos.writeObject(x);
			oos.writeObject(y);
			oos.writeObject(bateaux);
			oos.close();
		} catch (IOException e) {
			System.out.println("erreur d’E/S");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("erreur hors E/S");
			e.printStackTrace();
		}
	}
}