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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="detalle_ordenes")
public class DetalleOrden {

	
	@Id
	@Column(name="detalleid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "ordt_generator")
	 @SequenceGenerator(name = "ordt_generator" ,sequenceName = "seq_ordendtincremento")
	private Integer detalleid ;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "ordenid", foreignKey = @ForeignKey(name = "FK_DETALLE__ORDEN_DET_ORDENES"))
//	private Orden orden;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	  @JoinColumn(
//	      name = "ORDENID ",
//	      referencedColumnName = "ORDENID",
//	      foreignKey = @ForeignKey(name = "FK_DETALLE__ORDEN_DET_ORDENES"))
//	  private  Orden Ordenes;
	 //@ManyToOne(fetch = FetchType.LAZY)
	 //private Producto producto;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	  @JoinColumn(
//	      name = "PRODUCTOID ",
//	      referencedColumnName = "PRODUCTOID",
//	      c
//	  private  Producto Productos;
	  
	@Column(name="cantidad" )
	private Integer cantidad ;

}
