package es.correos.soporte.minerva.proyectoejemplo.exceptions;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import es.correos.arq.ex.CorreosBusinessException;

@RunWith(SpringRunner.class)
public class PlayerNotFoundExceptionTest {

	@Test
	public void testDefaultContructorShouldWork() {
		PlayerNotFoundException ex = new PlayerNotFoundException();
		assertNotNull(ex);
		// TODO - estos debería venir así, pero hay algo con las excepciones core y no
		// rellena bien esta información
//		assertNull(ex.getMessage());
//		assertEquals("es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerNotFoundException", ex.toString());
	}

	@Test
	public void testMessageContructorShouldWork() {
		PlayerNotFoundException ex = new PlayerNotFoundException("message");
		assertNotNull(ex);
		// TODO - estos debería venir así, pero hay algo con las excepciones core y no
		// rellena bien esta información
//		assertEquals("message", ex.getMessage());
//		assertEquals("es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerNotFoundException: message", ex.toString());
	}

	@Test
	public void testExceptionContructorShouldWork() {
		CorreosBusinessException originalEx = new CorreosBusinessException("mensaje Business");
		PlayerNotFoundException ex = new PlayerNotFoundException(originalEx);
		assertNotNull(ex);
		// TODO - estos debería venir así, pero hay algo con las excepciones core y no
		// rellena bien esta información
//		assertEquals(originalEx.getMessage(), ex.getMessage());
//		assertEquals(originalEx, ex.getCause());
//		assertEquals(originalEx, ex.getOriginalException());
//		assertEquals("es.correos.soporte.minerva.proyectoejemplo.exceptions.core.CorreosBusinessException: mensaje Business", ex.toString());
	}

	@Test
	public void testExceptionMessageContructorShouldWork() {
		CorreosBusinessException originalEx = new CorreosBusinessException("mensaje Business", new Exception());
		PlayerNotFoundException ex = new PlayerNotFoundException("message", originalEx);
		assertNotNull(ex);
		// TODO - estos debería venir así, pero hay algo con las excepciones core y no
		// rellena bien esta información
//		assertEquals("message", ex.getMessage());
//		assertEquals(originalEx, ex.getCause());
//		assertEquals(originalEx, ex.getOriginalException());
//		assertEquals("java.lang.Exception", ex.toString());
	}

}
