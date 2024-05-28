package player_communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Player implements Runnable {
    private int id;
    private int port;
    private int messageCounter = 0;
    private boolean initiator;
    private String peerHost;
    private int peerPort;
    private int receivedMessages = 0;
    private ServerSocket serverSocket; // Declare ServerSocket at class level

    public Player(int id, int port, boolean initiator, String peerHost, int peerPort) {
        this.id = id;
        this.port = port;
        this.initiator = initiator;
        this.peerHost = peerHost;
        this.peerPort = peerPort;
    }

    public void run() {
        try {
            while (true) {
                try {
                    serverSocket = new ServerSocket(port); // Initialize ServerSocket
                    break; // Break if binding is successful
                } catch (IOException e) {
                    System.err.println("Player " + id + " failed to bind to port " + port + ". Retrying...");
                    Thread.sleep(1000); // Wait for 1 second before retrying
                }
            }

            if (initiator) {
                Thread.sleep(2000);
                sendMessage(new Message("Hello", messageCounter));
                messageCounter++;
            }

            while (receivedMessages < 10) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream())) {
                    Message receivedMessage = (Message) input.readObject();
                    receivedMessages++;
                    System.out.println("Player " + id + " received: " + receivedMessage);

                    if (messageCounter < 10) {
                        sendMessage(new Message(receivedMessage.getContent(), messageCounter));
                        messageCounter++;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close(); // Close the ServerSocket
                    System.out.println("Player " + id + " closed the port.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMessage(Message message) {
        boolean sent = false;
        int attempts = 0;
        while (!sent && attempts < 5) {
            try (Socket socket = new Socket(peerHost, peerPort);
                 ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {
                output.writeObject(message);
                System.out.println("Player " + id + " sent: " + message);
                sent = true;
            } catch (SocketException e) {
                attempts++;
                System.err.println("Player " + id + " connection attempt " + attempts + " failed. Retrying...");
                try {
                    Thread.sleep(1000);  // Wait for 1 second before retrying
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
