package codility.ericsson._06_apr_2022;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NearestPositiveInteger {

  public NearestPositiveInteger() {
    // TODO Auto-generated constructor stub
  }

  public int solution(int[] A) {
    int i = 1;
    int smallestPositiveInteger=0;
    List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
    Collections.sort(numbers);
    if(numbers != null) {
      for(;i < 1000001;i++) {
        if(numbers.contains(i)) {
          continue;
        }else {
          smallestPositiveInteger = i;
          break;
        }
      }
    }
    return smallestPositiveInteger;
  }
  public static void main(String[] args) {
    NearestPositiveInteger nearest = new NearestPositiveInteger();
    System.out.println(nearest.solution(new int[] {1, 3, 6, 4, 1, 2}));
    System.out.println(nearest.solution(new int[] {1, 2, 3}));
    System.out.println(nearest.solution(new int[] {-1, -3}));
  }

}
