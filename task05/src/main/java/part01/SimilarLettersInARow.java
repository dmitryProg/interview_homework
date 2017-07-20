package main.java.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimilarLettersInARow {
    public static void main(String[] args) {
        String wordNew = "";
        int counter = 0;
        System.out.println("Enter your word:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            wordNew = reader.readLine();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("Exception e!");
        }

        for (int i = 0; i <  wordNew.length(); i++) {
            if (i !=  0) {
                if ( wordNew.charAt(i - 1) ==  wordNew.charAt(i)) {
                    counter ++;
                }
            }
            else if ( wordNew.charAt(i ) ==  wordNew.charAt(i + 1)) {
                counter ++;
            }
        }
        System.out.println(counter);
    }
}
