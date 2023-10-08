package codility.ericsson._06_apr_2022;

import java.util.HashMap;
import java.util.Map;

public class Fk {

  public Fk() {
    // TODO Auto-generated constructor stub
  }
  public int solution(int N) {
    Map<Long,Long> memoized = new HashMap<Long,Long>();
    memoized.put(0L,0L);
    long r = 0;
    long k = 1;
    for(; k < 1000000000 && r <= N;k++) {
      r = memoized.get(k-1)+k;
      memoized.put((long)k, r);       
    }
    
    return ((int)(k-2));
  }
  
  public static void main(String[] args) {
      Fk f = new Fk();
      System.out.println(f.solution(10));
  }

}
