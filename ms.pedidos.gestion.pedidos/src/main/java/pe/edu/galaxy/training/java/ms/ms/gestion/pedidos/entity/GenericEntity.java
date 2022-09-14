package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public class GenericEntity {

	@Column(name = "ESTADO")
	@Builder.Default
	private String estado="1";	
}

