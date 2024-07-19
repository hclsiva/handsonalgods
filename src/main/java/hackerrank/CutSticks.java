package hackerrank;

import java.util.*;
import java.util.stream.IntStream;

public class CutSticks {
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        List<Integer> list = new ArrayList<>(arr);
        Integer min = Collections.min(list);
        List<Integer> result = new ArrayList<>();
        int i = 0, j=0;
        while(list.size() > 0){
            if(i >= list.size()){
                result.add(j);
                Iterator<Integer> intIterator = list.iterator();
                while(intIterator.hasNext()){
                    int k = intIterator.next();
                    if(k <=0){
                        intIterator.remove();
                    }
                }
                i = 0;
                j = 0;
                if(list.size() > 0)
                    min = Collections.min(list);
                else
                    break;
            }
            int item = list.get(i);
            if(item >=min){
                list.set(i,item-min);
                j++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        CutSticks cutSticks = new CutSticks();
        List<Integer> arr = List.of(5,4,4,2,2,8);
        List<Integer> result = cutSticks.cutTheSticks(arr);
        System.out.println(result);
        System.out.println();
        System.out.println();
        arr = List.of(1,2,3,4,3,3,2,1);
        result = cutSticks.cutTheSticks(arr);
        System.out.println(result);
    }
}
