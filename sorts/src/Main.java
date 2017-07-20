import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    int[] array;

    public static void main(String[] args) {
        Main main = new Main();
        main.sort();
    }

    public void sort() {
        List<Integer> list = new ArrayList<>();
        //list = writeListQuickSort(list);
        list = writeListInsertionSort(list);

        System.out.println("Your list is");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
        this.array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.array[i] = list.get(i);
        }

        //quickSort(0, this.array.length - 1);
        array = insertSort(array);

        for (int i = 0; i < this.array.length; i++) {
            list.set(i, this.array[i]);
        }

        System.out.println("\nYour sorted list is");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
    }

    public int[] quickSort(int[] array, int startI, int endI) {//quickSort(int startI, int endI)
        int mid = this.array[startI + (endI - startI) / 2];
        int i = startI;
        int j = endI;
        int temp;
        while (i <= j) {
            while (this.array[i] < mid) i++;
            while (this.array[j] > mid) j--;
            if (i <= j) {
                temp = this.array[i];
                this.array[i] = this.array[j];
                this.array[j] = temp;
                i++;
                j--;
            }
        }
        if (startI < j) {
            quickSort(this.array, startI, j);//startI, j
        }
        if (i < endI) {
            quickSort(this.array, i, endI);//i, endI
        }
        return array;//
    }

    public int[] insertSort(int[] array) {//it works
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

    public List<Integer> writeListQuickSort(List<Integer> list) {
        System.out.println("Enter 25 values please ");
        int counter = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 25; i++) {
            try {
                list.add(Integer.parseInt(reader.readLine()));
                counter++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Integer> writeListInsertionSort(List<Integer> list) {
        /*for (int i = 0; i < 100; i++) {
            Random myRnd = new Random();
            list.add(myRnd.nextInt(1000));
        }*/
        for (int i = 0; i < 10; i++) {
            list.add(10 - i);
        }
        return list;
    }
}
