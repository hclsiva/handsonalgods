package leetcode.cheatsheet;

import java.util.stream.IntStream;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(IntStream.of(2,3,1,1,4).toArray()));
        System.out.println(new JumpGame().canJump(IntStream.of(3,2,1,0,4).toArray()));
        System.out.println(new JumpGame().canJump(IntStream.of(1,1,2,5,2,1,0,0,1,3).toArray()));
    }
}
