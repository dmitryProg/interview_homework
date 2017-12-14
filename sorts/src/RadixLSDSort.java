import java.util.Arrays;

public class RadixLSDSort {
    public static void main(String[] args) {
        int[] array = UtilitsForSorts.createArray();

        UtilitsForSorts.printArray(doRadixLSDSort(array));
    }

    private static int[] doRadixLSDSort(int[] array) {
        int maxValue = getMaxInArray(array);
        for (int exp = 1; (maxValue / exp) > 0; exp *= 10) {
            countSort(array, exp);
        }
        return array;
    }

    private static void countSort(int[] array, int exp) {
        int[] outputArray = new int[array.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < array.length; i++) {
            count[(array[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            outputArray[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = outputArray[i];
        }
    }

    private static int getMaxInArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
