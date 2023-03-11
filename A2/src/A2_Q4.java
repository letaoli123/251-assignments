import java.util.*;

public class A2_Q4 {
	
	public static double swaps(int[] passengers) {

		return 0;
	}
	public static double MergeSort(int[] passengers, int start, int end){
		
		if(start < end){
			int half = (start+end)/2;
			MergeSort(passengers, start, half);
			MergeSort(passengers, half+1, end);
			Merge(passengers, start, half, end);
		}
	}

	public static int Merge(int[] passengers, int start, int half, int end){

	}
}
