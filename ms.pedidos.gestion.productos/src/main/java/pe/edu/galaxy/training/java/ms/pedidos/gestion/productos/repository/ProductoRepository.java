package pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
