package fa.training.sms;

public class Enroll {
//private String ssn;
//private String courseId;
private String enrollDate;
private int grade;
Student student;
Course course;
public Enroll() {
	super();
	// TODO Auto-generated constructor stub
}
public Enroll(String enrollDate, int grade, Student student, Course course) {
	super();
	this.enrollDate = enrollDate;
	this.grade = grade;
	this.student = student;
	this.course = course;
}
public String getEnrollDate() {
	return enrollDate;
}
public void setEnrollDate(String enrollDate) {
	this.enrollDate = enrollDate;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
@Override
public String toString() {
	return "Enroll [enrollDate=" + enrollDate + ", grade=" + grade + ", student=" + student.getSsn() + ", course=" + course.getCourseId()
			+ "]";
}


}
