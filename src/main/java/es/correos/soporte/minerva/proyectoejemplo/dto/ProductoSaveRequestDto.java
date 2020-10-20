package es.correos.soporte.minerva.proyectoejemplo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoSaveRequestDto {

	
	private Integer proveedorid;
	private Integer categoriaid;
	private String descripcion ;
	private Double preciounit ;
	private Integer existencia;
}
