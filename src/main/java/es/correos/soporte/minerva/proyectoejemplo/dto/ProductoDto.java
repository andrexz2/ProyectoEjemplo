package es.correos.soporte.minerva.proyectoejemplo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductoDto {
	
	private Integer productoid  ;
	private Integer proveedorid;
	private Integer categoriaid;
	private String descripcion ;
	private Double preciounit ;
	private Integer existencia;
	
	
	
}
