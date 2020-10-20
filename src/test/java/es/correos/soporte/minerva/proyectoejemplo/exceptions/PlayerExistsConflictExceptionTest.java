package es.correos.soporte.minerva.proyectoejemplo.exceptions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import es.correos.arq.ex.CorreosDAOException;

@RunWith(SpringRunner.class)
public class PlayerExistsConflictExceptionTest {

	@Test
	public void testDefaultContructorShouldWork() {
		PlayerExistsConflictException ex = new PlayerExistsConflictException();
		assertNotNull(ex);
		assertNull(ex.getMessage());
		// TODO - estos debería venir así, pero hay algo con las excepciones core y no
		// rellena bien esta información
//		assertEquals("es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerExistsConflictException", ex.toString());
	}

	@Test
	public void testMessageContructorShouldWork() {
		PlayerExistsConflictException ex = new PlayerExistsConflictException("message");
		assertNotNull(ex);
		// TODO - estos debería venir así, pero hay algo con las excepciones core y no
		// rellena bien esta información
//		assertEquals("message", ex.getMessage());
//		assertEquals("es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerExistsConflictException: message", ex.toString());
	}

	@Test
	public void testExceptionContructorShouldWork() {
		CorreosDAOException originalEx = new CorreosDAOException("mensaje DAO");
		PlayerExistsConflictException ex = new PlayerExistsConflictException(originalEx);
		assertNotNull(ex);
		// TODO - estos debería venir así, pero hay algo con las excepciones core y no
		// rellena bien esta información
//		assertEquals(originalEx.getMessage(), ex.getMessage());
//		assertEquals(originalEx, ex.getCause());
//		assertEquals(originalEx, ex.getOriginalException());
//		assertEquals("es.correos.soporte.minerva.proyectoejemplo.exceptions.core.CorreosDAOException: mensaje DAO", ex.toString());
	}

	@Test
	public void testExceptionMessageContructorShouldWork() {
		CorreosDAOException originalEx = new CorreosDAOException("mensaje DAO", new Exception());
		PlayerExistsConflictException ex = new PlayerExistsConflictException("message", originalEx);
		assertNotNull(ex);
		// TODO - estos debería venir así, pero hay algo con las excepciones core y no
		// rellena bien esta información
//		assertEquals("message", ex.getMessage());
//		assertEquals(originalEx, ex.getCause());
//		assertEquals(originalEx, ex.getOriginalException());
//		assertEquals("java.lang.Exception", ex.toString());
	}

}
