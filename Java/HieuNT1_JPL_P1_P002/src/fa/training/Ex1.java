package fa.training;
import java.util.Scanner;
 abstract class Shape {
	abstract double getArea();	 
    abstract double getPerimeter();
    abstract void input(Scanner in); 
    public abstract String toString();
}
	 class Triangle extends Shape {
	double a;
    double b;
    double c;
 
    @Override
    double getArea() {
        double p = this.getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
 
    @Override
    double getPerimeter() {
        return a + b + c;
    }

	@Override
	void input(Scanner in) {
		System.out.println("----Triangle--- ");
        System.out.println("Please input side A of Triangle: ");
        a = in.nextDouble();
        System.out.println("Please input side B of Triangle: ");
        b = in.nextDouble();
        System.out.println("Please input side C of Triangle: ");
        c = in.nextDouble();
	}

	@Override
	public String toString() {
		return "Area: " + getArea()+ "\nPermiter: " + getPerimeter();
	}
 
}
	class Circle extends Shape{
 double r;
	@Override
	double getArea() {		
		return Math.PI * r * r;
	}

	@Override
	double getPerimeter() {		
		return Math.PI * 2 * r;
	}

	@Override
	void input(Scanner in) {
		System.out.println("----Circle---\n" );
        System.out.print("Radius: ");
        r = in.nextDouble();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Area: " + getArea()+ "\nPermiter: " + getPerimeter();
	}
	
 }
	class Rectangle extends Shape{
		double a;
	    double b;
	 
		@Override
		double getArea() {
			
			return a*b;
		}

		@Override
		double getPerimeter() {
			// TODO Auto-generated method stub
			return (a + b) * 2;
		}

		@Override
		void input(Scanner in) {
			 System.out.println("----Rectangle----");
		        System.out.println("Length: ");
		        a = in.nextDouble();
		        System.out.println("Width: ");
		        b = in.nextDouble();
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Area: " + getArea()+ "\nPermiter: " + getPerimeter();
		}
		
	}
public class Ex1 {
	
// public static void main(String[] args) {
//	 Scanner in = new Scanner(System.in);
//	    Rectangle re = new Rectangle();
//		re.input(in);
//		System.out.println(re.toString());
//		Triangle tr = new Triangle();
//		tr.input(in);
//		System.out.println(tr.toString());		
//		Circle ci = new Circle();
//		ci.input(in);
//		System.out.println(ci.toString());
//		
//	}
}
