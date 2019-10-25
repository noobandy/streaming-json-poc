package in.anandm.quotes.controller;

import in.anandm.quotes.model.Quote;
import in.anandm.quotes.service.QuoteService;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

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

	public String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	@GetMapping("/list")
	public StreamingResponseBody getAmillionQuotes(
			@RequestParam(name = "totalRecords", required = false) Integer totoalRecords,
			@RequestParam(name = "chunkSize", required= false) Integer chunkSize) {

		totoalRecords = totoalRecords == null ? 10000 : totoalRecords;
		chunkSize = chunkSize == null ? totoalRecords / 100 : chunkSize;

		final int chunkSizeLocal = chunkSize;

		int loopCount = totoalRecords / chunkSize;

		return new StreamingResponseBody() {

			@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				int nextId = 1;

				outputStream.write("[".getBytes());
				for (int i = 0; i < loopCount; i++) {
					for (int j = 0; j < chunkSizeLocal; j++) {
						if(nextId > 1) {
							outputStream.write(",".getBytes());
						}
						byte[] quoteData = objectMapper
								.writeValueAsBytes(new Quote(nextId++,
										getAlphaNumericString(7),
										getAlphaNumericString(8),
										getAlphaNumericString(9)));
						outputStream.write(quoteData);
						
					}

					outputStream.flush();

				}
				outputStream.write("]".getBytes());

			}
		};
	}

}
