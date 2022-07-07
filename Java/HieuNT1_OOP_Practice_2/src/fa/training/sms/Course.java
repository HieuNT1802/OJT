package fa.training.sms;

public class Course {
private String courseId;
private String cname;
private String dept;
public Course(String courseId, String cname, String dept) {
	
	this.courseId = courseId;
	this.cname = cname;
	this.dept = dept;
}
public Course() {
}
public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
@Override
public String toString() {
	return "Course [courseId=" + courseId + ", cname=" + cname + ", dept=" + dept + "]";
}

}
