package main.java;

public class Main{
    public static void main(String[] args) {
        int[] arr = {1, 3, 33, 3, 8, 5, 46, 7, 9, 2};
        int startIndex = 0;
        int endIndex = arr.length - 1;
        Main main = new Main();

        //arr = main.insertionSort(arr);
        //arr = main.quickSort(arr, startIndex, endIndex);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] quickSort(int[] array, int startI, int endI) {
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
            quickSort(array, startI, j);
        }
        if (i < endI) {
            quickSort(array, i, endI);
        }
        return array;
    }



    public int[] insertionSort(int[] array) {//it works
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
