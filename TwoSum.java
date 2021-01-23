import java.util.Scanner;

public class TwoSum {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int nums[] = new int[3001];
		String s = sc.nextLine();
		String ss[] = s.split(" ");
		for(int i=0; i<ss.length; i++)
			nums[i] = Integer.parseInt(ss[i]);
		int target = sc.nextInt();
		// O(n^2)
		int arr[] = twoSum(nums, target);
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
}
