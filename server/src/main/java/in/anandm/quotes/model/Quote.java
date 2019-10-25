package in.anandm.quotes.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="quote")
public class Quote {

	// @XmlElement(name="quote", type=String.class)
	// private String quote;
	// @XmlElement(name="author", type=String.class)
	// private String author;
	

	private int id;
	private String name;
	private String address;
	private String comment;

	public Quote() {
		super();
	}
	

	public Quote(int id, String name,String address,String comment) {
		this();
		this.id = id;
		this.name = name;
		this.address=address;
		this.comment=comment;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	
	
}
