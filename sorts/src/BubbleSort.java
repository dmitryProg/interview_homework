public class BubbleSort {
    public static void main(String[] args) {
        int[] array = UtilitsForSorts.createArray();

        UtilitsForSorts.printArray(doBubbleSort(array));
    }

    private static int[] doBubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; (j >= 1) && (array[j] < array[j - 1]); j--) {
                int num = array[j];
                array[j] = array[j - 1];
                array[j - 1] = num;
            }
        }
        return array;
    }
}
