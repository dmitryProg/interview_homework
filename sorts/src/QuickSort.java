public class QuickSort {
    public static void main(String[] args) {
        int[] arr = UtilitsForSorts.createArray();
        int startIndex = 0;
        int endIndex = arr.length - 1;

        UtilitsForSorts.printArray(doQuickSort(arr, startIndex, endIndex));
    }

    private static int[] doQuickSort(int[] array, int startI, int endI) {
        int mid = array[startI + (endI - startI) / 2];
        int i = startI;
        int j = endI;
        int temp;
        while (i <= j) {
            while (array[i] < mid) i++;
            while (array[j] > mid) j--;
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (startI < j) {
            doQuickSort(array, startI, j);
        }
        if (i < endI) {
            doQuickSort(array, i, endI);
        }
        return array;
    }
}
