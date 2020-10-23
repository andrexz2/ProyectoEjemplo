package es.correos.soporte.minerva.proyectoejemplo.service;

import java.util.List;

import es.correos.soporte.minerva.proyectoejemplo.domain.Orden;
import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;

public interface OrdenService {
	
	public List<Orden> findAll();
	
	public Orden findById(Integer id);
	
	public Orden save(Orden Orden) ;
	
    public Orden update (Orden Orden);
    
	public void deleteById (Integer id);

}
