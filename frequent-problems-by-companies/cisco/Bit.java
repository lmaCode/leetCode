package cisco;
import java.util.Scanner;

public class Bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void hammingWeight() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int ones = 0;
    	while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    	System.out.print(ones);
    	sc.close();
    }

}
