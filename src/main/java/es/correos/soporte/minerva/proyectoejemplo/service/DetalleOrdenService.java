package es.correos.soporte.minerva.proyectoejemplo.service;

import java.util.List;

import es.correos.soporte.minerva.proyectoejemplo.domain.DetalleOrden;
import es.correos.soporte.minerva.proyectoejemplo.domain.Orden;

public interface DetalleOrdenService {
	
	public List<DetalleOrden> findAll();
	
	public DetalleOrden findById (Integer id);
	
    public DetalleOrden save (DetalleOrden DetalleOrden);	
    
    public DetalleOrden update (DetalleOrden DetalleOrden);
    
    public void deleteById (Integer id);

}
