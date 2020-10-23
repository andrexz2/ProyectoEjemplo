package es.correos.soporte.minerva.proyectoejemplo.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.correos.soporte.minerva.proyectoejemplo.domain.Orden;
import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;
import es.correos.soporte.minerva.proyectoejemplo.dto.OrdenDto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoDto;

@Mapper
public interface OrdenMapper {
	

	OrdenMapper INSTANCE = Mappers.getMapper(OrdenMapper.class);
	
	@Mapping(source = "detallesOrdenes", target = "detalles")
    public OrdenDto map(Orden orden);
    
	@IterableMapping(elementTargetType = OrdenDto.class)
    public List<OrdenDto> toOrdenDto (List<Orden> orden);
    
}
