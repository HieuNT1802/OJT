package fa.training.ex1;

public class Ex1 {
	int real, image;
	 public Ex1(int r, int i)
	    {
	        this.real = r;
	        this.image = i;
	    }
	 public void showC()
	    {
	        System.out.print(this.real +"+"+ this.image+ "i" );
	    }
	 
	 public static Ex1 add(Ex1 n1, Ex1 n2)
{
		Ex1 res = new Ex1(0, 0);
		res.real = n1.real + n2.real;
		res.image = n1.image + n2.image;
return res;
}    public static Ex1 multi(Ex1 n1, Ex1 n2) {
	Ex1 res = new Ex1(0, 0);
	res.real = ((n1.real*n2.real)-(n1.image * n2.image));
	res.image =( (n1.real*n2.image)+(n1.image * n2.real));
	return res;
}
	 
	 public static void main(String[] args) {
		Ex1 c1 =new Ex1(3, 2);
		Ex1 c2 =new Ex1(4, (-2));
        Ex1 res = add(c1, c2);
        Ex1 res1 = multi(c1, c2);
        // displaying addition
        System.out.print("Addition is : ");
        res.showC();
        System.out.print("\nMultiplication is : ");
        res1.showC();
	}
}
