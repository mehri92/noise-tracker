# Noise Tracker

## Overview
Web application to track noise events with real-time counters and logging.

## Features
- Log noise types ("Poltern", "Möbel verrücken")
- Real-time counter tracking
- Automatic midnight reset
- Manual reset option
- Automatic log file generation
    - Creates separate log files for each noise type
    - Logs include timestamp, event type, and running counter
    - Log files are generated dynamically in the project directory

## Log File Behavior
- `Polter_Log.txt`: Logs "Poltern" events
- `Moebel_Geraeusche_Log.txt`: Logs "Möbel verrücken" events
- Each log entry includes:
    - Timestamp
    - Event description
    - Consecutive event number

## Technologies
- Java
- Jakarta Servlet
- HTML/JavaScript
- Bootstrap

## Setup
1. Clone repository
2. Open in IDE (e.g. IntelliJ Idea, VSCode, etc.)
3. Deploy to servlet container

## Usage
- Click buttons to log noise events
- Counters reset at midnight or manually