package com.EJC.src.task04_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    public static void main(String[] args) {
        Reverse main = new Reverse();
        main.printIsEquals();
    }

    void printIsEquals() {
        String inputWord = "";
        StringBuilder builderWord = new StringBuilder();
        System.out.println("Enter your word:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputWord = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputWord.replace(" ", "");
        builderWord = builderWord.append(inputWord);
        builderWord.reverse();
        System.out.println(inputWord.equals(builderWord.toString()));
    }
}
