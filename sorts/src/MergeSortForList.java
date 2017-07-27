package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeSortForList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Random myRnd = new Random();
            list.add(myRnd.nextInt(1000));
        }

        MergeSortForList mergeSortForList = new MergeSortForList();
        int startIndex = 0;
        int endIndex = list.size();
        list = mergeSortForList.doMergeSortList(list, startIndex, endIndex);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<Integer> doMergeSortList(List<Integer> list, int low, int high) {
        int difference = high - low;
        if (difference <= 1) {
            return list;
        }
        int mid = low + difference / 2;
        list = doMergeSortList(list, low, mid);
        list = doMergeSortList(list, mid, high);

        int[] temp = new int[difference];
        int i = low;
        int j = mid;
        for (int k = 0; k < difference; k++) {
            if (i == mid) {
                temp[k] = list.get(j++);
            } else if (j == high) {
                temp[k] = list.get(i++);
            } else if (list.get(j) < list.get(i)) {
                temp[k] = list.get(j++);
            } else {
                temp[k] = list.get(i++);
            }
        }
        for (int k = 0; k < difference; k++) {
            list.set(low + k, temp[k]);
        }
        return list;
    }

}
