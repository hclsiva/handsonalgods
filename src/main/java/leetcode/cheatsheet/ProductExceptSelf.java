package leetcode.cheatsheet;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int multiple =1;
        result[0] = 1;
        for(int i = 0; i < result.length-1;i++){
            result[i+1] = nums[i] * result[i];
        }
        for(int i = result.length-1; i >= 0;i--){
            result[i] = multiple * result[i];
            multiple = multiple * nums[i];
        }
        print(result);
        return result;
    }
    void print(int[] nums){
        Arrays.stream(nums).forEach(i -> System.out.print(i + ","));
    }

    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();
        solution.productExceptSelf(IntStream.of(1,2,3,4).toArray());
    }
}
