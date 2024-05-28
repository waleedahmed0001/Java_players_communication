package player_communication;

public class Main {
    public static void main(String[] args) {
        Thread player1 = new Thread(new Player(1, 5001, true, "localhost", 5002));
        Thread player2 = new Thread(new Player(2, 5002, false, "localhost", 5001));
        
        player1.start();
        player2.start();
        
        try {
            player1.join();
            player2.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
