package fa.training.entities;

import java.util.Date;

public abstract class Publication {
  private int pubicationYear;
  private String publisher;
  private Date publicationDate;
public Publication(int pubicationYear, String publisher, Date publicationDate) {
	super();
	this.pubicationYear = pubicationYear;
	this.publisher = publisher;
	this.publicationDate = publicationDate;
}
public Publication() {
	super();
	// TODO Auto-generated constructor stub
}
public int getPubicationYear() {
	return pubicationYear;
}
public void setPubicationYear(int pubicationYear) {
	this.pubicationYear = pubicationYear;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public Date getPublicationDate() {
	return publicationDate;
}
public void setPublicationDate(Date publicationDate) {
	this.publicationDate = publicationDate;
}
@Override
public String toString() {
	return "Publication [pubicationYear=" + pubicationYear + ", publisher=" + publisher + ", publicationDate="
			+ publicationDate + "]";
}
  public abstract void display();
}
