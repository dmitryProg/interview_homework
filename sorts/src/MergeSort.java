public class MergeSort {
    public static void main(String[] args) {
        int[] array = UtilitsForSorts.createArray();
        int startIndex = 0;
        int endIndex = array.length;

        UtilitsForSorts.printArray(doMergeSort(array, startIndex, endIndex));
    }

    private static int[] doMergeSort(int[] array, int low, int high) {
        int difference = high - low;
        if (difference <= 1) {
            return array;
        }
        int mid = low + difference / 2;
        array = doMergeSort(array, low, mid);
        array = doMergeSort(array, mid, high);

        int[] temp = new int[difference];
        int i = low;
        int j = mid;
        for (int k = 0; k < difference; k++) {
            if (i == mid) {
                temp[k] = array[j++];
            } else if (j == high) {
                temp[k] = array[i++];
            } else if (array[j] < array[i]) {
                temp[k] = array[j++];
            } else {
                temp[k] = array[i++];
            }
        }
        for (int k = 0; k < difference; k++) {
            array[low + k] = temp[k];
        }
        return array;
    }
}
