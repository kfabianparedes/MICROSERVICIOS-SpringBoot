package pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.entity.Cliente;
import pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.service.ClienteService;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService=clienteService;
		
	}
	@GetMapping
	public ResponseEntity<?> findAll(){
		return  ResponseEntity.ok(clienteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(clienteService.findById(id));
	};
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente producto ){
		return  ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(producto));
	}

}
