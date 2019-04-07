package exceptions;

/**
 * Classe d'exception appelée lorque les paramètres de direction sont incorrectes. 
 */
public class DirectionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2371805179592296570L;

	/**
	 * Constructeur
	 * 
	 * @param message le message de l'exception
	 */
	public DirectionException(String message) {
		super(message);
	}

}
