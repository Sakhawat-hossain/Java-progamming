import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GeneralAlgo {
	public static void main(String []args){
		System.out.println("General algorithms:");
		SomeAlgo sa = new SomeAlgo();
		sa.printSeqDiv(100);
		sa.printSeqN(10);
		int arr[] = {1, 2, 3, 4, 5, 1, 3, 4};
		sa.printDuplicate(arr);
	}
}
	
class SomeAlgo{
	public void printSeqDiv(int n){
		n = n/3;
		n = n*3;
		while(n >= 3){
			System.out.print(n + " ");
			n -= 3;
		}
		System.out.println();
	}
	
	public void printSeqN(int n){
		for(int i=1; i<=n; i++)
			System.out.print(i + " ");
		for(int i=n-1; i>=1; i--)
			System.out.print(i + " ");
		System.out.println("");
	}
	
	public void printDuplicate(int[] arr){
		HashMap<Integer, Integer> hm = new HashMap<>();
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<arr.length; i++){
			if(hm.containsKey(arr[i]))
				System.out.print(arr[i] + " ");
			else
				hm.put(arr[i], 1);
			hs.add(arr[i]);
		}
		System.out.println("  "  + hm.toString() + "  " + hm.values() + "  " + hm.keySet());
		for (Integer integer : hm.keySet()) {
			System.out.print(integer + " ");
		}
		System.out.println();
		
		System.out.println( hs.toString() + "  Length: " + hs.size());
		for (Integer integer : hs) {
			System.out.print(integer + " ");
		}
		System.out.println(" ");
		Iterator<Integer> itr = hs.iterator();
		while(itr.hasNext())
			System.out.print(itr.next() + " ");
		hs.forEach(System.out::println);
	}
	
}