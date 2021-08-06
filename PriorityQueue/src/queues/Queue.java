package queues;

public class Queue {

    private String letter;
    private int priority;

    public Queue(String letter, int priority) {
        this.letter = letter;
        this.priority = priority;
    }

    public String getLetter() {
        return letter;
    }

    public int getPriority() {
        return priority;
    }

    public void getLetter(String number) {
        this.letter = number;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
