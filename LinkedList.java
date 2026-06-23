public class LinkedList {

    private Node head;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // Insertion at Start
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    // Insertion at last
    public void insertLast(int val) {

    Node node = new Node(val);

    if (head == null) {
        head = node;
        return;
    }

    Node temp = head;

    while (temp.next != null) {
        temp = temp.next;
    }

    temp.next = node;
    }

    // Recursive Insert
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {

        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // list.insertFirst(3);
        // list.insertFirst(2);
        // list.insertFirst(8);
        // list.insertFirst(9);

        // list.display();

        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(8);
        list.insertLast(9);

        list.display();

        list.insertRec(88, 2);

        list.display();
    }
}