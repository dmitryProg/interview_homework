import main.java.SelectionSort;
import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void testIsCorrectSelectionSort() {
        int[] array = {1, 9, 3, 2, 8, 20};
        int[] testArray = {1, 2, 3, 8, 9, 20};
        SelectionSort selectionSort = new SelectionSort();
        array = selectionSort.doSelectionSort(array);
        Assert.assertArrayEquals(testArray, array);
    }
}
