package player_communication;

import java.io.Serializable;

public class Message implements Serializable {
    private String content;
    private int counter;

    public Message(String content, int counter) {
        this.content = content;
        this.counter = counter;
    }

    public String getContent() {
        return content;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return content + " (" + counter + ")";
    }
}
