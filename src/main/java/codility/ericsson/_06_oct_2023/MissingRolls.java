package codility.ericsson._06_oct_2023;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingRolls {
    public int[] solution2(int[] A, int F, int M) {
        int m = A.length;
        int s = (M + m) * F;
        for (int v : A) {
            s -= v;
        }
        if (s > M * 6 || s < M) {
            return new int[0];
        }
        int[] ans = new int[M];
        Arrays.fill(ans, s / M);
        for (int i = 0; i < s % M; ++i) {
            ++ans[i];
        }
        return ans;
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int s = (n + m) * mean;
        for (int v : rolls) {
            s -= v;
        }
        if (s > n * 6 || s < n) {
            return new int[]{0};
        }
        int[] ans = new int[n];
        Arrays.fill(ans, s / n);
        for (int i = 0; i < s % n; ++i) {
            ++ans[i];
        }
        return ans;
    }
    public int[] solution(int[] A, int F, int M) {
        // Implement your solution here
        int m = A.length;
        int s = (F + m) * M;
        for (int v : A) {
            s -= v;
        }
        if (s > F * 6 || s < F) {
            return new int[]{0};
        }
        int[] ans = new int[F];
        Arrays.fill(ans, s / F);
        for (int i = 0; i < s % F; ++i) {
            ++ans[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        MissingRolls m = new MissingRolls();
        int [] r = null;

        r = m.solution(IntStream.of( 3,2,4,3).toArray(),2,4);
        Arrays.stream(r).forEach(System.out::println);
        System.out.println();
        r = m.solution(IntStream.of( 1,5,6).toArray(),4,3);
        Arrays.stream(r).forEach(System.out::println);
        System.out.println();
        r = m.solution(IntStream.of( 1,2,3,4).toArray(),4,6);
        Arrays.stream(r).forEach(System.out::println);
        System.out.println();
        r = m.solution(IntStream.of( 6,1).toArray(),1,1);
        Arrays.stream(r).forEach(System.out::println);
    }
}
