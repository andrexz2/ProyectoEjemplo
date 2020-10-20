package es.correos.soporte.minerva.proyectoejemplo.exceptions.handler;

import static org.junit.Assert.assertEquals;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.correos.arch.boot.core.exception.ApiError;
import es.correos.arch.boot.core.properties.CoreApplicationProperties;
import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerExistsConflictException;
import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerNotFoundException;

@RunWith(SpringRunner.class)
public class RestApiResponseEntityExceptionHandlerTest {

	private RestApiResponseEntityExceptionHandler restApiResponseEntityExceptionHandler;

	private WebRequest request;

	@Mock
	private HttpInputMessage httpInputMessage;

	protected static ObjectMapper om = new ObjectMapper();

	@Before
	public void setup() {
		MockHttpServletRequest servletRequest = new MockHttpServletRequest("GET", "/");
		MockHttpServletResponse servletResponse = new MockHttpServletResponse();
		CoreApplicationProperties coreApplicationProperties = new CoreApplicationProperties();
		this.request = new ServletWebRequest(servletRequest, servletResponse);
		this.restApiResponseEntityExceptionHandler = new RestApiResponseEntityExceptionHandler(coreApplicationProperties);
		om.registerModule(new JavaTimeModule());
		om.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}


	@Test
	public void testHandleElementNotFoundException() {
		es.correos.soporte.minerva.proyectoejemplo.exceptions.EntityNotFoundException ex = new PlayerNotFoundException("Player not found");
		ResponseEntity<Object> responseEntity = this.restApiResponseEntityExceptionHandler
				.handleElementNotFoundException(ex, this.request);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
		assertEquals(ex.getMessage(), ((ApiError) Objects.requireNonNull(responseEntity.getBody())).getMessage());
	}

	@Test
	public void testHandleExistsConflictException() {
		es.correos.soporte.minerva.proyectoejemplo.exceptions.EntityExistsConflictException ex = new PlayerExistsConflictException(
				"Player not found");
		ResponseEntity<Object> responseEntity = this.restApiResponseEntityExceptionHandler
				.handleExistsConflictException(ex, this.request);

		assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
		assertEquals(ex.getMessage(), ((ApiError) Objects.requireNonNull(responseEntity.getBody())).getMessage());
		assertEquals(ApplicationErrorCode.ENTITY_EXISTS_CONFLICT, ((ApiError) Objects.requireNonNull(responseEntity.getBody())).getErrorCode());
		assertEquals(ApplicationErrorCode.ENTITY_EXISTS_CONFLICT.getReasonPhrase(), ((ApplicationErrorCode)((ApiError) Objects.requireNonNull(responseEntity.getBody())).getErrorCode()).getReasonPhrase());
	}

}
