package com.example.controller;

import com.example.model.NoiseEvent;
import com.example.util.FileLogger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoiseBean {
    private int readCounter(String logFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            return (int) reader.lines()
                    .filter(line -> !line.trim().isEmpty())
                    .count();
        } catch (IOException e) {
            return 0;
        }
    }

    public String logPoltern() {
        NoiseEvent event = new NoiseEvent("Poltern");
        int counter = readCounter("Polter_Log.txt") + 1;
        FileLogger.logEvent("Polter_Log.txt", event.toString(), counter);
        return null;
    }

    public String logMoebel() {
        NoiseEvent event = new NoiseEvent("Möbel verrücken");
        int counter = readCounter("Moebel_Geraeusche_Log.txt") + 1;
        FileLogger.logEvent("Moebel_Geraeusche_Log.txt", event.toString(), counter);
        return null;
    }
}