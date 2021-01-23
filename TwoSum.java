import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ss[] = s.split(" ");
		int nums[] = new int[ss.length];
		for(int i=0; i<ss.length; i++)
			nums[i] = Integer.parseInt(ss[i]);
		int target = sc.nextInt();
		
		// O(n^2)
		int arr[] = twoSum(nums, target);
		System.out.println( arr[0] + " " + arr[1]);
		
		// O(n)
		arr = twoSumHash(nums, target);
		System.out.println( arr[0] + " " + arr[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }
	public static int[] twoSumHash(int[] nums, int target) {
        int arr[] = new int[2];
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
        	if(hm1.containsKey(nums[i])){
        		if(!hm2.containsKey(nums[i]))
        			hm2.put(nums[i], i);
        	}
        	else
        		hm1.put(nums[i], i);
        }
        for(int i=0; i<nums.length-1; i++){
        	if(nums[i] == target-nums[i]){
        		if(hm2.containsKey(nums[i])){
        			arr[0] = hm1.get(nums[i]);
        			arr[1] = hm2.get(nums[i]);
        			return arr;
        		}
        	}
        	else if(hm1.containsKey(target - nums[i])){
        		arr[0] = hm1.get(nums[i]);
    			arr[1] = hm1.get(target - nums[i]);
    			return arr;
            }
        }
        return arr;
    }
	
}
