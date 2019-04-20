package in.anandm.quotes.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.anandm.quotes.model.Quote;
import in.anandm.quotes.service.QuoteService;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

	@Autowired
	private QuoteService quoteService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@GetMapping("/random")
	public Quote getRandomQuote() {
		return quoteService.getRandomQuote();
	}
	
	@GetMapping("/aMillionQuotes")
	public StreamingResponseBody getAmillionQuotes() {
		int million = 10000;
		return new StreamingResponseBody() {
			
			@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				outputStream.write("[".getBytes());
				for(int i = 0; i < million; i++) {
					byte[] chunk = objectMapper.writeValueAsBytes(quoteService.getRandomQuote());
					
					outputStream.write(chunk);
					if(i < million - 1) {
						outputStream.write(",".getBytes());
					}
					
					outputStream.flush();
					
				}
				outputStream.write("]".getBytes());
				
			}
		};
	}
	
}
