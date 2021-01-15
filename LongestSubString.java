import java.util.Scanner;

public class LongestSubString {
	public static void main(String []args){
		Solution solution = new Solution();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(solution.lengthOfLongestSubstring(s));
		
	}
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        
        int n = s.length();
        if(n>0) len = 1;
        int idx = 0, t = 0;
        char ch;
        for(int i = 1; i<n; i++){
            ch = s.charAt(i);
            t = 1;
            for(int j = i-1; j>=idx; j--){
                if(ch == s.charAt(j)){
                    idx = j+1;
                    break;
                }
                t++;
            }
            if(t>len) len = t;
        }
        
        return len;
    }
       
}
