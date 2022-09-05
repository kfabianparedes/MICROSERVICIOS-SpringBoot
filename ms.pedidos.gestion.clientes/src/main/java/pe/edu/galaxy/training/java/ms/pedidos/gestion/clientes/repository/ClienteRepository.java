package pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
