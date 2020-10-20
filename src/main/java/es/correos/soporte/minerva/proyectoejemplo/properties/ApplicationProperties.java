package es.correos.soporte.minerva.proyectoejemplo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** The Class ApplicationProperties. */
@ConfigurationProperties(prefix = "application")
@Component
@NoArgsConstructor
@Getter
@Setter
public class ApplicationProperties {

	/** propiedad ejemplo */
	private String propiedad;
}
