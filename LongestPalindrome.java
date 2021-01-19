import java.util.Scanner;

public class LongestPalindrome {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		SolutionPalindrome solution = new SolutionPalindrome();
		System.out.println(solution.longestPalindrome(s));
	}
}
class SolutionPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        boolean arr[][] = new boolean[len][len];
        
        for(int i=0; i<len; i++)
        	arr[i][i] = true;
        for(int i=0; i<len-1; i++){
        	if(s.charAt(i)==s.charAt(i+1))
        		arr[i][i+1] = true;
        	else 
        		arr[i][i+1] = false;
        }
        for(int i=2; i<len; i++){
        	for(int j=0; j<len-i; j++){
        		if(arr[j+1][i+j-1] && (s.charAt(j)==s.charAt(i+j)))
        			arr[j][i+j] = true;
        		else
        			arr[j][i+j] = false;
        	}
        }
        for(int i=len-1; i>=0; i--){
        	for(int j=0; j<len-i; j++){
        		if(arr[j][i+j]){
        			for(int k = j; k<=i+j; k++)
        				sb.append(s.charAt(k));
        			return new String(sb);
        		}
        	}
        }
        
    	return res;
    }
}