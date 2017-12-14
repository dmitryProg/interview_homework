public class InsertionSort {
    public static void main(String[] args) {
        int[] array = UtilitsForSorts.createArray();
        int startIndex = 0;
        int endIndex = array.length - 1;

        UtilitsForSorts.printArray(doInsertionSort(array));
    }

    private static int[] doInsertionSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
}
