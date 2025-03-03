package com.example.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    public static void logEvent(String filename, String content, int counter) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = String.format("[%s] - %s (#%d)", timestamp, content, counter);

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}