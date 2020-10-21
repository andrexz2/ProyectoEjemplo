package es.correos.soporte.minerva.proyectoejemplo.service;

import java.util.List;

import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;
import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerNotFoundException;

public interface ProductoService  {
	
	public List<Producto> findAll();
	public Producto findById(Integer id);
	public Producto save(Producto Producto) ;
    public Producto update (Producto Producto);
	public void deleteById (Integer id);
}
