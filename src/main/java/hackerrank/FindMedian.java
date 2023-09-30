package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class FindMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        if (a == null){
            return null;
        }
        List<Double> medianList = new ArrayList<>();
        // Write your code here
        for(int i = 1; i<= a.size();i++) {
            List<Integer> b = new ArrayList<>(a.subList(0,i));
            Collections.sort(b);
            int mid = b.size()/2;
            medianList.add((b.size()%2 == 0) ? ( Double.valueOf(b.get(mid)) + Double.valueOf(b.get(mid-1)))/2: Double.valueOf(b.get(mid)));
        }
        return medianList;
    }
    public static void main(String[] args) {
        List<Integer> a = IntStream.of(12, 4, 5, 3, 8, 7).boxed().toList();
        System.out.println(runningMedian(a));
    }
}
