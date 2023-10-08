package codility.ericsson._03_may_2022;

import java.util.HashMap;
import java.util.Map;

public class NumberOfRectangular {
  Map<Integer,Long> lm = null;
  int[] j = new int[1000000001];
  public NumberOfRectangular() {
    lm = new HashMap<Integer,Long>();
  }

  
  public int solution(int A, int B) {
    
    int sum = 0;
    if(A>B) {
      return 0;
    }
    int k= 1;
    for(int l = A; l <=B; l++) {
      if(j[k] == 0) {
        j[k] = k * (k+1);
      }
      if(j[k] ==l ) {
        sum+= 1;
      }
    }
    return sum;
  }
  public int sqrtSolution(int A, int B) {
    
    int sum = 0;
    if(A>B) {
      return 0;
    }
    for(int l = A; l <=B; l++) {
      long sqrt = Math.round(Math.sqrt(l));
      if((sqrt *(sqrt+1)) == l) {
        sum++;
      }
    }
    return sum;
  }
  private int isM(int product) {
    for(int i = 1;(i * (i+1)) <= product;i++) {
      if(j[i] == 0) {
        j[i] = i * (i+1);
      }
      if(j[i] ==product ) {
        return 1;
      }
      
    }
    return 0;
  }
  private int isMPresent(int product) {
    for(int i = 1;(i * (i+1)) <= product;i++) {

      if(lm.get(i) == null) {
        System.out.println(i + " * "+ (i+1)+ " = " +lm.get(i) );
        lm.put(i, Long.valueOf(i * (i+1)));
      }
      if(lm.get(i) ==product ) {
        return 1;
      }
      
    }
    return 0;
  }
  public static void main(String[] args) {
   NumberOfRectangular noOfProduct = new NumberOfRectangular();
   System.out.println("Soluction 6 & 20 ===>" + noOfProduct.sqrtSolution(6, 20));
   System.out.println("Soluction 21 & 29 ===>" + noOfProduct.sqrtSolution(21, 29));
   System.out.println("Soluction 21 & 29 ===>" + noOfProduct.sqrtSolution(1, 1000000000));
   // 
  }

}
