package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "PEDIDO")
@Entity(name = "PedidoEntity")
public class PedidoEntity extends GenericEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPedido")
    @SequenceGenerator(sequenceName = "SEQ_PEDIDO", allocationSize = 1, name = "seqPedido")
	@Column(name = "ID_PEDIDO")
	private Long id;
	
	@Column(name = "ID_CLIENTE")
	private Long idCliente;
	
	@Column(name = "GLOSA")
	private String glosa;

	@Column(name = "FECHA_REGISTRO")
	private String fechaRegistro;

	@Column(name = "TOTAL")
	private Double total;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		PedidoEntity that = (PedidoEntity) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
