package exercise4;

public class ArrayReverse {
    
	static void ArrayReverse(int myIntArray [], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = myIntArray [i];
            myIntArray [i] = myIntArray [n - i - 1];
            myIntArray [n - i - 1] = t;
        }
        System.out.println("Reversed Array");
        for (k = 0; k < n; k++) {
            System.out.print(" "+myIntArray [k]);
        }
    }
	public static void main(String[] args) {
		int[] myIntArray = { 43, 32, 53, 23, 12, 34, 3, 12, 43, 32};
		System.out.println("Original  Array: ");
		for (int i = 0; i < myIntArray.length; i++) {
            System.out.print(" "+myIntArray[i]);
            }
		System.out.println("");
		ArrayReverse(myIntArray, myIntArray.length);
	}

}
