package main.java;

import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            Random myRnd = new Random();
            array[i] = myRnd.nextInt(1000);
        }
        SelectionSort selectionSort = new SelectionSort();
        array = selectionSort.doSelectionSort(array);
        selectionSort.printArray(array);
    }

    public int[] doSelectionSort(int[] array) {
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

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
