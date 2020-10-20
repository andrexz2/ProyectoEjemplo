package es.correos.soporte.minerva.proyectoejemplo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;
import es.correos.soporte.minerva.proyectoejemplo.exceptions.PlayerNotFoundException;
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
	public Producto save(Producto producto) throws PlayerNotFoundException {
		return productoRepository.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) throws PlayerNotFoundException {
		Optional<Producto> result= productoRepository.findById(producto.getProductoid());
		if(!result.isPresent()){
			throw new PlayerNotFoundException("El producto no se ha registrado");
		}
		return productoRepository.save(producto);
	}

	@Override
	public Producto eliminar(Producto producto) throws PlayerNotFoundException  {
		Producto productoObj = productoRepository.findById(producto.getProductoid()).orElse(null);
		if(productoObj != null) {
				throw new PlayerNotFoundException("Producto eliminado, con el id : " + productoObj.getProductoid());
			}
		return productoRepository.save(productoObj);
		//return orderRepository.save(orderObj);

				//.findById(order.getId()).orElse(null);
		
		
	}
	
	

}
