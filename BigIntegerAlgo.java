import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerAlgo {
	public static void main(String []args){
		BigIntValue bigInt = new BigIntValue();
		Scanner sc = new Scanner(System.in);
		int n = 0;
		System.out.println("Factorial of "+n+" is: ");
		//bigInt.factorial(n);
		System.out.println("");
		
		// {2, 9, 8, 8, 9, 8} * {3,6,3,4,5,8,9,1,2} = {1,0,8,6,3,7,1,4,1,8,7,8,9,7,6}
		int a = sc.nextInt(); //298898;
		int b = sc.nextInt(); //363458912;
		System.out.println("Multiplication of "+a+" and "+b+" is: ");
		bigInt.multiplyBigInt(a, b);
		System.out.println("\n");
		
		BigInteger biga = BigInteger.valueOf(a);
		BigInteger bigb = BigInteger.valueOf(b);
		System.out.println(biga.multiply(bigb));
		System.out.println(biga.bitCount());
		System.out.println(biga.bitLength());
		System.out.println(biga.doubleValue());
		System.out.println("");
	}
}
class BigIntValue{
	public int multiply(int []res, int x, int res_size){
		int carry = 0, mult;
		for(int i=0; i<res_size; i++){
			mult = res[i]*x + carry;
			res[i] = mult % 10;
			carry = mult/10;
		}
		
		while(carry > 0){
			res[res_size] = carry % 10;
			carry = carry / 10;
			res_size++;
		}
		return res_size;
	}
	public void factorial(int n){
		int max_size = 500, res_size = 1;
		int res[] = new int[max_size];
		res[0] = 1;
		
		for(int x=2; x<=n; x++){
			res_size = multiply(res, x, res_size);
		}
		int count = 1;
		for(int i=res_size-1; i>=0; i--){
			System.out.print(res[i]);
			if(count==30){
				System.out.println("");
				count = 0;
			}
			count++;
		}
	}

	// using array
	public void multiplyBigInt(int a, int b){
		int res[] = new int[100];
		int arr[] = new int[20];
		int brr[] = new int[20];
		int trr[] = new int[30];
		int asize = 0, bsize = 0, res_size = 0, t; 
		int i = 0, carry = 0;
		
		while(a > 0){
			arr[i] = a%10;
			i++;
			a = a/10;
			//System.out.println(arr[i-1]);
		}
		asize = i;
		i = 0;
		while(b > 0){
			brr[i] = b%10;
			i++;
			b = b/10;
			//System.out.println(brr[i-1]);
		}
		bsize = i;
		for(int j = 0; j<bsize; j++){
			carry = 0;
			int k, l;
			for(k=0; k<asize; k++){
				trr[k] = (arr[k]*brr[j] + carry)%10;
				carry = (arr[k]*brr[j] + carry)/10;
				//System.out.print(arr[k]);
			}
			while(carry>0){
				trr[k] = carry%10;
				k++;
				carry = carry/10;
			}
				
			for(l = j; l<j+k; l++){
				t = res[l] + trr[l-j] + carry;
				res[l] = t%10;
				carry = t/10;
				//System.out.println(res[l] + " " + carry);
			}
			while(carry>0){
				res[l] = carry%10;
				l++;
				carry = carry/10;
			}
			res_size = l;
		}
		int count = 1;
		for(i=res_size-1; i>=0; i--){
			System.out.print(res[i]);
			if(count==30){
				System.out.println("");
				count = 0;
			}
			count++;
		}
	}
	
}