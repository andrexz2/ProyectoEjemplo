/**
 * 
 */
package es.correos.soporte.minerva.proyectoejemplo.exceptions;

public class PlayerNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 5978383078782134306L;

	public PlayerNotFoundException() {
		super();
	}

	public PlayerNotFoundException(String message) {
		super(message);
	}

	public PlayerNotFoundException(Exception newOriginalException) {
		super(newOriginalException);
	}

	public PlayerNotFoundException(String message, Exception newOriginalException) {
		super(message, newOriginalException);
	}
}
