package in.satish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import in.satish.service.ClientServiceApp;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		ClientServiceApp bean = run.getBean(ClientServiceApp.class);
		//bean.invokeSecuredApi();
		bean.getSecuredApi();
	}

}
