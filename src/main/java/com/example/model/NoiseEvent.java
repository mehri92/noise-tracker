package com.example.model;

import java.time.LocalDateTime;

public class NoiseEvent {
    private String type;
    private LocalDateTime timestamp;

    public NoiseEvent(String type) {
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        // Nur den Typ zurückgeben, kein Zeitstempel mehr
        return type;
    }
}