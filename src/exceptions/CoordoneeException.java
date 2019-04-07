package exceptions;

/**
 * Classe d'exception appellée lorsque les coordonnées posent un problème.
 */
public class CoordoneeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7457002118191721614L;
	
	/**
	 * Constructeur
	 * 
	 * @param message le message de l'exception
	 */
	public CoordoneeException(String message) {
		super(message);
	}
}
