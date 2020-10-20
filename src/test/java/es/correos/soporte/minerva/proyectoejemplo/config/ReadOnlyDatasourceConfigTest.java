package es.correos.soporte.minerva.proyectoejemplo.config;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ReadOnlyDatasourceConfig.class , ReadOnlyDatasourceConfigTest.TestConfiguration.class})
@TestPropertySource(value = "/application-datasources.properties")
public class ReadOnlyDatasourceConfigTest {
	
	@Resource(name="readTransactionManager")
	private PlatformTransactionManager readTransactionManager;
	
	@Configuration
	@EnableConfigurationProperties
	public static class TestConfiguration {

		@Bean 
		@ConditionalOnMissingBean(value=EntityManagerFactoryBuilder.class)
		public EntityManagerFactoryBuilder readEntityManagerFactoryBuilder() {
			return new EntityManagerFactoryBuilder(
					new HibernateJpaVendorAdapter(), new HashMap<>(), null);
		}
	}

	@Test
	public void contextLoad() {
		assertNotNull(readTransactionManager);
	}

}
