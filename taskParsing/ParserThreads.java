package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ParserThreads extends Thread {
    private File fileParsing;
    private Map<String, Long> fileData;

    ParserThreads(File fileForParsing, Map<String, Long> fileData) {
        this.fileParsing = fileForParsing;
        this.fileData = fileData;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileParsing))) {
            String stringFileRow;
            reader.readLine();

            while ((stringFileRow = reader.readLine()) != null) {
                String[] stringData = stringFileRow.split(Configs.DIVIDER);
                String urlFile = stringData[1];
                long timeFile = Long.parseLong(stringData[2]);
                String userFile = stringData[3];
                fileData.merge(userFile + Configs.DIVIDER + urlFile,
                        timeFile, (oldTime, newTime) -> oldTime + newTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
