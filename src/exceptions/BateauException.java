package exceptions;

/**
 * Classe d'Exception appellée lorsqu'un problème survient avec un Bateau
 */
public class BateauException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1049290614476710344L;

	/**
	 * Constructeur
	 * 
	 * @param message le message de l'exception
	 */
	public BateauException(String message) {
		super(message);
	}
}
