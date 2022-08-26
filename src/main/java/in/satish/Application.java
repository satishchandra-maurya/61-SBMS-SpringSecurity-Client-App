package in.satish;

import java.net.http.HttpHeaders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		String apiUrl = "http://localhost:9090/";
		
		String username = "satish";
		String password = "Satish@123";
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setBasicAuth(username, password);
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> forEntity = rt.exchange(apiUrl, HttpMethod.GET, request, String.class);
		String body = forEntity.getBody();
		System.out.println(body);
		
	}

}
