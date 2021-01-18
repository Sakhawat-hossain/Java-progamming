import java.util.Scanner;

public class Median {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int arr1[] = {1, 2};
		int arr2[] = { };
		MedianSortedArray msa = new MedianSortedArray();
		System.out.println(msa.findMedianSortedArrays(arr1, arr2));
	}
}
class MedianSortedArray{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if(len1==0){
            if(len2%2 == 0) return (double)(nums2[len2/2-1] + nums2[len2/2])/2;
            else return nums2[len2/2];
        }
        if(len2==0){
            if(len1%2 == 0) return (double)(nums1[len1/2-1] + nums1[len1/2])/2;
            else return nums1[len1/2];
        }
        
        int i=0, j=0, idx=0;
        int arr[] = new int[len1+len2];
        double med;
        for(int l=0; l<(len1+len2); l++){
            if(i==len1) arr[idx] = nums2[j++];
            else if(j==len2) arr[idx] = nums1[i++];
            else if(nums1[i] <= nums2[j]) arr[idx] = nums1[i++];
            else arr[idx] = nums2[j++];
            //System.out.println(arr[idx]);
            idx++;
        }
        if((len1+len2)%2 == 0) med = (double)(arr[(len1+len2)/2-1] + arr[(len1+len2)/2])/2;
        else med = arr[(len1+len2)/2];
        
        return med;
    }
}
