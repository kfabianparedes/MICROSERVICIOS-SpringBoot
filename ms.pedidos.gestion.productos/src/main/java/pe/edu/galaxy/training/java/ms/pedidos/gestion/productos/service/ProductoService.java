package pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.service;

import java.util.List;
import pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.entity.Producto;

public interface ProductoService {

	List<Producto> findAll();
	
	Producto save(Producto producto);
}
