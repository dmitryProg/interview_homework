import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    @Test
    public void testIsCorrectInsertionSort() {
        Main main = new Main();
        List<Integer> testList = new ArrayList<>();
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            testList.add(9 - i);
        }
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        //array = main.quickSort(array, 0, 9);
        array = main.insertSort(array);

        for (int i = 0; i < array.length; i++) {
            list.set(9 - i, array[i]);
            //list.add(array[i]);
        }
        Assert.assertEquals(testList, list);
    }
}
