package in.anandm.quotes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import in.anandm.quotes.model.Quote;
import in.anandm.quotes.service.HardCodedQuoteService;
import in.anandm.quotes.service.QuoteService;

@Configuration
@PropertySource(value = { "classpath:app.properties" })
@ComponentScan(basePackages = { "in.anandm.quotes.aspect" })
public class AppConfig {

	@Value(value = "${serviceURL}")
	private String serviceURL;

//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	@Bean
	public QuoteService quoteService() {
		return new HardCodedQuoteService(
				new Quote("I think in terms of the day's resolutions, not the years", "Henry Moore"));
	}
}
