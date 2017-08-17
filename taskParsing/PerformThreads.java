package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class PerformThreads {
    private volatile Map<String, Long> reportData = new ConcurrentHashMap<>();

    private ArrayList<File> getAllCsvFiles() {
        ArrayList<File> result = new ArrayList<>();
        File[] filesInFolder = Configs.DIRECTORY.listFiles();
        if (filesInFolder != null) {
            for (File file : filesInFolder) {
                if (file.toString().endsWith(Configs.EXTENSION)) {
                    result.add(file);
                }
            }
        }
        result.removeIf(o -> o.toString().endsWith(Configs.OUTPUT_NAME));
        return result;
    }

    private void performMultithreading() {
        ArrayList<File> csvFiles = getAllCsvFiles();
        int threadCount = Configs.THREAD_AMOUNT;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (File csvFile : csvFiles) {
            executorService.execute(new ParserThreads(csvFile, reportData));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        File outputFile = new File(Configs.DIRECTORY, Configs.OUTPUT_NAME);
        try (FileWriter output = new FileWriter(outputFile)) {
            output.write(Configs.HEADER + "\n");
            Map<String, Long> treeMap = new TreeMap<>(reportData);
            for (Map.Entry keyAndValue : treeMap.entrySet()) {
                output.write(keyAndValue.getKey() + Configs.DIVIDER + keyAndValue.getValue());
                output.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void perform() {
        performMultithreading();
        writeToFile();
    }
}
