public class A2_Q2Copy {

	public static int change(int[] denominations) {
		int listLength = denominations[denominations.length - 1] + denominations[denominations.length - 2]+1;
		int[] result = new int[listLength];

		for(int i = 1; i<listLength; i++){
			int changeDP = changeListDP(denominations, result, i);
			int changeGreedy = changeListGreedy(denominations, i);
			if(changeDP < changeGreedy){
				return i;
			}
		}
		return -1;
	}
	public static int changeListDP(int[] denominations, int[] result, int i) {
		for(int j = 0; j<denominations.length; j++){
			if(result[i]==0){
				result[i] = denominations[denominations.length-1]+denominations[denominations.length-2];
			}
			if(denominations[j]<=i){
				result[i]= Math.min(result[i], result[i-denominations[j]]+1);
			}
		}
		return result[i];
	}
		public static int changeListGreedy(int[] denominations, int i) {

			int amountOwed = i;
			int coinNumbers = 0;

			for(int j = denominations.length-1; j >=0; j--){
				if(denominations[j] <= amountOwed){
					if(denominations[j] == 1){
						coinNumbers = coinNumbers + amountOwed;
						return coinNumbers;
					}
					amountOwed = amountOwed-denominations[j];
					if(amountOwed == 0){
						coinNumbers++;
						break;
					}
					coinNumbers++;
					if(amountOwed >= denominations[j]){
						j = j+1;
					}
				}

			}

			return coinNumbers;
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
//		int[] change= changeListDP(denominations);
//		System.out.println(toString(change));
//		int[] greedyChange = changeListGreedy(denominations);
//		System.out.println(toString(greedyChange));

		int counterExample = change(denominations);
		System.out.println(counterExample);

//		int[] denominations2 = {1,2,4,5};
//		ArrayList<Integer>[] change2= changeListDP(denominations2);
//		System.out.println(toString(change2));
	}
}
