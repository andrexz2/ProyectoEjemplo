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

import es.correos.soporte.minerva.proyectoejemplo.domain.Orden;
import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;
import es.correos.soporte.minerva.proyectoejemplo.dto.OrdenDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoDto;
import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerNotFoundException;
import es.correos.soporte.minerva.proyectoejemplo.mapper.OrdenMapper;
import es.correos.soporte.minerva.proyectoejemplo.mapper.ProductoMapper;
import es.correos.soporte.minerva.proyectoejemplo.service.OrdenService;

@RestController
public class OrdenController {
	
	@Autowired
	private OrdenService ordenesservice;
	
	@GetMapping("orden/listar")
	public List<OrdenDto> list() {
		List<Orden> ordenes = ordenesservice.findAll();
		return OrdenMapper.INSTANCE.toOrdenDto(ordenes);
	}
	
	@GetMapping("orden/{id}")
	public OrdenDto findById(@PathVariable("id") Integer id) throws PlayerNotFoundException {
		return OrdenMapper.INSTANCE.map(ordenesservice.findById(id));
	}
    
	  @PostMapping("/save")
	  public  Orden save (@RequestBody Orden orden)
	 {
   	  return ordenesservice.save(orden);
     }
	 
	 @DeleteMapping("/delete/{id}")
     public void eliminar (@PathVariable Integer id) {
		 ordenesservice.deleteById(id);
     }
	 
	 @PutMapping("/update/{id}")
     public Orden update (@RequestBody Orden orden, @PathVariable Integer id )
     {
     	Orden ordenDb = ordenesservice.findById(id);
     	
     	ordenDb.setOrdenid(orden.getOrdenid());
     	ordenDb.setEmpleadoid(orden.getEmpleadoid());
     	ordenDb.setClienteid(orden.getClienteid());
     	ordenDb.setFechaorden(orden.getFechaorden());
     	ordenDb.setDescuento(orden.getDescuento());
     	return ordenesservice.save(ordenDb);
     }
}
