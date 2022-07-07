package fa.training.sms;

public class BookAdoption {
	
	private String AdoptDate;
	Course course;
	Book bk;
	
	public BookAdoption(String adoptDate, Course course, Book bk) {
		super();
		this.AdoptDate = adoptDate;
		this.course = course;
		this.bk = bk;
	}
	

	public String getAdoptDate() {
		return AdoptDate;
	}


	public void setAdoptDate(String adoptDate) {
		AdoptDate = adoptDate;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Book getBk() {
		return bk;
	}


	public void setBk(Book bk) {
		this.bk = bk;
	}


	@Override
	public String toString() {
		return "BookAdoption [AdoptDate=" + AdoptDate + ", course=" + course.getCourseId() + ", bk=" + bk.getISBN() + "]";
	}
	
}
