import java.util.Scanner;

public class LinkedList {
     public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + "\t");
                temp = temp.next;
            }
            System.out.println("");
        }
    }

    public void insertBegin(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
             newNode.next = head;
             head = newNode;
        }
    }

    public void insertAt(int data, int pos) {
        Node newNode = new Node(data);

        if (pos == 0) {
            newNode.next = head;
            head = newNode;
        } else if(head == null && pos != 0) {
            System.out.println("List is empty, Choose 0 to insert first element or Alternative Options");
        } else {
            Node temp = head;
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
            temp.next = newNode;

            if (temp == tail) {
                tail = temp.next;
            }
        }
    }

    public void delete(int data) {
        Node temp = head, prev = null;

        if (temp != null && temp.data == data) {
            head = temp.next;
        } else {
            while (temp != null && temp.data != data) {
                prev = temp;
                temp = temp.next;
            }

            if(temp == null) {
                return;
            }

            if (temp == tail) {
                tail = prev;
                tail.next = null;
                return;
            }

            prev.next = temp.next;
        }
    }

    public int search(int data) {
        Node temp = head;
        int location = 0;

        if (temp.data == data) {
            return location;
        }

        while (temp != null && temp.data != data) {
            temp = temp.next;
            location++;
        }

        if(temp == null) {
            return  -1;
        }
        return location;
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

    public void reverse() {
        Node current = head, prev = null, next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        tail = head;
        head = prev;
    }

    public void displayHeadAndTail() {
        if (head == null) {
         System.out.println("List is empty");
         return;
        }
        System.out.println("Head is " + head.data);
        System.out.println("Tail is " + tail.data);
    }

    public static void main(String[] args) {
        System.out.println(".....Linked List.......");

        int choice;

        Scanner scanner = new Scanner(System.in);

        LinkedList list = new LinkedList();

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
                    System.out.println("Reversed List");
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
