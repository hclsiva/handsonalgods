package sorting.countingsort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        return null;
    }
    private int[] getOneMillionEntries(){
        return null;
    }
    @Test
    @DisplayName("Counting Sort with Simple input")
    public void testCountingSortSimpleInput(){
        int[] inputArray=getSimpleEntries();
        int[] expectedOutput = new int[]{1,1,1,2,2,3,3,3,4,5,5,6,6,6,7,7,8,8,9};
        int[] output = sorting.sort(inputArray);
        assertArrayEquals(output,expectedOutput);
    }
}
