package ch.bztf.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WeatherapiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WeatherapiApplication.class, args);
		WeatherService weatherService = context.getBean(WeatherService.class);
		WeatherService.WeatherApi weatherApi = weatherService.getWeatherApi();
		weatherApi.getWeatherData(47.6, 9.1);
	}

}
