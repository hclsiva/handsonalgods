package sorting.countingsort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.Arrays;

public class TestCountingSort {
    CountingSort sorting = null;

    @BeforeEach                                         
    public void setUp() throws Exception {
        sorting = new CountingSort();
    }
    private int[] getSimpleEntries() {
        int[] inputArray = new int[]{2,3,3,4,5,5,6,6,7,7,1,6,1,3,8,9,8,1,2};
        return inputArray;
    }
    private int[] getOneThousandEntries(){
        int[] unsortedArray = generateRandomNumber(1,9,1000);
        return unsortedArray;
    }
    private int[] getOneMillionEntries(){
        int[] unsortedArray = generateRandomNumber(1,9,10000000);
        return unsortedArray;
    }
    private int[] generateRandomNumber(int min, int max,int size){
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for(int i = 0; i < size;i++) {
            int temp = random.nextInt(max - min +1 ) + min; 
            unsortedArray[i]= temp;
        }
        return unsortedArray;
    }
    @Test
    @DisplayName("Counting Sort with Simple input")
    public void testCountingSortSimpleInput(){
        int[] inputArray=getSimpleEntries();
        int[] expectedOutput = new int[]{1,1,1,2,2,3,3,3,4,5,5,6,6,6,7,7,8,8,9};
        int[] output = sorting.sort(inputArray);
        assertArrayEquals(output,expectedOutput);
    }
    @Test
    @DisplayName("Counting Sort with One Thousand Entries")
    public void testCountingSortWithOneThousandInput(){
        int[] unsortedArray = getOneThousandEntries();
        int[] countingSortOutput = sorting.sort(unsortedArray);
        Arrays.sort(unsortedArray);
        int[] expectedOutput = unsortedArray;
        assertArrayEquals(countingSortOutput,expectedOutput);
    }
    @Test
    @DisplayName("Counting Sort with One Million Entries")
    public void testCountingSortWithOneMillionInput(){
        int[] unsortedArray = getOneThousandEntries();
        int[] countingSortOutput = sorting.sort(unsortedArray);
        //Arrays.sort(unsortedArray);
        //int[] expectedOutput = unsortedArray;
        assertArrayEquals(countingSortOutput,unsortedArray);
    }
}
