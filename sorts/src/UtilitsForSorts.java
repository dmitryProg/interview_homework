import java.util.Random;

public class UtilitsForSorts {

    static void printArray(int[] array) {
        for (int element : array) {
            System.out.println(element);
        }
    }

    static int[] createArray() {
        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            Random myRnd = new Random();
            array[i] = myRnd.nextInt(1000);
        }
        return array;
    }
}
