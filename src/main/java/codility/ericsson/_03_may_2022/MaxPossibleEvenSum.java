package codility.ericsson._03_may_2022;

import java.util.ArrayList;
import java.util.Collections;

public class MaxPossibleEvenSum {

  public MaxPossibleEvenSum() {
    // TODO Auto-generated constructor stub
  }
  public int solution(int[] A, int K) {
    if (K > A.length) {
        return -1;
    }
    int maxSum = 0;
    ArrayList<Integer> even = new ArrayList<Integer>();
    ArrayList<Integer> odd = new ArrayList<Integer>();
    for (int i = 0; i < A.length; i++) {
        if (A[i] % 2 == 1) {
            odd.add(A[i]);
        }
        else {
            even.add(A[i]);
        }
    }
    Collections.sort(odd);
    Collections.sort(even);
    int i = even.size() - 1;
    int j = odd.size() - 1;

    while (K > 0) {
        if (K % 2 == 1) {
            if (i >= 0) {
                maxSum += even.get(i);
                i--;
            }
            else {
                return -1;
            }
            K--;
        }
        else if (i >= 1 && j >= 1) {
            if (even.get(i) + even.get(i - 1)
                <= odd.get(j) + odd.get(j - 1)) {
                maxSum += odd.get(j) + odd.get(j - 1);
                j -= 2;
            }
            else {
                maxSum += even.get(i) + even.get(i - 1);
                i -= 2;
            }
            K -= 2;
        }
        else if (i >= 1) {
            maxSum += even.get(i) + even.get(i - 1);
            i -= 2;
            K -= 2;
        }
        else if (j >= 1) {
            maxSum += odd.get(j) + odd.get(j - 1);
            j -= 2;
            K -= 2;
        }
        else
         return -1;
    }
    return maxSum;
  }
  public static void main(String[] args) {
    MaxPossibleEvenSum m = new MaxPossibleEvenSum();
    System.out.println(m.solution(new int[] {4,9,8,2,6}, 3));
    System.out.println(m.solution(new int[] {5,6,3,4,2}, 5));
    System.out.println(m.solution(new int[] {7,7,7,7,7}, 1));
    System.out.println(m.solution(new int[] {10000}, 2));
    System.out.println(m.solution(new int[] {2,3,3,5,5}, 3));
  }

}
