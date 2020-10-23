package es.correos.soporte.minerva.proyectoejemplo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.correos.soporte.minerva.proyectoejemplo.domain.DetalleOrden;
import es.correos.soporte.minerva.proyectoejemplo.repository.IDetalleOrdenRepository;
import es.correos.soporte.minerva.proyectoejemplo.repository.IOrdenRepository;
import es.correos.soporte.minerva.proyectoejemplo.service.DetalleOrdenService;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService {

	@Autowired
	private  IDetalleOrdenRepository detallerepository;
	
	@Autowired
	private IOrdenRepository ordenrepository;
	
	@Override
	public List<DetalleOrden> findAll() {
		List <DetalleOrden> lista = detallerepository.findAll(); 
		return lista;
	}

	@Override
	public DetalleOrden findById(Integer id) {
		return detallerepository.findById(id).orElse(null);
	}

	@Override
	public DetalleOrden save(DetalleOrden DetalleOrden) {
		return detallerepository.save(DetalleOrden);
	}

	@Override
	public DetalleOrden update(DetalleOrden DetalleOrden) {
		
		return detallerepository.saveAndFlush(DetalleOrden);
	}

	@Override
	public void deleteById(Integer id) {
		detallerepository.deleteById(id);
		
	}

}
