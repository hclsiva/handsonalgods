package codility.toptal;

import java.util.Arrays;

public class ReduceEmissions {

  public ReduceEmissions() {
    // TODO Auto-generated constructor stub
  }
  public int solution(int[] A) {
    Arrays.sort(A);
    int totalPollution = 0;
    for(int i : A) {
      totalPollution += i;
    }
    
    return 0;
    
  }
}
