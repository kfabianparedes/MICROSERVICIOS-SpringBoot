package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service.client;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClienteServiceImpl implements ClienteService{

	
	private DiscoveryClient discoveryClient;
	
	private RestTemplate restTemplate;

	private String url="ms-ventas-gestion-clientes";
	private String uri;

	//private String url_h="localhost:8082/v1/clientes";
	
	//private String url_r="lb://MS-VENTAS-GESTION-CLIENTES"

	// Resilencia
	private CircuitBreaker circuitBreaker;

	public ClienteServiceImpl (RestTemplate restTemplate, DiscoveryClient discoveryClient, CircuitBreakerFactory<?, ?> circuitBreakerFactory) {
		this.restTemplate = restTemplate;
		this.discoveryClient=discoveryClient;
		//log.info("this.getURI() "+this.getURI());
		this.circuitBreaker = circuitBreakerFactory.create("ms-ventas-gestion-clientes");
	}

	@Override
	public ClienteDTO findById(Long id) throws ClientException {

		this.uri = this.getURI();
		if(Objects.isNull(uri)){
			return null;
		}
		/*// Sin resilencia
		ResponseEntity<ClienteDTO> rEClienteDTO=restTemplate.getForEntity(this.uri+"/v1/clientes/"+id, ClienteDTO.class);

		if (!Objects.isNull(rEClienteDTO)) {
//			return rEClienteDTO.getBody().getData();
			return rEClienteDTO.getBody();
		}
		return null;*/

		// Con resilencia
		return circuitBreaker.run(
			() -> {
				// Plan A
				ResponseEntity<ClienteDTO> rEClienteDTO=restTemplate.getForEntity(this.uri+"/v1/clientes/"+id, ClienteDTO.class);
				//return rEClienteDTO.getBody().getData();
				return rEClienteDTO.getBody();
			},throwable -> getClienteDTO()
		);
	}
	
	private ClienteDTO getClienteDTO() {
		return ClienteDTO.builder().id(0L).razonSocial("Cliente por definir").ruc("99999999999").build();
		// Plan B
		/*return circuitBreaker.run(() -> {
				// Ok
				log.info("this.getURI() "+this.getURI());
				return null;
			},
			throwable -> { //Error
				log.info("this.getURI() " + this.getURI())
				return null;
			}
			// Plan C
		);*/
	}
	
	
	private String getURI() {
		if (Objects.isNull(discoveryClient)) {
			log.info("DiscoveryClient is null");
			return "";
		}
		List<ServiceInstance> instances = discoveryClient.getInstances(url);
		if (Objects.isNull(instances) || instances.isEmpty()){
			log.info("Instances are null");
			return "";
		}
		System.out.println(instances.get(0).getHost());
		String uri=instances.get(0).getUri().toString();		
		log.info("uri: " +uri);
		return uri;
	}

}
