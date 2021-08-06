package queues;

import java.util.ArrayList;
import java.util.Scanner;

public class Queues {

    public static ArrayList<Queue> QueueList = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Please selcect an option");
        System.out.println("1: Add item to queue");
        System.out.println("2: Remove item to queue");
        int choose;

        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Invalid");
        }
        choose = input.nextInt();

        System.out.println("");
        switch (choose) {
            case (1):
                EnQueue();
                main(args);
                break;
            case (2):
                DeQueue();
                main(args);
                break;

            default:

                System.out.println("Invalid");

                main(args);
                break;
        }
    }

    public static void DeQueue() {
        if (!QueueList.isEmpty()) {
            System.out.println("Removed :" + QueueList.get(QueueList.size() - 1).getLetter());
            QueueList.remove(QueueList.size() - 1);
            System.out.println("");
            System.out.println("Queue (Item, Priority):");
            for (int i = 0; i < QueueList.size(); i++) {
                String front = (QueueList.get(i).getLetter());
                int back = (QueueList.get(i).getPriority());
                System.out.print("(" + front + "," + back + ")");
                System.out.println("");
            }
        } else {
            System.out.println("Queue is Empty");
        }
    }

    public static void EnQueue() {
        int letterCurrentNum = QueueList.size();
        int PriorityInput = 0;
        System.out.println("");
        System.out.println("Priority of " + toAlphabetic(letterCurrentNum) + ":");

        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Invalid");
        }
        PriorityInput = input.nextInt();

        if (PriorityInput < 1) {
            System.out.println("Invalid");
            EnQueue();
        }

        Queue q = new Queue(toAlphabetic(letterCurrentNum), PriorityInput);
        insertiosort(q);
        System.out.println("");
        System.out.println("Queue:");
        for (int i = 0; i < QueueList.size(); i++) {
            String front = (QueueList.get(i).getLetter());
            int back = (QueueList.get(i).getPriority());
            System.out.print("(" + front + "," + back + ")");
            System.out.println("");
        }
    }

    public static String toAlphabetic(int i) {
        int div = i / 26;
        int rem = i % 26;
        char letter = (char) ((int) 'A' + rem);
        if (div == 0) {
            return "" + letter;
        } else {
            return toAlphabetic(div - 1) + letter;
        }
    }

    public static void insertiosort(Queue q) {

        if (QueueList.isEmpty()) {
            QueueList.add(q);
        } else {
            int i = 0;
            while (i < QueueList.size() + 1) {

                if (q.getPriority() < QueueList.get(i).getPriority()) {
                    i++;
                    if (i >= QueueList.size()) {
                        QueueList.add(q);
                        i = QueueList.size() + 2;
                    }
                } else {

                    QueueList.add(i, q);
                    i = QueueList.size() + 2;

                }

            }
        }
    }
}
