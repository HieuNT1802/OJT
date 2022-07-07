package fa.training.assignment_802.entities;

import java.sql.Date;

public abstract class Publication {
	private int publicationYear;
	private String publisher;
	private Date publicationDate;
	
	public Publication() {
		// TODO Auto-generated constructor stub
	}

	public Publication(int publicationYear, String publisher, Date publicationDate) {
		super();
		this.publicationYear = publicationYear;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
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
	
	abstract void display();
}
