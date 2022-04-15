import java.util.Scanner;

public class DoublyLinkedList {

    public class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
            //  Handle any exceptions.
        }
    }


    public Node head = null, tail = null;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;
    }

    public void display() {
        Node temp = head;

        if(temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

    void insertBegin(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAt(int data, int pos) {
        Node newNode = new Node(data), temp = head;

        if(pos == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if(head == null && pos != 0) {
            System.out.println("List is empty, Choose 0 to insert first element or Alternative Options");
        } else {
            int count = 0;

            while (count < pos - 1 && temp != null) {
                temp = temp.next;
                count++;
            }

            if (temp == null) {
                int currentCount = count();
                System.out.println("Cannot Insert at this position, Current Last position is " + (currentCount - 1));
                return;
            }

            newNode.next = temp.next;
            newNode.prev = temp;
            temp.prev = newNode;
            temp.next = newNode;

            if (temp == tail) {
                tail = temp.next;
            }
        }
    }

    public void displayHeadAndTail() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Head is " + head.data);
        System.out.println("Tail is " + tail.data);
    }

    public int count() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    public void delete(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        if (temp == head) {
            head = temp.next;
            temp.prev = null;

            return;
        }

        if (temp == tail) {
            tail = temp.prev;
            tail.next = null;

            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return;

    }

    public int search(int value) {
        Node temp = head;
        int position = 0;

        while (temp != null && temp.data != value) {
            temp = temp.next;
            position++;
        }

        if (temp == null) {
            return -1;
        }

        return position;
    }

    public void reverse() {
        Node current = head, prev = null, next = null;

        while (current != null) {
            next = current.next;
            current.prev = next;
            current.next = prev;
            prev = current;
            current = next;
        }

        tail = head;
        head = prev;
    }

    public static void main(String[] args) {
        clearConsole();
        System.out.println(".....Doubly Linked List.......");

        int choice;

        Scanner scanner = new Scanner(System.in);

        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            System.out.println("\nChoose any operation");
            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Insert at Beginning");
            System.out.println("4. Insert at specific position");
            System.out.println("5. Delete a specific value");
            System.out.println("6. Search a value");
            System.out.println("7. Get Count of list elements");
            System.out.println("8. Reverse the List");
            System.out.println("9. Display Head and Tail");
            System.out.println("Press 0 to exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("How many elements do you want to add");
                    int n = scanner.nextInt();
                    for (int i = 1; i <= n; i++) {
                        System.out.println("Enter value for element " + i);
                        list.add(scanner.nextInt());
                    }
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.println("Enter a Value to Insert");
                    list.insertBegin(scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Enter Position");
                    int pos = scanner.nextInt();
                    System.out.println("Enter the value");
                    int data = scanner.nextInt();
                    list.insertAt(data, pos);
                    break;
                case 5:
                    System.out.println("Enter a Value to delete");
                    list.delete(scanner.nextInt());
                    break;
                case 6:
                    System.out.println("Enter a value to search");
                    int result = list.search(scanner.nextInt());

                    if (result == -1) {
                        System.out.println("Item not found in the list");
                    } else {
                        System.out.println("Item found at " + result);
                    }
                    break;
                case 7:
                    System.out.println("Count is " + list.count());
                    break;
                case 8:
                    System.out.println("Current List");
                    list.display();
                    list.reverse();
                    System.out.println("\nReversed List");
                    list.display();
                    break;
                case 9:
                    list.displayHeadAndTail();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
}
