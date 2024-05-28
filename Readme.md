# Player Communication Project

This project demonstrates a simple communication system between two players using Java sockets. The project includes two main scenarios:

 - Running both players in the same Java process.
 - Running each player in separate Java processes.


## Project Structure:
Java Project/ <br>
├── src/<br>
│ └── player_communication/<br>
│ ├── Player.java<br>
│ ├── Player1.java<br>
│ ├── Player2.java<br>
│ └── Main.java<br>
├── out/<br>
├── run_same_process.bat<br>
├── run_separate_processes.bat<br>
└── README.md<br>



## Prerequisites:
- Java Development Kit (JDK) installed
- Windows OS

## Detailed Explanation:
**Player.java**  
This class handles the communication logic for each player.

**Player1.java**  
This class initializes Player1 with specific parameters and starts its execution.

**Player2.java**  
This class initializes Player2 with specific parameters and starts its execution.

**Main.java**  
This class is used to run both Player1 and Player2 in the same Java process using separate threads.

**run_same_process.bat**  
This batch script is used to compile the Java classes and run both Player1 and Player2 in the same Java process.

**run_separate_processes.bat**  
This batch script is used to compile the Java classes and run Player1 and Player2 in separate command prompt windows.

## Notes:
- Ensure that the ports (5001 and 5002) used by the players are not in use by other applications to avoid `java.net.BindException: Address already in use` errors.
- If you encounter issues with ports being in use, you may need to free the ports by stopping any applications that are using them.

## How to Run the Project

### Running Both Players in the Same Java Process

1. Open a terminal or command prompt.
2. Navigate to the project directory.
3. Compile the Java files and run the main class using the batch script:
   ```sh
   run_same_process.bat

## Output:
![image desc](https://github.com/waleedahmed0001/Java_players_communication/blob/main/Output/sameprocess.PNG)


### Running Each Player in Separate Java Processes
1. Open a terminal or command prompt.
2. Navigate to the project directory.
3. Compile the Java files and run the players in separate command prompt windows using the batch script:
   ```sh
run_separate_processes.bat

## Output:
![image desc](https://github.com/waleedahmed0001/Java_players_communication/blob/main/Output/separate_process.PNG)
