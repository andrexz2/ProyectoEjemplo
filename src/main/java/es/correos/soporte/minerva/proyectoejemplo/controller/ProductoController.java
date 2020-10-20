package es.correos.soporte.minerva.proyectoejemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ModificaProductoRequestDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ModificaProductoResponseDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoSaveRequestDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoSaveResponseDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.RemoveProductoRequestDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.RemoveProductoResponseDto;
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
	
      @PostMapping("producto/save")
	  public  ProductoSaveResponseDto save(@RequestBody ProductoSaveRequestDto productoSaveRequestDto) throws PlayerNotFoundException {
		return ProductoMapper.INSTANCE.toProductSaveResponseDto(productoservice.save(ProductoMapper.INSTANCE.toEntity(productoSaveRequestDto)));

      }
      
      @PutMapping("producto/romove")
      public RemoveProductoResponseDto remove(@RequestBody RemoveProductoRequestDto removeProductoRequestDto) throws PlayerNotFoundException{
    	  return ProductoMapper.INSTANCE.toRemoveProductoResponseDto(productoservice.eliminar(ProductoMapper.INSTANCE.toEntityRemove(removeProductoRequestDto)));
      }
      
      
      @PutMapping("producto/modifica")
      public ModificaProductoResponseDto modifica(@RequestBody ModificaProductoRequestDto modificaProductoRequestDto) throws PlayerNotFoundException{
    	  return ProductoMapper.INSTANCE.toModificaProductoResponseDto(productoservice.modificar(ProductoMapper.INSTANCE.toEntityModifica(modificaProductoRequestDto)));
      }
      
      
      
}
