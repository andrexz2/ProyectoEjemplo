package es.correos.soporte.minerva.proyectoejemplo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoDto;
import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerNotFoundException;
import es.correos.soporte.minerva.proyectoejemplo.mapper.ProductoMapper;
import es.correos.soporte.minerva.proyectoejemplo.repository.IProductoRepository;
import es.correos.soporte.minerva.proyectoejemplo.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {
		List<Producto> lista = productoRepository.findAll();
		return lista;
	}
	
	@Override
	public Producto findById(Integer id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}


	@Override
	public void deleteById  (Integer id)  {
		productoRepository.deleteById(id);
	
	}

	@Override
	public Producto update(Producto producto) {
		return productoRepository.saveAndFlush(producto);
		
		//teamRepository.saveAndFlush(playerMapper.playerDtoToPlayer(player));
	}
	
	     //@Override
		 //public void eliminar(Integer id) {
	    	// productoRepository.deleteById(id);
		//}
	

}
