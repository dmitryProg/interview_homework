import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.printEvenLetters();
    }

    void printEvenLetters() {
        String word = "";
        StringBuilder wordBuilder = new StringBuilder();
        System.out.println("Enter your word:");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            word = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 != 1) wordBuilder.append(word.charAt(i));
        }
        System.out.println(wordBuilder);
    }
}
