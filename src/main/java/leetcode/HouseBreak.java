package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HouseBreak {
    public int rob(int[] nums) {
        int []arr = new int[nums.length + 3];
        for (int i = 3; i < nums.length + 3; i++)
            arr[i] = Math.max(arr[i - 2], arr[i - 3]) + nums[i - 3];
        return Math.max(arr[arr.length - 1], arr[arr.length - 2]);
    }
    public static void main(String[] args) {
        HouseBreak breakHouse = new HouseBreak();
        System.out.println("Max sum =  " + breakHouse.rob(IntStream.of(4,1,2,7,5,3,1).toArray()));
    }
}
