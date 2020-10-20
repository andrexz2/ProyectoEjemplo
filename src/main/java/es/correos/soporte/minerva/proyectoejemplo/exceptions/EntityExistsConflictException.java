/**
 * 
 */
package es.correos.soporte.minerva.proyectoejemplo.exceptions;

import es.correos.arq.ex.CorreosDAOException;

public abstract class EntityExistsConflictException extends CorreosDAOException {
	private static final long serialVersionUID = 5978383078782134306L;

	public EntityExistsConflictException() {
		super();
	}

	public EntityExistsConflictException(String message) {
		super(message);
	}

	public EntityExistsConflictException(Exception newOriginalException) {
		super(newOriginalException);
	}

	public EntityExistsConflictException(String message, Exception newOriginalException) {
		super(message, newOriginalException);
	}
}
