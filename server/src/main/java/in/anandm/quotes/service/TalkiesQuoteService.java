package in.anandm.quotes.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.anandm.quotes.aspect.QuoteCache;
import in.anandm.quotes.model.Quote;

public class TalkiesQuoteService implements QuoteService {

	private RestTemplate client;
	private String serviceURL;

	public TalkiesQuoteService(RestTemplate client, String serviceURL) {
		super();
		this.client = client;
		this.serviceURL = serviceURL;
	}

	@QuoteCache
	@Override
	public Quote getRandomQuote() {
		System.out.println("Remote call");
		ResponseEntity<Quote> response = client.getForEntity(serviceURL, Quote.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new QuoteServiceException("Quote service error");
		}

	}

}
