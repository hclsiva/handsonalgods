package leetcode.forvgcs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JumpClouds {
    public static int jumpingOnClouds(List<Integer> c) {
        int jumpCount = 0;
        int i = 0;
        // Write your code here
        while(i <= c.size()-2){
            if(i+2 <= c.size()-1 && c.get(i+2) != 1 ){
                i+=2;
            } else {
                i += 1;
            }
            jumpCount++;
        }
        return jumpCount;
    }


    public static void main(String[] args) {
        JumpClouds jumpClouds = new JumpClouds();
        List<Integer> c = IntStream.of(0, 0, 0,1,0,0).boxed().collect(Collectors.toList()); //IntStream.of(0, 1, 0, 0, 0, 1, 0).boxed().collect(Collectors.toList());
        System.out.println(JumpClouds.jumpingOnClouds(c));
    }
}
