package pe.edu.galaxy.training.java.ms.pedidos.gestion.productos.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
  	@Column(name = "ID_PRODUCTO")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProducto")
    @SequenceGenerator(sequenceName = "SEQ_PRODUCTO", allocationSize = 1, name = "seqProducto")
	private Long id;
  
  	@NotNull(message = "Nombre del producto es requerido")
  	@Size(min = 5, max = 120, message = "El nombre.....")
  	@Column(name = "NOMBRE")
  	private String nombre;
  	
  	@Column(name = "DESCRIPCION")
  	private String descripcion;

  	@Column(name = "PRECIO")
  	private Double precio;

  	@Column(name = "STOCK")
  	private Double stock;

  	@Column(name = "ESTADO")
  	private String estado;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Producto producto = (Producto) o;
		return id != null && Objects.equals(id, producto.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
