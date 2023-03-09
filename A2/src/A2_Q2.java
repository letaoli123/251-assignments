import java.util.*;

public class A2_Q2 {

	public static int change(int[] denominations) {
		int[] changeDP = changeListDP(denominations);
		int[] changeGreedy = changeListGreedy(denominations);

		if(changeDP.equals(changeGreedy)){
			return -1;
		}else {
			for (int i = 1; i < changeDP.length; i++) {
				if (changeDP[i] < changeGreedy[i]) {
					return i;
				}
			}
		}
		return -1;
	}
	public static int[] changeListDP(int[] denominations) {
		int listLength = denominations[denominations.length - 1] + denominations[denominations.length - 2]+1;
		int[] result = new int[listLength];
		for(int i = 1; i<result.length; i++){
			result[i] = (denominations[denominations.length - 1])+(denominations[denominations.length-2]);
		}
		result[0] = 0;

		for(int i = 1; i<result.length; i++){
			for(int j = 0; j<denominations.length; j++){
				if(denominations[j]<=i){
					result[i]= Math.min(result[i], result[i-denominations[j]]+1);
				}
			}
		}



		return result;
//		for (int i=1; i<result.length; i++){
//			result[i] = new ArrayList<Integer>();
//
//		}
////		result[result.length-1].add(denominations[denominations.length-1]);
////		result[result.length-1].add(denominations[denominations.length-2]);
//
//		for (int i = 0; i < denominations.length; i++) {
//			result[denominations[i]].clear();
//			result[denominations[i]].add(denominations[i]);
//			for (int j = i+1; j<denominations.length; j++){
//				if(result[denominations[i]+denominations[j]].isEmpty()) {
//					result[denominations[i] + denominations[j]].add(denominations[j]);
//					result[denominations[i] + denominations[j]].add(denominations[i]);
//				}
//			}
//		}
//
//
//		for(int i = 1; i < result.length; i++){
//			if (result[i].isEmpty()){
//				int amountOwed = i;
//				for(int j = denominations.length-1; j>=0; j--){	//Check if the index is a multiple of a denomination
//					if((amountOwed % denominations[j]) == 0){
////						boolean noNeed = false;
//						for(int k = denominations.length-1; k>j; k--){
//							if(denominations[k] < i && denominations[k] > denominations[j]){
//								ArrayList<Integer> tempArray = new ArrayList<>();
//								if(i-1 > 0){
//
//
//									tempArray.addAll(result[i-1]);
//									amountOwed = amountOwed - (i-1);
//									if(Arrays.asList(denominations).contains(amountOwed)){
//										tempArray.add(amountOwed);
//										amountOwed = amountOwed - amountOwed;
//									}
//									else{
//										tempArray.add(1);
//										amountOwed = amountOwed - 1;
//									}
////									tempArray.add(1);
////									amountOwed = amountOwed - 1;
//									result[i] = tempArray;
//									break;
//
//								}
//							}
//							//else{
////								while(amountOwed > 0){
////									result[i].add(denominations[j]);
////									amountOwed = amountOwed - denominations[j];
////								}
////								break;
////							}
//						}
//						while(amountOwed > 0){
//							result[i].add(denominations[j]);
//							amountOwed = amountOwed - denominations[j];
//						}
//						break;
//					}
////					if(amountOwed == 0){
////						break;
////					}
//				}
//			}
//
//
//		}


	}
		public static int[] changeListGreedy(int[] denominations) {
			int listLength = denominations[denominations.length - 1] + denominations[denominations.length - 2]+1;
			int[] result = new int[listLength];
			for(int i = 1; i<result.length; i++){
				int amountOwed = i;
				while(amountOwed > 0){
					for(int j = denominations.length-1; j >=0; j--){
						if(denominations[j] <= amountOwed){
							amountOwed = amountOwed-denominations[j];
							result[i]++;
							break;
						}
					}
				}
			}

			return result;
		}

		public static String toString(int[] arrayLists){
		String string = "";
		for(int i = 1; i<arrayLists.length; i++) {
			string = string + i + ": " + arrayLists[i] + "\n";
		}
		return string;
	}
	public static void main(String[] args) {
		int[] denominations = {1, 9999};
		int[] change= changeListDP(denominations);
		System.out.println(toString(change));
		int[] greedyChange = changeListGreedy(denominations);
		System.out.println(toString(greedyChange));

		int counterExample = change(denominations);
		System.out.println(counterExample);

//		int[] denominations2 = {1,2,4,5};
//		ArrayList<Integer>[] change2= changeListDP(denominations2);
//		System.out.println(toString(change2));
	}
}
