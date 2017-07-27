package main.java;

import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            Random myRnd = new Random();
            array[i] = myRnd.nextInt(1000);
        }
        MergeSort mergeSort = new MergeSort();
        int startIndex = 0;
        int endIndex = array.length;

        array = mergeSort.doMergeSort(array, startIndex, endIndex);
        mergeSort.printArray(array);
    }

    public int[] doMergeSort(int[] array, int low, int high) {//int[] mergeSort(int[] arr, int low, int high) {
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

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
