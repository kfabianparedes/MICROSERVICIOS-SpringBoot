package pe.edu.galaxy.training.java.ms.pedidos.gestion.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AppMSClientes {

	public static void main(String[] args) {
		SpringApplication.run(AppMSClientes.class, args);
	}

}
