package fa.training.entities;

import java.util.Date;

public class Magazine extends Publication{
 private String author;
 private int volumn;
 private int edition;
 
	
	
	public Magazine() {
	super();
	// TODO Auto-generated constructor stub
}



public Magazine(int pubicationYear, String publisher, Date publicationDate) {
	super(pubicationYear, publisher, publicationDate);
	// TODO Auto-generated constructor stub
}



	public Magazine(int pubicationYear, String publisher, Date publicationDate, String author, int volumn, int edition) {
	super(pubicationYear, publisher, publicationDate);
	this.author = author;
	this.volumn = volumn;
	this.edition = edition;
}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getVolumn() {
		return volumn;
	}



	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}



	public int getEdition() {
		return edition;
	}



	public void setEdition(int edition) {
		this.edition = edition;
	}



	@Override
	public String toString() {
		return "Magazine [author=" + author + ", volumn=" + volumn + ", edition=" + edition + "]";
	}



	@Override
	public void display() {
		
		
	}

}
