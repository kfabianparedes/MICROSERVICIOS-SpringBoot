package pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_CLIENTE")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
  	@Column(name = "ID_CLIENTE")
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long id;
  
  	@NotNull(message = "La razón social  es requerida")
  	@Size(min = 5, max = 220, message = "La razón.....")
  	@Column(name = "RAZON_SOCIAL")
  	private String razonSocial;
  	
  	@Column(name = "RUC")
  	private String ruc;

  	@Column(name = "TELEFONO")
  	private String telefono;

  	//@Column(name = "ESTADO")
  	//private String estado;

}
