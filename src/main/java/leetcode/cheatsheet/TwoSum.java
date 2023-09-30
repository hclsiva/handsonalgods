package leetcode.cheatsheet;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int [] result = null;
        Map<Integer,Integer> complementMap = new HashMap();
        for(int i = 0; i < numbers.length; i++){
            if(complementMap.containsKey(target - numbers[i])){
                result = new int[2];
                result[0] = complementMap.get(target - numbers[i])+1;
                result[1] = i+1;
                break;
            }   else {
                complementMap.put(numbers[i],i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        print(new TwoSum().twoSum(IntStream.of(2,7,11,15).toArray(),9));
        print(new TwoSum().twoSum(IntStream.of(2,3,4).toArray(),6));
        print(new TwoSum().twoSum(IntStream.of(-1,0).toArray(),-1));

    }
    private static void print(int[] numbers){
        if(numbers == null){
            System.out.println("EMPTY");
        }
        for(int i : numbers){
            System.out.print(i + "-> ");
        }
        System.out.println();
    }

}
