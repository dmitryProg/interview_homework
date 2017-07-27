import main.java.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testIsCorrectMergeSort() {
        int[] array = {1, 9, 3, 2, 8, 20};
        int[] testArray = {1, 2, 3, 8, 9, 20};
        MergeSort mergeSort = new MergeSort();
        array = mergeSort.doMergeSort(array, 0, array.length);
        Assert.assertArrayEquals(testArray, array);
    }
}
