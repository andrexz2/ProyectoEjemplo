package es.correos.soporte.minerva.proyectoejemplo.config;

import java.util.function.Supplier;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import es.correos.arch.boot.core.annotations.ReadOnlyRepository;
import es.correos.soporte.minerva.proyectoejemplo.properties.EntityManagerProperties;

@Configuration
@ConditionalOnProperty("spring.read.datasource.url")
@EnableJpaRepositories(	basePackages = "es.correos.soporte.minerva.proyectoejemplo.repository", 
						includeFilters = @ComponentScan.Filter(ReadOnlyRepository.class),
						entityManagerFactoryRef = "readEntityManagerFactory",
						transactionManagerRef = "readTransactionManager")
public class ReadOnlyDatasourceConfig {

	@Bean( name = "readDataSourceProperties")
	@ConfigurationProperties("spring.read.datasource")
	@ConditionalOnProperty("spring.read.datasource.url")
	public DataSourceProperties readDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@ConfigurationProperties("spring.read.entitymanager")
	@ConditionalOnProperty("spring.read.datasource.url")
	public EntityManagerProperties readEntityManagerProperties() {
		return new EntityManagerProperties();
	}
	
	@Bean
	@ConfigurationProperties("spring.read.jpa.hibernate")
	public HibernateProperties readHibernateProperties() {
		return new HibernateProperties();
	}

	@Bean
	@ConfigurationProperties("spring.read.jpa")
	public JpaProperties readJpaProperties() {
		return new JpaProperties();
	}
	
	@Bean(name = "readDataSource")
	@ConfigurationProperties("spring.read.datasource")
	@ConditionalOnProperty("spring.read.datasource.url")
	public DataSource readDataSource() {
		return readDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	@ConditionalOnProperty("spring.read.datasource.url")
	public LocalContainerEntityManagerFactoryBean readEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("readDataSource") DataSource dataSource, 
			@Qualifier("readEntityManagerProperties") EntityManagerProperties readEntityManagerProperties) {
		Supplier<String> ddlAutoSupplier = () -> "none";
		HibernateSettings settings = new HibernateSettings().ddlAuto(ddlAutoSupplier);
		// aquí se va a pisar el valor de spring.jpa.hibernate.ddl-auto= y sea el que sea, se va a poner a validate, salvo que sea none
		return builder.dataSource(dataSource).packages(readEntityManagerProperties.getPackagesToScan()).persistenceUnit("read")
				.properties(
						readHibernateProperties().determineHibernateProperties(readJpaProperties().getProperties(), settings))
				.build();

	}
	
	@Bean
	@ConditionalOnProperty("spring.read.datasource.url")
    public PlatformTransactionManager readTransactionManager(EntityManagerFactoryBuilder builder,
			@Qualifier("readDataSource") DataSource dataSource, 
			@Qualifier("readEntityManagerProperties") EntityManagerProperties readEntityManagerProperties) {
        return new JpaTransactionManager(readEntityManagerFactory(builder, dataSource, readEntityManagerProperties).getObject());
    }

}
