package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JudgeFinder{

    public int findJudge(int n, int[][] trust) {
        int[] trustCount = {0,0,0,2};
        int judgeNo = IntStream.range(1,n)
                .filter(i -> trustCount[i] > 0)
                .findFirst()
                .orElse(-1);
        return judgeNo;
    }
    public static void main(String... args){
        System.out.println("Hello World");
        new JudgeFinder().findJudge(4,null);
    }
}