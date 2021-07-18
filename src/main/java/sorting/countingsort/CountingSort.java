package sorting.countingsort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountingSort {
    static final Logger log = LoggerFactory.getLogger(CountingSort.class);
    public int[] sort(int[] inputArray){
        int[] noOfOccurences = new int[10];
        log.info("Length of an Input array = " +inputArray.length);
        int[] sortedArray = new int[inputArray.length];
        updateOccurences(inputArray,noOfOccurences);
        printArrayWithIndices(noOfOccurences);
        increamentAndShiftAdjacentIndexes(noOfOccurences);
        printArrayWithIndices(noOfOccurences);
        placeValuesInSortedIndex(noOfOccurences,inputArray,sortedArray);
        printArray(sortedArray);
        return sortedArray;
    }
    private void updateOccurences(int[] inputArray,int[] noOfOccurences){
        for(int v:inputArray){
            noOfOccurences[v]++;
        }
    }
    private void increamentAndShiftAdjacentIndexes(int[] noOfOccurences){
        for(int i = 1; i < noOfOccurences.length;i++){
            noOfOccurences[i] = noOfOccurences[i-1]+noOfOccurences[i];
        }
        printArrayWithIndices(noOfOccurences);
        for(int i = noOfOccurences.length-2;i >=0 ;i-- ){
            noOfOccurences[i+1] = noOfOccurences[i];
        }
    }
    private void placeValuesInSortedIndex(int[] noOfOccurences,int[] inputArray,int[] outputArray){
        for(int i = 0; i < inputArray.length;i++){
            outputArray[noOfOccurences[inputArray[i]]] = inputArray[i];
            noOfOccurences[inputArray[i]]++;
        }
    }
    public void printArrayWithIndices(int[] values){
        for(int i =0; i < values.length; i++){
            log.info(i + " - " +values[i]);
        }
        log.info("");
    }
    public void printArray(int[] values){
        for(int i =0; i < values.length; i++){
            log.info(""+values[i]);
        }
        log.info("");
    }
    public static void main(String[] args){
        int[] inputArray = new int[]{2,3,3,4,5,5,6,6,7,7,1,6,1,3,8,9,8,1,2};
        CountingSort sorting = new CountingSort();
        sorting.sort(inputArray);
    }
}
