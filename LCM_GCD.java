
public class LCM_GCD {
	public static void main(String []args){
		// for two integers
		System.out.println("Finding LCM and GCD");
		int a = 33333;
		int b = 11111;
		CMD cmd = new CMD();
		System.out.print("Finding GCD of "+a+" "+b+" : ");
		System.out.println(cmd.GCD(a,b));
		System.out.print("Finding LCM of "+a+" "+b+" : ");
		System.out.println(cmd.LCM(a,b));
		double c = Math.pow(2, 64);
		System.out.println(c + "\n");
		
		// for array of integers
		int arr[] = { 4, 8, 12};
		int result = arr[0];
		for(int i=1; i<arr.length; i++)
			result = cmd.GCD(result, arr[i]);
		System.out.print("Finding GCD of the array : " + result + "\n");

		result = arr[0];
		for(int i=1; i<arr.length; i++)
			result = cmd.LCM(result, arr[i]);
		System.out.print("Finding LCM of the array : " + result + "\n");
		//or
		result = arr[0];
		for(int i=1; i<arr.length; i++)
			result = result*arr[i]/cmd.GCD(result, arr[i]);
		System.out.print("Finding LCM of the array : " + result + "\n");
	}
	
}
class CMD{
	public int LCM(int a, int b){
		int lcm = 1;
		// a * b = LCM(a,b) * GCD(a,b)
		lcm = (a / GCD(a, b))*b;
		return lcm;
	}
	
	public int GCD(int a, int b){
		// when reminder 0
		if(a%b == 0)
			return b;
		return GCD(b, a%b);
	}
}
