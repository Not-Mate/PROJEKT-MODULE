package ch.bztf.weatherapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient webClient;
    private final String apiKey;

    public WeatherService(WebClient.Builder webClientBuilder, @Value("${weather.api.key}") String apiKey) {
        this.webClient = webClientBuilder.baseUrl("http://api.openweathermap.org").build();
        this.apiKey = apiKey;
    }

    public class WeatherApi {
        public void getWeatherData(double lat, double lon) {
            Mono<String> response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/data/3.0/onecall")
                            .queryParam("lat", lat)
                            .queryParam("lon", lon)
                            .queryParam("appid", apiKey)
                            .build())
                    .retrieve()
                    .bodyToMono(String.class);

            response.subscribe(System.out::println);
        }
    }

    public WeatherApi getWeatherApi() {
        return new WeatherApi();
    }
}
