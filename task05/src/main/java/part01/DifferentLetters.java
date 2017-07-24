package main.java.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class DifferentLetters {
    public static void main(String[] args) {
        String wordNew = "";
        System.out.println("Enter your word:");
        Set<Character> set = new HashSet();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            wordNew = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < wordNew.length(); i++) {
            if (!Character.isAlphabetic(wordNew.charAt(i))) {
                set.add(wordNew.charAt(i));
            }
        }
        System.out.println(set.size());
    }
}
