package main.java;

public class BinaryAndLinearSearch {
    public static void main(String[] args) {
        int[] arrSortedForSearch = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11};
        BinaryAndLinearSearch search = new BinaryAndLinearSearch();
        System.out.println(search.findValueInArray(arrSortedForSearch, 4));
    }

    public int binarySearch(int[] array, int key, int min, int max) {
        int midPoint = (min + max) / 2;
        if (array[midPoint] < key) {
            return binarySearch(array, key, midPoint + 1, max);
        } else if (array[midPoint] > key) {
            return binarySearch(array, key, min, midPoint - 1);
        } else if (array.length == 0) {
            return -1;
        } else {
            return midPoint;
        }
    }

    public int linearSearch(int[] array, int key) {
        int resultIndex = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                resultIndex = i;
                break;
            }
        }
        if (resultIndex == Integer.MIN_VALUE) {
            throw new IllegalArgumentException();
        }
        return resultIndex;
    }

    public int findValueInArray(int[] arrSortedForSearch, int searchKey) {
        System.out.println("Please enter your key VALUE for search:");
        int foundKeyIndex = -1;
        int startIndex = 0;
        int endIndex = arrSortedForSearch.length;

        foundKeyIndex = binarySearch(arrSortedForSearch, searchKey, startIndex, endIndex);
        if (foundKeyIndex == -1) {
            System.out.println("There's no such value in the array!!!");
            return foundKeyIndex;
        }

        System.out.println("The INDEX of the searched key in array was found: "
                + foundKeyIndex);
        return foundKeyIndex;
    }
}
