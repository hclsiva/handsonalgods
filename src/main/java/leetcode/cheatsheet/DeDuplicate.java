package leetcode.cheatsheet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class DeDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> deDuplicate = new HashSet<Integer>();
        Map<Integer,Integer> indices = new HashMap<Integer,Integer>();
        for(int i : nums){
            if(deDuplicate.contains(i)){
                return true;
            } else{
                deDuplicate.add(i);
            }
        }
        return false;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i =0;
        int j = i+1;
        while (i < nums.length && j < nums.length){
            while(j < nums.length && ((j -i) <=k)){
                if(nums[i] == nums[j]){
                    return true;
                }
                j++;
            }
            i++;
            j=i+1;
        }
        return false;
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int i =0;
        int j = i+1;
        while (i < nums.length && j < nums.length){
            while(j < nums.length && ((j -i) <=indexDiff)){
                if(Math.abs(nums[i] -nums[j]) <= valueDiff){
                    return true;
                }
                j++;
            }
            i++;
            j=i+1;
        }
        return false;
    }
    public static void main(String[] args) {
        DeDuplicate deDuplicate = new DeDuplicate();
         System.out.println(deDuplicate.containsNearbyAlmostDuplicate(IntStream.of(1,2,3,1).toArray(),3,0));
         System.out.println(deDuplicate.containsNearbyAlmostDuplicate(IntStream.of(1,5,9,1,5,9).toArray(),2,3));
        System.out.println(deDuplicate.containsNearbyAlmostDuplicate(IntStream.of(8,7,15,1,6,1,9,15).toArray(),1,3));
    }
}
