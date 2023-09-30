package leetcode.cheatsheet;

import java.util.stream.IntStream;

import static java.lang.Math.*;
public class MinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
    public int search(int[] nums, int target) {
        int l =0,m=0, r = nums.length-1;
        while(l < r){
            m = (l +r)/2;
            if(nums[m] == target)
                return m;
            if(nums[l] <= nums[m]){
                if(target > nums[m] || target < nums[l]){
                    l = m +1;
                } else {
                    r = m -1;
                }
            } else {
             if(target < nums[m] || target > nums[r]){
                 r = m -1;
             } else {
                 l = m +1;
             }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new MinimumInRotatedSortedArray().search(IntStream.of(3,4,5,1,2).toArray(),1));
        System.out.println(new MinimumInRotatedSortedArray().search(IntStream.of(4,5,6,7,0,1,2).toArray(),0));
    }
}
