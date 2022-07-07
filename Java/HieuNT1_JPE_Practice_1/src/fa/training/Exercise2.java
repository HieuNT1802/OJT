package fa.training;

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	int len = Integer.parseInt(input.nextLine());
	String[] calo = new String[len];
	int sum =0;
	for(int i =0;i<calo.length;i++) {
		calo[i]=input.nextLine();
     if(calo[i].startsWith("c")) {
			sum +=500;
	} else if(calo[i].startsWith("t")) {
		sum +=150;
	} else if(calo[i].startsWith("s")) {
		sum +=600;
	}else if(calo[i].startsWith("p")) {
		sum +=50;
	} else {
		sum+=0;
	}
	}
	 System.out.println(sum);
	}

}
