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

import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;

import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoDto;

import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerNotFoundException;
import es.correos.soporte.minerva.proyectoejemplo.mapper.ProductoMapper;
import es.correos.soporte.minerva.proyectoejemplo.service.ProductoService;

@RestController
public class ProductoController  {
	
	@Autowired
	private ProductoService productoservice;
	
	@GetMapping("producto/listar")
	public List<ProductoDto> list() {
		return ProductoMapper.INSTANCE.toProductoDto(productoservice.findAll());
	}
	
	@GetMapping("producto/{id}")
	public ProductoDto findById(@PathVariable("id") Integer id) throws PlayerNotFoundException {
		return ProductoMapper.INSTANCE.map(productoservice.findById(id));
	}
	
      @PostMapping("/crear")
	  public  Producto save (@RequestBody Producto producto)
	  {
    	  return productoservice.save(producto);
      }
      
        @DeleteMapping("/eliminar/{id}")
        public void eliminar (@PathVariable Integer id) {
        	productoservice.deleteById(id);
        }
     
        @PutMapping("/editar/{id}")
        public Producto update (@RequestBody Producto producto, @PathVariable Integer id )
        {
        	Producto productoDb = productoservice.findById(id);
        	
        	productoDb.setProveedorid(producto.getProveedorid());
        	productoDb.setCategoriaid(producto.getCategoriaid());
        	productoDb.setDescripcion(producto.getDescripcion());
        	productoDb.setPreciounit(producto.getPreciounit());
        	productoDb.setExistencia(producto.getExistencia());
        	return productoservice.save(productoDb);
        }
      
    //  @PutMapping("producto/modifica")
      //public ModificaProductoResponseDto modifica(@RequestBody ModificaProductoRequestDto modificaProductoRequestDto) throws PlayerNotFoundException{
    	//  return ProductoMapper.INSTANCE.toModificaProductoResponseDto(productoservice.modificar(ProductoMapper.INSTANCE.toEntityModifica(modificaProductoRequestDto)));
      //}
      
     
      
}
