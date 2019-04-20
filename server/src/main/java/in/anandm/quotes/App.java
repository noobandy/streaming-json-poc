package in.anandm.quotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import in.anandm.quotes.config.APIConfig;
import in.anandm.quotes.config.AppConfig;
import in.anandm.quotes.config.WebConfig;

/**
 * Hello world!
 *
 */
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@Configuration
@EnableConfigurationProperties(APIConfig.class)
@Import(value={AppConfig.class, WebConfig.class})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
