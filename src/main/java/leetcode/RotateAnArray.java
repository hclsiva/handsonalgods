package leetcode;

import java.util.Arrays;

public class RotateAnArray {

    public static void rotate(int[] nums, int k) {
        int[] copy = new int[nums.length];
        copy = Arrays.copyOf(nums, nums.length);
        for(int i = 0; i < nums.length; i++){
            int rotatedIndex = ((k % 2 == 0) ? (i+k) : (i+1)+k)% nums.length;
            copy[i] = nums[rotatedIndex];
        }
        nums = copy;
        for(int j : nums){
            System.out.print(j + "- ");
        }
    }
    public static void main(String[] args) {
       rotate(new int[]{-1,-100,3,99},2);
    }
}
