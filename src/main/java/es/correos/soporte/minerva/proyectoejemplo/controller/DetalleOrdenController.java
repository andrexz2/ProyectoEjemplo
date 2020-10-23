package es.correos.soporte.minerva.proyectoejemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.correos.soporte.minerva.proyectoejemplo.domain.DetalleOrden;
import es.correos.soporte.minerva.proyectoejemplo.domain.Orden;
import es.correos.soporte.minerva.proyectoejemplo.service.DetalleOrdenService;
import es.correos.soporte.minerva.proyectoejemplo.service.OrdenService;
import es.correos.soporte.minerva.proyectoejemplo.service.ProductoService;

@RestController
public class DetalleOrdenController {
	
	@Autowired
	private DetalleOrdenService detalleOrden;
	
	@Autowired
	private OrdenService ordenservice;
	
	@Autowired
	private ProductoService productoservice;
	
	
	@GetMapping("detalle/listar")
	public List <DetalleOrden> listar() 
	{
		System.out.println("detalle");
		return  detalleOrden.findAll();
	}
	
	@GetMapping("detalle/{id}")
	public DetalleOrden findById (@PathVariable ("id")  Integer id) {
		return detalleOrden.findById(id);
	}

	 /*@PostMapping("/save")
	  public  DetalleOrden save (@RequestBody DetalleOrden DetalleOrden)
	 {
 	  return detalleOrden.save(DetalleOrden);
   } */
	
	@DeleteMapping("/borrar/{id}")
    public void eliminar (@PathVariable Integer id) {
		detalleOrden.deleteById(id);
    }
	
	 @PutMapping("/Actualizar/{id}")
     public DetalleOrden update (@RequestBody DetalleOrden DetalleOrden, @PathVariable Integer id )
     {
		 DetalleOrden detalleOrdenDb = detalleOrden.findById(id);
     	
		  detalleOrdenDb.setCantidad(DetalleOrden.getCantidad());
		 //detalleOrdenDb.setOrdenid(orden.getOrdenid());

     	return detalleOrden.save(detalleOrdenDb);
     }
}
