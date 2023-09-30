package codility;

import java.util.Arrays;

public class FindMinCars {

  
  public FindMinCars() {
  }
  public int solution(int[] P, int[] S) {
    int[] cars = new int[S.length];
    Arrays.sort(S);
    int totalPpl = 0;
    for(int i : P) {
      totalPpl +=i;
    }
    int i =0;
    int n = S.length-1;
    while(totalPpl >0) {
       totalPpl = totalPpl - S[n];
       cars[i]  = S[n];
       i++;
       n--;
    }
    i =0;
    int minCars =0;
    while(i < cars.length && cars[i] >0 ) {
      minCars++;
      i++;
    }
    return minCars;
  }
  

  public static void main(String[] args) {
    FindMinCars f = new FindMinCars();
    System.out.println("Minimum Cars required = "+f.solution(new int[]{1,4,1}, new int[]{1,5,1}));
    System.out.println("Minimum Cars required = "+f.solution(new int[]{4,4,2,4}, new int[]{5,5,2,5}));
    System.out.println("Minimum Cars required = "+f.solution(new int[]{2,3,4,2}, new int[]{2,5,7,2}));
  }

}
