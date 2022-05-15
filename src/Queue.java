import java.util.Scanner;

public class Queue {

    public class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node front, rear;

    public void display() {
        Node current = front;
        if (front == null) {
            System.out.println("Queue is Empty");
        }

        while (current != null) {
            System.out.print(current.data + "\t");
            current = current.next;
        }

        System.out.println();
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void dequeue() {
        if(front == null) {
            System.out.println("Queue is empty");
            return;
        }

        front = front.next;

        // Front will be null when last element deleted.
        if(front == null) {
            rear = null;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("......Queue......");

        while (true) {
            System.out.println("1. Display");
            System.out.println("2. Enqueue");
            System.out.println("3. Dequeue");
            System.out.println("Press 0 to exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    queue.display();
                    break;
                case 2:
                    System.out.println("How elements to push ");
                    int n = scanner.nextInt();
                    System.out.println(String.format("Enter %d elements to Push", n));
                    for (int i = 0; i < n; i++) {
                        queue.enqueue(scanner.nextInt());
                    }
                    break;
                case 3:
                    queue.dequeue();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }

}
