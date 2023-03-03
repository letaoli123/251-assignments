import java.util.*;


public class A1_Q3 {
    public static int elements(int[] sizes) {
        HashMap<Integer, Integer> keyIndex = new HashMap<Integer, Integer>();
        int unique=keyIndex.size();
        int maxUnique = 0;
        for(int i=0; i < sizes.length; i++){
            // System.out.println("we are at index: " + i + " and checking key: " + sizes[i]);
            if(keyIndex.containsKey(sizes[i])){
                // System.out.println("THERES A REPEAT at index " + i);
                if(sizes[i-1]==sizes[i]){
                    keyIndex.clear();
                    keyIndex.put(sizes[i],i);
                }else{
                    i=keyIndex.get(sizes[i])+1;
                    // System.out.println("current i: "+ i);
                    keyIndex.clear();
                    keyIndex.put(sizes[i],i);
                }
                
            }else{
                keyIndex.put(sizes[i],i);
                if(maxUnique < keyIndex.size()){
                    maxUnique = keyIndex.size();
                    // System.out.println("maxUnique is: " + maxUnique);
                }
            }
            
        }
        if(maxUnique < keyIndex.size()){
            maxUnique = keyIndex.size();
        }

        // for( Map.Entry<Integer, Integer> entry : keyIndex.entrySet()){
        //     Integer size = entry.getKey();
        //     Integer value = entry.getValue();
        //     // System.out.println("key: " + size + " index: " + value);
        // }
        return maxUnique;
    }

    public static void main(String[] args) {
                int[] test0 = new int[]{1, 2, 3, 2, 1}; //should return 3
        int[] test2 = new int[]{1,3,5,3,5,4,1,2,2,3,1,2,3,4,3,1,4,1,5,5,3,3,1,1,3,2,4,2,4,4,1,5,4,4,3,3,5,1,2,4,5,5,2,5,2,3,2,4,1,3,3,5,2,1,4,4,1,5,2,2,4,2,5,5,1,2,4,2,5,4,2,3,5,5,5,2,5,5,5,3,4,4,2,3,2,5,3,4,2,3,4,2,4,4,4,4,3,2,2,4}; //should return 5
        int[] test3 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};//should return 1
        int[] test4 = new int[]{2,1,4,4}; //should return 3
        int[] test5 = new int[]{4,4,3,5,1,4}; //should return 4
        int[] test6 = new int[]{3,8,4,7,4,2,6,4,5,3,2}; //should return 5
        int[] test7 = new int[]{1,2,1,3}; //should return 3
        int[] sizes = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1, 6, 7, 7, 7, 7, 7, 8, 8, 7, 1, 8, 7, 6, 5, 4, 3, 2, 75}; // Should be 9

        System.out.println(elements(test0));
        System.out.println(elements(test2));
        System.out.println(elements(test3));
        System.out.println(elements(test4));
        System.out.println(elements(test5));
        System.out.println(elements(test6));
        System.out.println(elements(test7));
        System.out.println(elements(sizes));
        
    }
    
}
