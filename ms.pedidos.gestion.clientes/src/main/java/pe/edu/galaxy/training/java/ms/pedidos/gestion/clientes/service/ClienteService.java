package pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.service;

import java.util.List;
import java.util.Optional;

import pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.entity.Cliente;

public interface ClienteService {

	List<Cliente> findAll();
	Optional<Cliente> findById(Long id);
	Cliente save(Cliente cliente);
}
