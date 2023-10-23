package codility.toptal;

import java.math.BigDecimal;

//Online Coding test

public class CoinChange {

  private static int[] d = new int[] {1,5,10,25,50,100};
  public CoinChange() {
    
  }
  
  public int[] getChange(BigDecimal M, BigDecimal p) {
    
    int[] c = new int[6];


    BigDecimal change = M.subtract(p);
    System.out.println("change " + change );
    int temp = change.multiply(BigDecimal.valueOf(100)).intValue(); 
    
    for(int i = d.length-1 ; i >=0 ;i--) {
      if(temp >0) {
        c[i] = temp / d[i];
      }
      temp = temp % d[i];
    }
    return c;
    
  }
  public static void main(String[] args) {
    CoinChange c = new CoinChange();
    print(c.getChange(valueOf(5), valueOf(0.99)));
    System.out.println();
    print(c.getChange(valueOf(3.14), valueOf(1.99)));
    System.out.println();
    print(c.getChange(valueOf(4), valueOf(3.14)));
    System.out.println();
    print(c.getChange(valueOf(0.45), valueOf(0.34)));
  }
  public static BigDecimal valueOf(double d) {
    return BigDecimal.valueOf(d);
  }
  public static void print(int[] result) {
    for (int i = 0; i < result.length; i++) {
      if(result[i] > 0) {
        System.out.println("coin = " + d[i] + " value = " + result[i]);
      }
    }
  }
}
