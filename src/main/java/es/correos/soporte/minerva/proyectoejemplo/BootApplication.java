package es.correos.soporte.minerva.proyectoejemplo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import es.correos.arch.boot.core.annotations.CorreosBootConfiguration;

@EnableConfigurationProperties
@CorreosBootConfiguration
@SpringBootApplication
public class BootApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		// metodo para ejecutar la aplicación con parametros.
	}
}
