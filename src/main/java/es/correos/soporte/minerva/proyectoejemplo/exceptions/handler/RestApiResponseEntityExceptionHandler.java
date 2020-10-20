package es.correos.soporte.minerva.proyectoejemplo.exceptions.handler;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import es.correos.arch.boot.core.exception.ArchErrorCode;
import es.correos.arch.boot.core.exception.handler.CoreRestApiResponseEntityExceptionHandler;
import es.correos.arch.boot.core.properties.CoreApplicationProperties;

@ControllerAdvice
public class RestApiResponseEntityExceptionHandler extends CoreRestApiResponseEntityExceptionHandler {

	
	public RestApiResponseEntityExceptionHandler(CoreApplicationProperties coreApplicationProperties) {		
		super(coreApplicationProperties);
	}

	@ExceptionHandler(es.correos.soporte.minerva.proyectoejemplo.exceptions.EntityNotFoundException.class)
	public ResponseEntity<Object> handleElementNotFoundException(final es.correos.soporte.minerva.proyectoejemplo.exceptions.EntityNotFoundException ex,
			final WebRequest request) {

		return getTechnicalExceptionResponseEntity(request, ArchErrorCode.ENTITY_NOT_FOUND, ex.getMessage(),
				Arrays.asList(ex.getMessage()), getStackTrace(ex), null);
	}

	@ExceptionHandler(es.correos.soporte.minerva.proyectoejemplo.exceptions.EntityExistsConflictException.class)
	public ResponseEntity<Object> handleExistsConflictException(
			final es.correos.soporte.minerva.proyectoejemplo.exceptions.EntityExistsConflictException ex, final WebRequest request) {

		return getTechnicalExceptionResponseEntity(request, ApplicationErrorCode.ENTITY_EXISTS_CONFLICT, ex.getMessage(),
				Arrays.asList(ex.getMessage()), getStackTrace(ex), HttpStatus.CONFLICT);
	}
	// se pueden añadir aquí gestiones para cualquier excepción de la aplicación, o definir unas
	// genéricas, como se ha hecho para notfound o exist, y solo tratar esas. Las demás excepciones deben
	// extender de las genéricas y serían tratadas. En caso de no estar tratadas aquí,
	// entrará la clase padre y lo hará por defecto.

}
