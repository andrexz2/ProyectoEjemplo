/**
 * 
 */
package es.correos.soporte.minerva.proyectoejemplo.exceptions;

import es.correos.arq.ex.CorreosDAOException;

public abstract class EntityNotFoundException extends CorreosDAOException {
	private static final long serialVersionUID = 5978383078782134306L;

	public EntityNotFoundException() {
		super();
	}

	public EntityNotFoundException(String message) {
		super(message);
	}

	public EntityNotFoundException(Exception newOriginalException) {
		super(newOriginalException);
	}

	public EntityNotFoundException(String message, Exception newOriginalException) {
		super(message, newOriginalException);
	}
}
