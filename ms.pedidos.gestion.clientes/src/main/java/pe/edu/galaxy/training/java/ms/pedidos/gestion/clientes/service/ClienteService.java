package pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.service;

import java.util.List;

import pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.entity.Cliente;

public interface ClienteService {

	List<Cliente> findAll();
	
	Cliente save(Cliente cliente);
}
