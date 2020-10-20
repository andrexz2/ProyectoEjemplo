package es.correos.soporte.minerva.proyectoejemplo.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ModificaProductoRequestDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ModificaProductoResponseDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoSaveRequestDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoSaveResponseDto;

import es.correos.soporte.minerva.proyectoejemplo.dto.RemoveProductoRequestDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.RemoveProductoResponseDto;

@Mapper
public interface ProductoMapper {
	
	ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);
	
    public ProductoDto map(Producto producto);
    
    public List<ProductoDto> toProductoDto (List<Producto> producto);
    
    public Producto toEntity(ProductoSaveRequestDto productoSaveRequestDto);
    
    public ProductoSaveResponseDto toProductSaveResponseDto(Producto producto);

    public Producto toEntityRemove(RemoveProductoRequestDto producto);

	public RemoveProductoResponseDto toRemoveProductoResponseDto(Producto producto);
	
	public ModificaProductoResponseDto toModificaProductoResponseDto (Producto producto);
	
	public Producto toEntityModifica (ModificaProductoRequestDto producto);
	


    
    //public ProductoDto toSaveProducto(Producto producto);
    
   // public ProductoDto toModificarProducto (Producto producto);
    
    //public ProductoDto toEliminarProducto (Producto producto);

}
