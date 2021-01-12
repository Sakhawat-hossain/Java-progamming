import java.util.Scanner;
import java.util.Stack;

public class StackWithMinMax {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		
		int flag = sc.nextInt();
		int n = sc.nextInt();
		int m, v;
		if(flag==1){
			StackMax sm = new StackMax();
			for(int i=0;i<n; i++){
				m = sc.nextInt();
				if(m==1) {
					v = sc.nextInt();sm.push(v);}
				else if(m==2) System.out.println(sm.pop());
				else if(m==3) System.out.println(sm.getMax());
			}
		}
	}
}
class StackMax{
	private Stack<Integer>  stack; 
	private int max; // used to store max value
	
	public StackMax(){
		stack = new Stack<>();
	}
	// modifying push method
	public void push(int n){
		if(stack.isEmpty()){
			max = n;
			stack.push(n);
			return;
		}	
		//when n > max
		if(n>max){
			stack.push(2*n - max);
			max = n;
		}
		else
			stack.push(n);
	}
	// modifying pop method
	public Integer pop(){
		if(stack.isEmpty()){
			System.out.println("The stack is empty");
			return null;
		}	
		//when n > max
		int n = stack.pop();
		if(n>max){
			int t = max;
			max = 2*max - n;
			n = t;
		}
		//System.out.println(n);
		return n;
	}	
	public int getMax(){
		return max;
	}
}
//"stack implementation where push/pop/max all in O(1)"
