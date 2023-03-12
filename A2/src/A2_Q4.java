import java.util.*;

public class A2_Q4 {

	public static double swaps(int[] passengers) {
		int start = 0;
		int end = passengers.length-1;
		double swaps = MergeSort(passengers, start, end);
		return swaps;
	}
	public static double MergeSort(int[] passengers, int start, int end){
		double totalSwaps = 0;
		if(start < end){
			int half = (start+end)/2;
			double sort1 = MergeSort(passengers, start, half);
			double sort2 = MergeSort(passengers, half+1, end);

			double mergeSwap = Merge(passengers, start, half, end);
			totalSwaps = sort1+sort2+mergeSwap;
		}
		return totalSwaps;
	}

	public static double Merge(int[] passengers, int start, int half, int end){
		double mergeSwap = 0;
		int n1 = half-start+1;
		int n2 = end - half;
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		for(int i = 0; i<n1; i++){
			leftArray[i] = passengers[start+i];
		}
		for(int i = 0; i<n2; i++){
			rightArray[i] = passengers[half+1+i];
		}
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = start; i<=end; i++){
			if(leftIndex >= leftArray.length) {
				passengers[i] = rightArray[rightIndex];
				rightIndex++;
				continue;
			}else if(rightIndex >= rightArray.length) {
				passengers[i] = leftArray[leftIndex];
				leftIndex++;
				continue;
			}
			if(leftArray[leftIndex] <= rightArray[rightIndex]){
				passengers[i] = leftArray[leftIndex];
				leftIndex++;
			}else{
				passengers[i] = rightArray[rightIndex];
				rightIndex++;
				mergeSwap += leftArray.length - leftIndex;
			}
		}
		return mergeSwap;
	}

	public static void main(String[] args) {

		int[] passengers = {12,4,65,3};
		double swaps = MergeSort(passengers, 0, passengers.length-1);
		System.out.println(swaps);
	}
}
