package es.correos.soporte.minerva.proyectoejemplo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleOrdenesDto {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mensaje;
	
	private Integer detalleid ;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer ordenid;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ProductoDto producto;
	
	private Integer cantidad;

}
