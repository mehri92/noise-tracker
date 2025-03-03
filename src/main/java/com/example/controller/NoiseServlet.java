package com.example.controller;

import com.example.model.NoiseEvent;
import com.example.util.FileLogger;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/noise")
public class NoiseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String type = req.getParameter("type");

        String logFile;
        String logMessage;
        int counter;

        if ("poltern".equals(type)) {
            logFile = "Polter_Log.txt";
            logMessage = "Poltern im Obergeschoss";
            counter = readCounter(logFile) + 1;
        } else {
            logFile = "Moebel_Geraeusche_Log.txt";
            logMessage = "Möbel verrücken im Obergeschoss";
            counter = readCounter(logFile) + 1;
        }

        NoiseEvent event = new NoiseEvent(logMessage);
        FileLogger.logEvent(logFile, event.toString(), counter);

        resp.sendRedirect(req.getContextPath() + "/");
    }

    private int readCounter(String logFile) {
        // Zähle Zeilen in der Logdatei
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(logFile))) {
            return (int) reader.lines()
                    .filter(line -> !line.trim().isEmpty())
                    .count();
        } catch (IOException e) {
            return 0;
        }
    }
}