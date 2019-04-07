import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import Exceptions.BateauException;
import Exceptions.CaseException;
import Exceptions.CoordoneeException;
import Exceptions.DirectionException;

/**
 *Méthode de test pour la classe Grille
 */
public class GrilleTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test du Constructeur avec x inférieur à la valeur minimal. Le constructeur
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
	 * Test du Constructeur avec x supérieur à la valeur maximal. Le constructeur
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
	 * Test du Constructeur avec y inférieur à la valeur minimal. Le constructeur
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
	 * Test du Constructeur avec y supérieur à la valeur maximal. Le constructeur
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
	 * Test si les Valeur x et y sont bien mise dans l'ordre.
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
	 * Test méthode addBateau() avec coordonées x inférieur à 0 (hors de la grille)
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
	 * Test méthode addBateau() avec coordonées x supérieur à la taille (hors de la
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
	 * Test méthode addBateau() avec coordonées y inférieur à 0 (hors de la grille)
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
	 * Test méthode addBateau() avec coordonées y supérieur à la taille (hors de la
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
	 * Test méthode addBateau() avec coordonées bateau faisant dépassé un bateau en x
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauDepassementX() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("le bateau dépasse la grille en x");
		Grille g = new Grille(10, 10);
		Bateau b = new Bateau("test", 2);
		g.addBateau(b, 9, 5, 0);
	}

	/**
	 * Test méthode addBateau() avec coordonées bateau faisant dépassé un bateau en y
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
	}

	/**
	 * Test méthode addBateau() avec coordonées placant un bateau sur un autre. Un bateau sera placer
	 * horizontallement et un autre verticalement. Le vertical coupera le premierà
	 * la moitier.
	 * 
	 * @throws CoordoneeException
	 * @throws DirectionException
	 * @throws BateauException
	 */
	@Test
	public void testAddBateauSurUnAutre() throws CoordoneeException, DirectionException, BateauException {
		thrown.expect(CoordoneeException.class);
		thrown.expectMessage("Un bateau est déjà sur la case 6 5");
		Grille g = new Grille(10, 10);
		Bateau b1 = new Bateau("test1", 3);
		Bateau b2 = new Bateau("test2", 3);
		g.addBateau(b1, 5, 5, 0);
		g.addBateau(b2, 6, 4, 1);
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
		thrown.expectMessage("Mauvais paramère de direction");
		Grille g = new Grille(10, 10);
		Bateau b1 = new Bateau("test1", 3);
		g.addBateau(b1, 5, 5, -1);
	}

	/**
	 * Test méthode setCase() avec coordonées x inférieur à 0 (hors de la grille)
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
	 * Test méthode setCase() avec coordonées x supérieur à la taille (hors de la
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
	 * Test méthode setCase() avec coordonées y inférieur à 0 (hors de la grille)
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
	 * Test méthode méthode setCase() avec coordonées y supérieur à la taille (hors de la
	 * grille)
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
	 * Test  méthode setCase() avec une case null
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
