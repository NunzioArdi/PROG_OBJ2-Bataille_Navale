import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.BateauException;
import exceptions.CaseException;
import exceptions.CoordoneeException;
import exceptions.DirectionException;

/**
 * Méthode de test pour la classe Grille
 */
@SuppressWarnings("unused")
public class GrilleTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test du Constructeur avec x inférieur à la valeur minimale. Le constructeur
	 * doit retourner une erreur et ce test vérifie que l'erreur retourne le bon
	 * message.
	 * 
	 * @throws CoordoneeException Coordonnée invalide
	 */

	@Test
	public void testConstructeurXInfMin() throws CoordoneeException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("longeur inférieur à 10 cases");
		Grille g = new Grille(-1, 10);
	}

	/**
	 * Test du Constructeur avec x supérieur à la valeur maximale. Le constructeur
	 * doit retourner une erreur et ce test vérifie que l'erreur retourne le bon
	 * message.
	 * 
	 * @throws CoordoneeException Coordonnée invalide
	 */
	@Test
	public void testConstructeurXSupMax() throws CoordoneeException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("longeur supérieur à 50 cases");
		Grille g2 = new Grille(100, 10);
	}

	/**
	 * Test du Constructeur avec y inférieur à la valeur minimale. Le constructeur
	 * doit retourner une erreur et ce test vérifie que l'erreur retourne le bon
	 * message.
	 * 
	 * @throws CoordoneeException Coordonnée invalide
	 */
	@Test
	public void testConstructeurYInfMin() throws CoordoneeException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("largeur inférieur à 10 cases");
		Grille g = new Grille(10, -1);
	}

	/**
	 * Test du Constructeur avec y supérieur à la valeur maximale. Le constructeur
	 * doit retourner une erreur et ce test vérifie que l'erreur retourne le bon
	 * message.
	 * 
	 * @throws CoordoneeException Coordonnée invalide
	 */
	@Test
	public void testConstructeurYSupMax() throws CoordoneeException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("largeur supérieur à 50 cases");
		Grille g = new Grille(10, 100);
	}

	/**
	 * Test si les valeurs x et y sont bien misent dans l'ordre.
	 * 
	 * @throws CoordoneeException Coordonnée invalide
	 */
	@Test
	public void testConstructeurValueur() throws CoordoneeException {
		Grille g = new Grille(15, 10);
		assertEquals("La longeur devrait être 15", 15, g.getLongueur());
		assertEquals("La largeur devrait être 10", 10, g.getLargeur());
	}

	/**
	 * Test le constrcuteur de la liste de cases.
	 * 
	 * @throws CoordoneeException Coordonnée invalide
	 */
	@Test
	public void testConstructeurListe() throws CoordoneeException {
		int x = 15, y = 11;
		Grille g = new Grille(x, y);
		for (int i = 0; i < x; i++) { // y
			for (int j = 0; j < y; j++) { // x
				int tmp = g.getList().indexOf(new Case(j, i));
				assertEquals("X devrait être égal à " + j, j, g.getCase(j, i).getX());
				assertEquals("Y devrait être égal à " + i, i, g.getList().get(tmp).getY());
			}
		}
	}

	/**
	 * Test méthode addBateau() avec un Bateau null
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauNull() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(BateauException.class);
		thrown.expectMessage("Ajout d'un Bateau NULL");
		Grille g = new Grille(10, 10);
		Bateau b = null;
		g.addBateau(b, 5, 5, 0);
	}

	/**
	 * Test méthode addBateau() avec un Bateau mort
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauMort() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(BateauException.class);
		thrown.expectMessage("Ajout d'un Bateau mort");
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 1);
		b.touche();
		g.addBateau(b, 5, 5, 0);
	}

	/**
	 * Test méthode addBateau() avec coordonée x inférieure à 0 (hors de la grille)
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauXInf0() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("position x inférieur à 0");
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 1);
		g.addBateau(b, -1, 5, 0);
	}

	/**
	 * Test méthode addBateau() avec coordonée x supérieure à la taille (hors de la
	 * grille)
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauXSupTaille() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("position x dépasse la taille de la grille");
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 1);
		g.addBateau(b, 10, 5, 0);
	}

	/**
	 * Test méthode addBateau() avec coordonée y inférieure à 0 (hors de la grille)
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauYInf0() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("position y inférieur à 0");
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 1);
		g.addBateau(b, 5, -1, 0);
	}

	/**
	 * Test méthode addBateau() avec coordonée y supérieure à la taille (hors de la
	 * grille)
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauYSupTaille() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("position y dépasse la taille de la grille");
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 1);
		g.addBateau(b, 5, 10, 0);
	}

	/**
	 * Test méthode addBateau() avec coordonées bateau faisant dépasser le bateau en
	 * x. Ce Test vérifie les exceptions.
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauDepassementX1() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("le bateau dépasse la grille en x");
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 2);
		g.addBateau(b, 9, 5, 0);
	}

	/**
	 * Test méthode addBateau() avec coordonées bateau faisant dépasser un bateau en
	 * x. Ce test vérifie que le bateau ne s'est pas mis sur la Grille.
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauDepassementX2() throws CoordoneeException, DirectionException, BateauException {
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 2);
		try {
			g.addBateau(b, 9, 5, 0);
		} catch (CoordoneeException e) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					Case tmp = g.getCase(j, i);
					assertEquals("Le bateau de devrait pas être mis sur la case " + j + " " + i, null, tmp.getBat());
				}
			}
		}
	}

	/**
	 * Test méthode addBateau() avec coordonées bateau faisant dépasser un bateau en
	 * y. Ce Test Vérifie les exceptions.
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauDepassementY() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("le bateau dépasse la grille en y");
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 2);
		g.addBateau(b, 5, 9, 1);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Case tmp = g.getCase(j, i);
				assertEquals("Le bateau de devrait pas être mis sur la case " + j + " " + i, null, tmp.getBat());
			}
		}
	}

	/**
	 * Test méthode addBateau() avec coordonées bateau faisant dépasser un bateau en
	 * x. Ce Test vérifie que le bateau ne s'est pas mis sur la Grille.
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauDepassementY2() throws BateauException, DirectionException, CoordoneeException {
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 2);
		try {
			g.addBateau(b, 5, 9, 0);
		} catch (CoordoneeException e) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					Case tmp = g.getCase(j, i);
					assertEquals("Le bateau de devrait pas être mis sur la case " + j + " " + i, null, tmp.getBat());
				}
			}
		}
	}

	/**
	 * Test méthode addBateau() avec coordonées plaçant un bateau sur un autre. Un
	 * bateau sera placé horizontalement et un autre verticalement. Le deuxième
	 * coupera le premier à la moitié.
	 * Ce test vérifie les Exceptions
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauSurUnAutre1() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("Un bateau est déjà sur la case 6 5");
		Grille g = new Grille(10, 10);
		Bateau b1 = new Bateau("test1", 3);
		Bateau b2 = new Bateau("test2", 3);
		g.addBateau(b1, 5, 5, 0);
		g.addBateau(b2, 6, 4, 1);

		
	}

	/**
	 * Test méthode addBateau() avec coordonées plaçant un bateau sur un autre. Un
	 * bateau sera placé horizontalement et un autre verticalement. Le deuxième
	 * coupera le premier à la moitié.
	 * Ce test vérifie que le bateau ne s'est pas mis sur la Grille.
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauSurUnAutre2() throws CoordoneeException, BateauException, DirectionException {
		Grille g = new Grille(10, 10);
		Bateau b1 = new Bateau("test1", 3);
		Bateau b2 = new Bateau("test2", 3);
		try {
			g.addBateau(b1, 5, 5, 0);
			g.addBateau(b2, 6, 4, 1);
		} catch (CoordoneeException e) {
			Case tmp = g.getCase(6, 4);
			assertEquals("Le bateau de devrait pas être mis sur la case 6 4", null, tmp.getBat());

			Case tmp2 = g.getCase(6, 5);
			assertEquals("Le bateau de devrait pas être mis sur la case 6 5", false, tmp2.getBat().equals(b2));
			
			Case tmp3 = g.getCase(6, 6);
			assertEquals("Le bateau de devrait pas être mis sur la case 6 6", null, tmp3.getBat());
		}
	}

	/**
	 * Test méthode addBateau() avec direction bateau incorrecte
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauDirectionInvalide() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(DirectionException.class);
		thrown.expectMessage("Mauvais paramètre de direction");
		Grille g = new Grille(10, 10);
		Bateau b1 = new Bateau("test1", 3);
		g.addBateau(b1, 5, 5, -1);
	}

	/**
	 * Test méthode setCase() avec coordonée x inférieure à 0 (hors de la grille)
	 * 
	 * @throws CoordoneeException
	 * @throws CaseException
	 */
	@Test
	public void testSetCaseXInf0() throws CoordoneeException, CaseException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("position x inférieur à 0");
		Grille g = new Grille(10, 10);
		Case c = new Case(1, 1);
		g.setCase(-1, 0, c);
	}

	/**
	 * Test méthode setCase() avec coordonée x supérieure à la taille (hors de la
	 * grille)
	 * 
	 * @throws CoordoneeException
	 */
	@Test
	public void testSetCaseXSupTaille() throws CoordoneeException, CaseException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("position x dépasse la taille de la grille");
		Grille g = new Grille(10, 10);
		Case c = new Case(1, 1);
		g.setCase(100, 0, c);
	}

	/**
	 * Test méthode setCase() avec coordonée y inférieure à 0 (hors de la grille)
	 * 
	 * @throws CoordoneeException
	 * @throws CaseException
	 */
	@Test
	public void testSetCaseYInf0() throws CoordoneeException, DirectionException, BateauException, CaseException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("position y inférieur à 0");
		Grille g = new Grille(10, 10);
		Case c = new Case(1, 1);
		g.setCase(0, -1, c);
	}

	/**
	 * Test méthode méthode setCase() avec coordonée y supérieure à la taille (hors
	 * de la grille)
	 * 
	 * @throws CoordoneeException
	 * @throws CaseException
	 */
	@Test
	public void testSetCaseYSupTaille() throws CoordoneeException, DirectionException, BateauException, CaseException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("position y dépasse la taille de la grille");
		Grille g = new Grille(10, 10);
		Case c = new Case(1, 1);
		g.setCase(0, 100, c);
	}

	/**
	 * Test méthode setCase() avec une case null
	 * 
	 * @throws CoordoneeException
	 * @throws CaseException
	 */
	@Test
	public void testSetCaseNull() throws CoordoneeException, DirectionException, BateauException, CaseException {
		thrown.expect(CaseException.class);
		thrown.expectMessage("Set Case null");
		Grille g = new Grille(10, 10);
		Case c = null;
		g.setCase(0, 0, c);
	}
}
