public class SelectionSort {
    public static void main(String[] args) {
        int[] array = UtilitsForSorts.createArray();

        UtilitsForSorts.printArray(doSelectionSort(array));
    }

    private static int[] doSelectionSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            int minValIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minValIndex])
                    minValIndex = j;
            }
            temp = array[i];
            array[i] = array[minValIndex];
            array[minValIndex] = temp;
        }
        return array;
    }
}
