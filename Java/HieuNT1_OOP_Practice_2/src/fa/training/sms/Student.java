package fa.training.sms;

public class Student {
private int ssn;
private String name;
private String major;
private String birthDate;
public Student(int ssn, String name, String major, String birthDate) {
	this.ssn = ssn;
	this.name = name;
	this.major = major;
	this.birthDate = birthDate;
}
public Student() {
	
}
public int getSsn() {
	return ssn;
}
public void setSsn(int ssn) {
	this.ssn = ssn;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public String getBirthDate() {
	return birthDate;
}
public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
}
@Override
public String toString() {
	return "Student [ssn=" + ssn + ", name=" + name + ", major=" + major + ", birthDate=" + birthDate + "]";
}

}
