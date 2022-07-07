package Tranning;

public class Candidate {
   public int id;
   public String name;
   public String gender;
   public String birthDate;
   public String email;
   public Double gpa;
	
	
	
	public Candidate(int id, String name, String gender, String birthDate, String email, Double gpa) {
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.birthDate = birthDate;
	this.email = email;
	this.gpa = gpa;
}



	public Candidate() {
		
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", gender=" + gender + ", birthDate=" + birthDate + ", email="
				+ email + ", gpa=" + gpa + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
