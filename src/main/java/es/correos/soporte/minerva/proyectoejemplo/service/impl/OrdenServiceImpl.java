package es.correos.soporte.minerva.proyectoejemplo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.correos.soporte.minerva.proyectoejemplo.domain.Orden;
import es.correos.soporte.minerva.proyectoejemplo.repository.IOrdenRepository;
import es.correos.soporte.minerva.proyectoejemplo.repository.IProductoRepository;
import es.correos.soporte.minerva.proyectoejemplo.service.OrdenService;


@Service
public class OrdenServiceImpl  implements OrdenService{
	
	@Autowired
	private IOrdenRepository ordenRepository;

	@Override
	public List<Orden> findAll() {
		List<Orden> lista = ordenRepository.findAll();
		return lista ;
	}

	@Override
	public Orden findById(Integer id) {
		return ordenRepository.findById(id).orElse(null);
	}

	@Override
	public Orden save(Orden orden) {
		return ordenRepository.save(orden);
	}

	@Override
	public Orden update(Orden orden) {
		return ordenRepository.saveAndFlush(orden);
	}

	@Override
	public void deleteById(Integer id) {
		ordenRepository.deleteById(id);
	}

}
