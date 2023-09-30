package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    Map<Integer,Integer> countMap = new HashMap<>();

    private void updateCountMap(Integer number){
        Integer i = countMap.get(number);
        if(i == null){
            i = 0;
        }
        countMap.put(number, ++i);
    }
    private boolean isDuplicate(int number){
        Integer i = countMap.get(number);
        if(i == null || i < 2){
            return false;
        } else if(i == 2){
            return true;
        }
        return false;
    }
    public int removeDuplicates(int[] nums) {
        int repeatCount =1;
        int index =0;
        for(int i =1;i < nums.length;i++){
            if(nums[i-1] == nums[i]){
                if(repeatCount < 2) {
                    repeatCount++;
                } else if(repeatCount >= 2){
                   int j = i+1;
                    if(nums[j-1] != nums[j]){
                        repeatCount = 1;
                    }
                    for(;j < nums.length;j++){
                       nums[j-1] = nums[j];
                    }
                    index = i;
                }
            } else {
                repeatCount = 0;
                index = i;
            }

        }
        String array = Arrays.stream(nums)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
        return index+1;
    }

    public static void main(String[] args) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        System.out.println(removeDuplicate.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
