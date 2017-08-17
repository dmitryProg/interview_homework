package main.java;

import java.io.*;
import java.util.ArrayList;

class CsvFilesGenerator {
    private static String file_name = Configs.DIR_STRING + "\\docs.csv";

    public static void main(String[] args) {
        CsvFilesGenerator gen = new CsvFilesGenerator();
        try {
            FileInputStream names = new FileInputStream(Configs.DIR_STRING + "\\sitesBase.txt");
            DataInputStream in = new DataInputStream(names);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            FileWriter offStream = new FileWriter(file_name);

            BufferedWriter out = new BufferedWriter(offStream);
            ArrayList<String> data = new CsvFilesGenerator().inputData(br);

            br.close();
            gen.dataGeneration(out, data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> inputData(BufferedReader bufferedReader) {
        String strLine;
        ArrayList<String> words = new ArrayList<>();
        try {
            while ((strLine = bufferedReader.readLine()) != null) {
                words.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    private String stringGeneration(ArrayList<String> nameData) {
        int random_number = 100 + (int) (Math.random() * 901);
        int random_number2 = (int) (Math.random() * 11);
        int random_number3 = 11 + (int) (Math.random() * 11);
        int random_number4 = (int) (Math.random() * 1000000001);

        String sites = nameData.get(random_number3);
        String names = nameData.get(random_number2);
        return random_number + ";" + sites + ";" + random_number4 + ";" + names;
    }

    private void dataGeneration(BufferedWriter bufferedWriter, ArrayList<String> nameData) {
        try {
            String mainLine = "id;url;time;user";
            bufferedWriter.write(mainLine + "\n");
            for (int i = 0; i < 10; i++) {
                String string = stringGeneration(nameData);
                bufferedWriter.write(string + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
