package es.correos.soporte.minerva.proyectoejemplo.domain;

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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="detalle_ordenes")
public class DetalleOrden {

	
	@Id
	@Column(name="detalleid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer detalleid ;
	
	//@OneToMany(mappedBy = "DetalleOrden", cascade = CascadeType.ALL)
     //@JoinColumn(name = "fk_detalle__orden_det_ordenes")
	//private List <Orden> Ordenes;
	
    //@OneToMany(mappedBy = "DetalleOrden" , cascade = CascadeType.ALL)
    //@JoinColumn(name = "ordenid")
	//@ManyToOne
    //private  Producto Productos;
	
	@Column(name="cantidad" )
	private Integer cantidad ;

}
