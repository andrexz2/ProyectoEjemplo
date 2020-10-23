package es.correos.soporte.minerva.proyectoejemplo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
 @Entity
 @Table(name="ordenes")
public class Orden implements Serializable  {
	
	private static final long serialVersionUID = 126228098094713005L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "ord_generator")
	 @SequenceGenerator(name = "ord_generator" ,sequenceName = "seq_ordenincremento" )
	@Column(name="ordenid")
	private Integer ordenid ;
	
	@Column(name = "empleadoid")
	private Integer empleadoid ;
	
	@Column(name="clienteid")
	private Integer clienteid ;
	
	//@JoinColumn(name = "FK_DETALLE__ORDEN_DET_ORDENES", nullable = false)
	//@JoinColumn(name = "ordenid") 
	//@ManyToOne (fetch = FetchType.LAZY)
    //private DetalleOrden DetalleOrdenes;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "ordenid", foreignKey = @ForeignKey(name = "FK_DETALLE__ORDEN_DET_ORDENES"))
	private List<DetalleOrden> detallesOrdenes;
	
	
	@Column(name="fechaorden")
	@Temporal(TemporalType.DATE)
	private Date fechaorden ;
	
	@Column(name = "descuento")
	private Integer descuento ;
  

}
