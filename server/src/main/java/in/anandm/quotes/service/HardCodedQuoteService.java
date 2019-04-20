package in.anandm.quotes.service;

import in.anandm.quotes.model.Quote;

public class HardCodedQuoteService implements QuoteService {

	private Quote quote;
	
	public HardCodedQuoteService(Quote quote) {
		super();
		this.quote = quote;
	}

	@Override
	public Quote getRandomQuote() {
		
		return quote;
	}

}
