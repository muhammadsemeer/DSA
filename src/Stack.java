import java.util.Scanner;

public class Stack {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node top;

    public void display() {
        Node current = top;

        if(current == null) {
            System.out.println("Stack Underflow");
        }

        while (current != null) {
            System.out.print(current.data + "\t");
            current = current.next;
        }

        System.out.println();
    }

    public void push(int data) {
        Node newNode = new Node(data);

        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
    }

    public void pop() {
        if(top == null) {
            System.out.println("Stack Underflow");
            return;
        }

        top = top.next;
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("......Stack......");

        while (true) {
            System.out.println("1. Display");
            System.out.println("2. Push");
            System.out.println("3. Pop");
            System.out.println("Press 0 to exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    stack.display();
                    break;
                case 2:
                    System.out.println("How elements to push ");
                    int n = scanner.nextInt();
                    System.out.println(String.format("Enter %d elements to Push", n));
                    for (int i = 0; i < n; i++) {
                        stack.push(scanner.nextInt());
                    }
                    break;
                case 3:
                    stack.pop();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }

}
