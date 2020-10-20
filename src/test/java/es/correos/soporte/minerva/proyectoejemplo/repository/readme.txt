paquete para clases de tests de repositorios. Un ejemplo podría ser:

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import es.correos.soporte.minerva.proyectoejemplo.domain.Player;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackages = "es.correos.soporte.minerva.proyectoejemplo.repository", entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
@TestPropertySource(value = "/application-write-bbdd.properties")
public class TeamRepositoryTest {
	
	@Autowired
	private ITeamRepository teamRepository;

	@Test
	public void findAll() {
		List<Player> playerList = teamRepository.findAll();

		assertEquals(4, playerList.size());
	}
}

En el caso de un test contra un repositorio que use el datasource de solo lectura, este
sería un ejemplo

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import es.correos.soporte.minerva.proyectoejemplo.domain.Player;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackages = "es.correos.soporte.minerva.proyectoejemplo.repository", entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
@TestPropertySource(value = "/application-write-bbdd.properties")
public class TeamReadRepositoryTest {
		
	@Autowired
	private ITeamReadRepository teamReadRepository;

	@Test
	public void findAll() {
		List<Player> playerList = teamReadRepository.findAll();

		assertEquals(4, playerList.size());
	}

	@Test
	public void findByNumber() {
		Player player = teamReadRepository.findByNumber(2);

		assertNotNull(player);
		assertNotNull(player.getNumber());
		assertEquals(2, player.getNumber().longValue());
	}
}

Para que todo funcione como se espera, es necesario incluir en el directorio src/test/resources un fichero
data.sql con los inserts necesarios para probar. Para el ejemplo incluído, este podría ser el fichero de datos
de pruebas

INSERT INTO PLAYER (ID_PLAYER, NAME, NUMBER, AGE)
VALUES (1,'Player 1', 1, 11);

INSERT INTO PLAYER (ID_PLAYER, NAME, NUMBER, AGE)
VALUES (2,'Player 2', 2, 12);

INSERT INTO PLAYER (ID_PLAYER, NAME, NUMBER, AGE)
VALUES (3,'Player 3', 3, 13);

INSERT INTO PLAYER (ID_PLAYER, NAME, NUMBER, AGE)
VALUES (4,'Player 4', 4, 14);

Tanto en el caso de solo lectura, como de RW, el datasource que se usará en los tests es el principal
para que se cree correctamente la bbdd en memoria y se creen sus tablas. Si se configuran los dos
a la vez, el de solo lectura no crea las tablas y fallará.