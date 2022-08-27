package in.satish.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClientServiceApp {
   
	private String apiUrl = "http://localhost:9090/";
	
	public void invokeSecuredApi() {
		
		RestTemplate rt = new RestTemplate();
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setBasicAuth("satish", "Satish@123");
		HttpEntity<String> reqEntity = new HttpEntity<>(headers);
		ResponseEntity<String> entity = rt.exchange(apiUrl, HttpMethod.GET, reqEntity, String.class);
		String body = entity.getBody();
		System.out.println(body);
		
	}
	
	public void getSecuredApi() {
		WebClient create = WebClient.create();
				String block = create.get() // this is the get request
					.uri(apiUrl)
					.headers(headers -> headers.setBasicAuth("satish", "Satish@123"))
					.retrieve()
					.bodyToMono(String.class)
					.block(); // this told as Synchronous 
		System.out.println(block);
	}
}
