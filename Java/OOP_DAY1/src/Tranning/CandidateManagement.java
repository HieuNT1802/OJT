package Tranning;

public class CandidateManagement {

	
	public Candidate[] creatCandidate() {
		Candidate ca = new Candidate(01,"Trung Hieu","Male","04/06/2001","hieunt1@gmail.com",5.0);
		//Candidate[] arrayCandidate = new Candidate[1];
		Candidate[] arCandidates = {ca};
		return  arCandidates ;
		
	}
	public void Display(Candidate[] arCandidates) {
		for(Candidate arrCandidate : arCandidates) {
			System.out.println(arrCandidate);
		}
	}
	
	public static void main(String[] args) {
		CandidateManagement cm = new CandidateManagement();
		Candidate[] candidates = cm.creatCandidate();
		cm.Display(candidates);
	}
}
