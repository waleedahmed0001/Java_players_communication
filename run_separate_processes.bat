@echo off
:: Compile the Java classes
javac -d out src\player_communication\*.java

:: Run Player1 and Player2 in separate command prompt windows
start cmd /k "java -cp out player_communication.Player1 && echo Press Enter to close this window... && pause"
start cmd /k "java -cp out player_communication.Player2 && echo Press Enter to close this window... && pause"
