package in.anandm.quotes.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="")
public class APIConfig {

	private Map<String, Object> api;

	public APIConfig() {
		super();
		api = new HashMap<>();
	}

	public Map<String, Object> getApi() {
		return api;
	}

	public void setApi(Map<String, Object> api) {
		this.api = api;
	}

	@Override
	public String toString() {
		return "APIConfig [api=" + api + "]";
	}	
}
