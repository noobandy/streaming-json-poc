package in.anandm.quotes.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="quote")
public class Quote {

	@XmlElement(name="quote", type=String.class)
	private String quote;
	@XmlElement(name="author", type=String.class)
	private String author;
	
	public Quote() {
		super();
	}
	

	public Quote(String quote, String author) {
		this();
		this.quote = quote;
		this.author = author;
	}


	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
}
