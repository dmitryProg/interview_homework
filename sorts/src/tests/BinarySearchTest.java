import main.java.BinaryAndLinearSearch;
import main.java.MergeSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class BinarySearchTest {
    @Test
    public void testIsCorrectBinarySearch() {
        int[] array = new int[100];
        for (int i = 0; i < 99; i++) {
            Random myRnd = new Random();
            array[i] = myRnd.nextInt(1000);
        }
        Random myRnd = new Random();
        int searchValue = 1000;//myRnd.nextInt(1000);
        array[99] = searchValue;

        MergeSort mergeSort = new MergeSort();
        BinaryAndLinearSearch binarySearch = new BinaryAndLinearSearch();
        array = mergeSort.doMergeSort(array, 0, array.length);
        mergeSort.printArray(array);
        System.out.println("\nYour value is " + searchValue);

        Assert.assertEquals(99, binarySearch.findValueInArray(array, searchValue));
    }
}
