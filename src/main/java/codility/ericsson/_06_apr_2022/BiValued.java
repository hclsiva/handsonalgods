package codility.ericsson._06_apr_2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiValued {

  public BiValued() {
    
  }
  public int solution(int[] A) {
    Map<Integer,Long> fc = new HashMap<Integer,Long>();
    for(int i:A) {
      Long v = fc.get(i);
      if(v == null) {
        v = 1L;
      } else {
        v +=1;
      }
      fc.put(i, v);
    }
    List<Long> values = new ArrayList<Long>(fc.values());
    Collections.sort(values);
    int largest = (int)((values.size() >0)?values.get(values.size()-1):0);
    int secondLargest =(int)((values.size() >1)?values.get(values.size()-2):0); 
    return largest + secondLargest;
  }
  public static void main(String[] args) {
    BiValued bi = new BiValued();
    System.out.println("Length = " + bi.solution(new int[] {4,2,2,4,2}));
    System.out.println("Length = " + bi.solution(new int[] {1,2,3,2}));
    System.out.println("Length = " +bi.solution(new int[] {0,5,4,4,5,12}));
    System.out.println("Length = " +bi.solution(new int[] {4,4}));
  }

}
