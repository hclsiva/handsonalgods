package leetcode.cheatsheet;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;
// https://www.youtube.com/watch?v=Ns4LCeeOFS4
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int l = 0, r = 1;
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        while(r < nums.length){
            if(l == r){
                r++;
                l = 0;
            } else if (l < r){
                if(nums[l] < nums[r]) {
                    LIS[r] = max(LIS[r], LIS[l]+1);
                }
                l++;
            }
        }
        return Arrays.stream(LIS).max().getAsInt();
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(IntStream.of(10,22,9,33,21,50,41,60).toArray()));
        System.out.println(lis.lengthOfLIS(IntStream.of(10,9,2,5,3,7,101,18).toArray()));
        System.out.println(lis.lengthOfLIS(IntStream.of(0,1,0,3,2,3).toArray()));
        System.out.println(lis.lengthOfLIS(IntStream.of(7,7,7,7,7,7,7).toArray()));
    }
}
