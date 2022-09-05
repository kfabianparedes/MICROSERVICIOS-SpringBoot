package pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.service;

import java.util.List;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.entity.Cliente;
import pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository=clienteRepository;
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente save(Cliente producto) {
		return clienteRepository.save(producto);
	}

}
