package es.correos.soporte.minerva.proyectoejemplo.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
 
@Data
 @Entity
 @Table(name="ordenes")
public class Orden {
	
	
	@Id
	@Column(name="ordenid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ordenid ;
	
	@Column(name = "empleadoid")
	private Integer empleadoid ;
	
	@Column(name="clienteid")
	private Integer clienteid ;
	
	//@JoinColumn(name = "FK_DETALLE__ORDEN_DET_ORDENES", nullable = false)
	//@JoinColumn(name = "ordenid") 
	//@ManyToOne (fetch = FetchType.LAZY)
    //private DetalleOrden DetalleOrdenes;
	
	@Column(name="fechaorden")
	@Temporal(TemporalType.DATE)
	private Date fechaorden ;
	
	@Column(name = "descuento")
	private Integer descuento ;
  

}
