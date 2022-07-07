package fa.training.entities;

public class Test {
	String s1 = "green mile";
	public void gR(int n) {
		String l = "";
		if(n>0) { l = "good"; }
		
		if(n<=0) {l = "bad";}
		
		System.out.println(s1+ "=" + l);
	}
	public static void main(String[] args) {
		int x, a = 6, b = 7;
		x = a++ + ++b;
		System.out.println(x);
	}
}
