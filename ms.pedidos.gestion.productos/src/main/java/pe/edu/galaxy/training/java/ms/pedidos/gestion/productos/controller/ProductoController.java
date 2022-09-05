package pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.entity.Producto;
import pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.service.ProductoService;

@RestController
@RequestMapping("/v1/productos")
public class ProductoController {
	
	private final ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService=productoService;
		
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return  ResponseEntity.ok(productoService.findAll());
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Producto producto ){
		return  ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
	}

}
