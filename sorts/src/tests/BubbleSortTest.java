import main.java.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void testIsCorrectBubbleSort() {
        int[] array = {1, 9, 3, 2, 8, 20};
        int[] testArray = {1, 2, 3, 8, 9, 20};
        BubbleSort bubbleSort = new BubbleSort();
        array = bubbleSort.doBubbleSort(array);
        Assert.assertArrayEquals(testArray, array);
    }
}
