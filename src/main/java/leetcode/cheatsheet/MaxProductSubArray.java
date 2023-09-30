package leetcode.cheatsheet;

import java.util.stream.IntStream;
public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int l = 1;
        int r = 1;
        for(int i =0;i < nums.length;i++){
            l = (l ==0) ? 1: l;
            r = (r == 0) ? 1:r;

            l *= nums[i];
            r *= nums[nums.length-i-1];
            maxProduct = Math.max(maxProduct,Math.max(l,r));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println("Max Product Sub Array =  "+ new MaxProductSubArray().maxProduct(IntStream.of(-2,3,-4).toArray()));
    }
}
