package info.caprese.macaronibot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;


@SpringBootApplication
@EnableScheduling
public class MacaroniBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacaroniBotApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		return restTemplateBuilder.build();
	}

	@Bean
	private Twitter twitter() {
		return new TwitterFactory().getInstance();
	}
}
