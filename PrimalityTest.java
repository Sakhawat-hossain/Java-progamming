
public class PrimalityTest {
	public static void main(String []args){
		int n = 14593;
		Prime prime = new Prime();
		System.out.println(n+" is prime: "+prime.is_prime(n) + "\n");

		n = 75;
		System.out.println("Largest prime factor of " + n + " : "+ prime.max_prime_factor(n) + "\n");
	}
}
class Prime{
	boolean is_prime(int n){
		if(n%2 == 0)
			return false;
		else if(n%3 == 0)
			return false;
		int maxd = (int)Math.sqrt(n);
		int k = 1;
		while ((6*k - 1) <= maxd){
			if(n % (6*k-1) == 0)
				return false;
			else if(n % (6*k+1) == 0)
				return false;
			k++;
		}
		return true;
	}

	int max_prime_factor(int n){
		int max_prime = 1;
		while(n%2 == 0){
			System.out.print(2 + " ");
			max_prime = 2;
			n >>= 1;
		}
		for(int i = 3; i<=Math.sqrt(n); i += 2){
			while(n%i == 0){
				System.out.print(i + " ");
				max_prime = i;
				n = n/i;
			}
		}
		if(n > 2){
			System.out.print(n + " ");
			max_prime = n;
		}
		System.out.println(" ");
		
		return max_prime;
	}
}
