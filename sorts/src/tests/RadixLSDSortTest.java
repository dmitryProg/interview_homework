import main.java.RadixLSDSort;
import org.junit.Assert;
import org.junit.Test;

public class RadixLSDSortTest {
    @Test
    public void testIsCorrectRadixLSDSort() {
        int[] array = {1, 9, 3, 2, 8, 20};
        int[] testArray = {1, 2, 3, 8, 9, 20};
        RadixLSDSort radixLSDSort = new RadixLSDSort();
        array = radixLSDSort.doRadixLSDSort(array);
        Assert.assertArrayEquals(testArray, array);
    }
}
