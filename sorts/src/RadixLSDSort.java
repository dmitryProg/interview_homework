package main.java;

import java.util.Arrays;
import java.util.Random;

public class RadixLSDSort {
    public static void main(String[] args) {
        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            Random myRnd = new Random();
            array[i] = myRnd.nextInt(1000);
        }
        RadixLSDSort radixLSDSort = new RadixLSDSort();
        array = radixLSDSort.doRadixLSDSort(array);
        radixLSDSort.printArray(array);
    }

    public int[] doRadixLSDSort(int[] array) {
        int maxValue = getMaxInArray(array);
        for (int exp = 1; (maxValue / exp) > 0; exp *= 10) {
            countSort(array, exp);
        }
        return array;
    }

    public void countSort(int[] array, int exp) {
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

    public int getMaxInArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
