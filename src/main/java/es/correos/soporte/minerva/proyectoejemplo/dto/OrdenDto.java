package es.correos.soporte.minerva.proyectoejemplo.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrdenDto {
	
	   private Integer ordenid ;
	   private Integer empleadoid ;
	   private Integer clienteid ;
	   private Date   fechaorden ;
	   private Integer descuento ;
	   
	   List<DetalleOrdenesDto> detalles;

}
