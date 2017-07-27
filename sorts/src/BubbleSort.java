package main.java;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            Random myRnd = new Random();
            array[i] = myRnd.nextInt(1000);
        }

        BubbleSort bubbleSort = new BubbleSort();
        array = bubbleSort.doBubbleSort(array);
        bubbleSort.printArray(array);
    }

    public int[] doBubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; (j >= 1) && (array[j] < array[j - 1]); j--) {
                int num = array[j];
                array[j] = array[j - 1];
                array[j - 1] = num;
            }
        }
        return array;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
