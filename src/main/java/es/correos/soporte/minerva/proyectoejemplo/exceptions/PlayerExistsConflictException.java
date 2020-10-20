/**
 * 
 */
package es.correos.soporte.minerva.proyectoejemplo.exceptions;

public class PlayerExistsConflictException extends EntityExistsConflictException {
	private static final long serialVersionUID = 5978383078782134306L;

	public PlayerExistsConflictException() {
	}

	public PlayerExistsConflictException(String message) {
		super(message);
	}

	public PlayerExistsConflictException(Exception newOriginalException) {
		super(newOriginalException);
	}

	public PlayerExistsConflictException(String message, Exception newOriginalException) {
		super(message, newOriginalException);
	}
}
