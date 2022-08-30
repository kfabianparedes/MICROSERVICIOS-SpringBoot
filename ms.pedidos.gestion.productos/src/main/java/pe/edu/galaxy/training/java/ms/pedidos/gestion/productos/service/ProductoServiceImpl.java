package pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.entity.Producto;
import pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private ProductoRepository productoRepository;
	
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository=productoRepository;
	}

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

}
