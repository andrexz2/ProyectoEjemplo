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
import javax.persistence.UniqueConstraint;

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
@Table(name="productos")
public class Producto implements Serializable{
	
 private static final long serialVersionUID = -2678606106269642358L;

 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "pro_generator")
 @SequenceGenerator(name = "pro_generator" ,sequenceName = "seq_productoincremento" )
 @Column(name = "productoid")
 private Integer productoid  ;
 
 @Column(name = "proveedorid")
 private Integer proveedorid ;
 
 @Column(name = "categoriaid")
 private Integer categoriaid ;
// 
   //@ManyToOne 
// //@JoinColumn(name = "fk_detalle__prod_deta_producto")
  //private  DetalleOrden DetalleOrden;
 @OneToMany( cascade = CascadeType.ALL , orphanRemoval = true)
 @JoinColumn(name = "productoid", foreignKey = @ForeignKey(name = "FK_DETALLE__PROD_DETA_PRODUCTO"))
 private List <DetalleOrden> detallesOrdenes;
 

 @Column(name = "descripcion", columnDefinition = "bpchar")
 private String descripcion ;
 
 @Column(name = "preciounit", columnDefinition = "numeric")
 private Double preciounit ;
 
 @Column(name = "existencia")
 private Integer existencia ;
 

}
