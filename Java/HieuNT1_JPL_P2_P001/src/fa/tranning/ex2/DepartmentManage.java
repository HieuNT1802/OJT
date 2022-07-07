package fa.tranning.ex2;



public class DepartmentManage {
	final static Validate iv = new Validate();
	void program() {
		while(true) {		
			System.out.println("1. Input data from the keyboard");
			System.out.println("2. Display employees");
			System.out.println("3. Classify employees");
			System.out.println("4. Employee Search");
			System.out.println("5. Report");	
			System.out.print("Please choose function you'd would like to do: ");
			int choice = iv.inputInt();
			switch (choice) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4: 
				
				break;
			case 5:
				
				break;
			case 6: 
				
				break;
			default:
				System.out.println("Dont have this choice!");
				break;
			}
		}
	}
public static void main(String[] args) {
	
}
}
