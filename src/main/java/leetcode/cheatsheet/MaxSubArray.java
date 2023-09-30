package leetcode.cheatsheet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.*;
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null ){
            return 0;
        }
        if(nums.length == 1 ){
            return nums[0];
        }
        int l =0;
        int r = 0;
        int i = l; int j = r;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        while(l < nums.length){
            if(r < nums.length){
                sum += nums[r];
                maxSum = max(maxSum,sum);
                r++;
            } else {
                sum = 0;
                l++;
                r = l;
            }
        }
        return maxSum;
    }
    /**
     *   Kadane Algorithm
     */

    public int maxSubArrayLinear(int[] nums) {
        int maxSum = nums[0];
        int l = 0;
        int sum = 0;
        while(l < nums.length){
            sum = max(nums[l], sum+nums[l]);
            maxSum = max(maxSum,sum);
            l++;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println("Max Sub Array =  "+ new MaxSubArray().maxSubArrayLinear(IntStream.of(-2,-1).toArray()));
        System.out.println("Max Sub Array =  "+ new MaxSubArray().maxSubArrayLinear(IntStream.of(-2,1,-3,4,-1,2,1,-5,4).toArray()));
        System.out.println("Max Sub Array =  "+ new MaxSubArray().maxSubArrayLinear(IntStream.of(1).toArray()));
        System.out.println("Max Sub Array =  "+ new MaxSubArray().maxSubArrayLinear(IntStream.of(5,4,-1,7,8).toArray()));
        Path path = Paths.get("prices.in");
        String line = null;
        try {
            line = Files.readAllLines(path).get(0);
            String[] values = line.split(",");
            int[] intPrices = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
            long startTime = System.currentTimeMillis();
            int maxSum = new MaxSubArray().maxSubArrayLinear(intPrices);
            System.out.println("Time of Execution = "+ (System.currentTimeMillis() -  startTime) +"(ms) Max Sub Array =  "+ maxSum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
