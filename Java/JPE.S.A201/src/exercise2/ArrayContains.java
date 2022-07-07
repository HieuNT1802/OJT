package exercise2;

public class ArrayContains {

	public static void main(String[] args) {
		String[] stringArray = {"FTP","Fresher", "Acedemy", "2018"};
		boolean find = false;
		String sValue = "Fresher";
		for (int i = 0; i < stringArray.length; i++) {
			if(sValue.equals(stringArray[i])) {
				find = true; 
				 break;
			}
			}
		if(find)
			System.out.println("Check "+"'"+sValue +"'"+ "in Array: Contained!");
			else
			System.out.println("Check "+"'"+sValue +"'"+ "in Array: Not Contain");
			}
		
	}


