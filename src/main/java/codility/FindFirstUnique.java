package codility;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FindFirstUnique {


    public int solution(int[] A) {
        // Implement your solution here
        Map<Integer,Integer> uniqueMap = new HashMap<>();
        for(int i = 0; i < A.length;i++){
            if(!uniqueMap.containsKey(A[i])){
                uniqueMap.put(A[i],i);
            }   else{
                uniqueMap.put(A[i],Integer.MAX_VALUE);
            }
        }
        Collection<Integer> values =  uniqueMap.values();
        values.removeIf(i -> i == Integer.MAX_VALUE);
        return ((values).size() > 0)?A[Collections.min(values)]:-1;
    }

    public static void main(String[] args) {
        FindFirstUnique findFirstUnique = new FindFirstUnique();
        System.out.println("unique Number = " +findFirstUnique.solution(IntStream.of(6, 4, 4, 6).toArray()));
        System.out.println("unique Number = " +findFirstUnique.solution(IntStream.of(1, 1, 1, 2, 3, 3, 3).toArray()));
    }
}
