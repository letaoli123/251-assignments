import java.util.*;

public class A2_Q2 {

	public static int change(int[] denominations) {

		return -1;
	}
	public static ArrayList<Integer>[] changeListDP(int[] denominations) {
		int listLength = denominations[denominations.length - 1] + denominations[denominations.length - 2]+1;
		ArrayList<Integer>[] result = new ArrayList[listLength];
		for (int i=1; i<result.length; i++){
			result[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < denominations.length; i++) {
			result[denominations[i]].add(denominations[i]);
		}
		result[result.length-1].add(denominations[denominations.length-1]);
		result[result.length-1].add(denominations[denominations.length-2]);

		for(int i = 1; i < result.length; i++){
			if (result[i].isEmpty()){
				int amountOwed = i;
				for(int j = denominations.length-1; j>=0; j--){	//Check if the index is a multiple of a denomination
					if((amountOwed % denominations[j]) == 0){
						while(amountOwed > 0){
							result[i].add(denominations[j]);
							amountOwed = amountOwed - denominations[j];
						}
						break;
					}
				}


			}
		}

		return result;
	}
	public static String toString(ArrayList<Integer>[] arrayLists){
		String string = "";
		for(int i = 1; i<arrayLists.length; i++){
			if(arrayLists[i] == null){
				string = string + i + " : null\n";
				continue;
			}
			string = string + i + " :" + arrayLists[i].toString() + "\n";
		}
		return string;
	}
	public static void main(String[] args) {
		int[] denominations = {1,2,4,5};
		ArrayList<Integer>[] change= changeListDP(denominations);
		System.out.println(toString(change));
	}

}
