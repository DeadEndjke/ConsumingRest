package ConsumingRESTfulWebService.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingResTfulWebServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingResTfulWebServiceApplication.class);
	public static void main(String[] args) {
		log.info("in main method");
		SpringApplication.run(ConsumingResTfulWebServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Activity activity = restTemplate.getForObject(
					"https://www.boredapi.com/api/activity", Activity.class);
			log.info(activity.toString());
		};
	}

}
