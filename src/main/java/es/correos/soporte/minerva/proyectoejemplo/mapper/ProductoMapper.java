package es.correos.soporte.minerva.proyectoejemplo.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;

import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoDto;



@Mapper
public interface ProductoMapper {
	
	ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);
	
    public ProductoDto map(Producto producto);
    
    public List<ProductoDto> toProductoDto (List<Producto> producto);
    
    
	


    
    //public ProductoDto toSaveProducto(Producto producto);
    
   // public ProductoDto toModificarProducto (Producto producto);
    
    //public ProductoDto toEliminarProducto (Producto producto);

}
