package leetcode.forvgcs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {

    public List<Integer> findSumPairUsingValues(int[] arr, int target){
        List<Integer> resultList = new ArrayList<>();
        Map<Integer,Integer> diffAndIndexMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int value = arr[i];
            int diff = target - value;
            Map.Entry<Integer,Integer> diffEntry =  diffAndIndexMap.entrySet().stream().filter(e -> {
                return e.getValue() == value;
            }).findAny().orElse(null);
            if(diffEntry != null){
                resultList.add(diffEntry.getKey());
                resultList.add(i);
                return resultList;
            } else {
                diffAndIndexMap.putIfAbsent(i,diff);
            }
        }
        resultList.add(-1);
        resultList.add(-1);
        return resultList;
    }
    public static void main(String[] args) {
        int[] array = IntStream.of(2, 3, 6, 7, 11, 15).toArray();
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.findSumPairUsingValues(array,9));
    }
}
