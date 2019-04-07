package exceptions;

/**
 * Classe d'Exception appellée lorsque un problème survient avec une case
 */
public class CaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7221803608045911756L;

	/**
	 * Constructeur
	 * 
	 * @param message le message de l'exception
	 */
	public CaseException(String message) {
		super(message);
	}
}
