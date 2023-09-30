package leetcode.cheatsheet;

import java.util.stream.IntStream;

import static java.lang.Math.*;
public class MaxAreaForContainer {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length-1;
        int area = 0;
        while(l < r){
            area= (r -l) * min(height[l],height[r]);
            maxArea = max(maxArea,area);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaForContainer areaFinder = new MaxAreaForContainer();
        int area = areaFinder.maxArea(IntStream.of(1,8,6,2,5,4,8,3,7).toArray());
        System.out.println("Area = " + area);
    }
}
