package es.correos.soporte.minerva.proyectoejemplo.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import es.correos.soporte.minerva.proyectoejemplo.domain.Producto;
import es.correos.soporte.minerva.proyectoejemplo.dto.ProductoDto;
import es.correos.soporte.minerva.proyectoejemplo.service.ProductoService;

@RunWith(MockitoJUnitRunner.class)
public class TestProductoController {
	
	
	@InjectMocks
	private ProductoController controller;
	
    @Mock
    private ProductoService service;
    
    @Test
    public void testList() {
    	
    	Producto producto1 = new Producto();
    	producto1.setProductoid(1);
    	producto1.setProveedorid(1);
    	producto1.setCategoriaid(1);
    	producto1.setDescripcion("1");
    	producto1.setPreciounit(1D);
    	producto1.setExistencia(1);
    	
    	Producto producto2 = new Producto();
    	producto1.setProductoid(1);
    	producto1.setProveedorid(2);
    	producto1.setCategoriaid(2);
    	producto1.setDescripcion("2");
    	producto1.setPreciounit(2D);
    	producto1.setExistencia(2);
    	
    List<Producto> productos = new ArrayList<>();
    productos.add(producto1);
    productos.add(producto2);
    when(service.findAll()).thenReturn(productos);
    
    List<ProductoDto> result = controller.list();
    
    assertEquals(2, result.size());
    
     //assertEquals(1, result.get(0).getProductoid());
	//assertEquals(1, result.get(0).getProveedorid());
	//assertEquals(1, result.get(0).getCategoriaid());
	//assertEquals("1", result.get(0).getDescripcion());
	//assertEquals(1D, result.get(0).getPreciounit());
	//ass
	
    }
    
    // @Test
    
    
    
}
