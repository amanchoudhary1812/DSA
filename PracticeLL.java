import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PracticeLL {

    static Node head = null;

    // Insert at End
    public static void insertLast(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // // Insert at Beginning
    // public static void insertFirst(int data) {

    //     Node newNode = new Node(data);

    //     newNode.next = head;
    //     head = newNode;
    // }

    // // Delete First Node
    // public static void deleteFirst() {

    //     if (head == null) {
    //         System.out.println("List is Empty");
    //         return;
    //     }

    //     head = head.next;
    // }

    // // Delete Last Node
    // public static void deleteLast() {

    //     if (head == null) {
    //         System.out.println("List is Empty");
    //         return;
    //     }

    //     if (head.next == null) {
    //         head = null;
    //         return;
    //     }

    //     Node secondLast = head;

    //     while (secondLast.next.next != null) {
    //         secondLast = secondLast.next;
    //     }

    //     secondLast.next = null;
    // }

    // // Search Element
    // public static boolean search(int key) {

    //     Node temp = head;

    //     while (temp != null) {

    //         if (temp.data == key) {
    //             return true;
    //         }

    //         temp = temp.next;
    //     }

    //     return false;
    // }

    // // Length of Linked List
    // public static int length() {

    //     int count = 0;

    //     Node temp = head;

    //     while (temp != null) {

    //         count++;
    //         temp = temp.next;
    //     }

    //     return count;
    // }

    // // Reverse Linked List
    // public static void reverse() {

    //     Node prev = null;
    //     Node current = head;

    //     while (current != null) {

    //         Node next = current.next;

    //         current.next = prev;

    //         prev = current;

    //         current = next;
    //     }

    //     head = prev;
    // }

    // // Display Linked List
    // public static void display() {

    //     if (head == null) {
    //         System.out.println("List is Empty");
    //         return;
    //     }

    //     Node temp = head;

    //     while (temp != null) {

    //         System.out.print(temp.data);

    //         if (temp.next != null) {
    //             System.out.print(" -> ");
    //         }

    //         temp = temp.next;
    //     }

    //     System.out.println();
    // }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Linked List
        System.out.print("Enter number of nodes: ");

        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            insertLast(sc.nextInt());
        }

        System.out.println("\nOriginal Linked List:");
        display();

        // Insert at Beginning
        System.out.print("\nEnter value to insert at beginning: ");
        insertFirst(sc.nextInt());

        display();

        // Insert at End
        System.out.print("\nEnter value to insert at end: ");
        insertLast(sc.nextInt());

        display();

        // Delete First
        deleteFirst();

        System.out.println("\nAfter deleting first node:");
        display();

        // Delete Last
        deleteLast();

        System.out.println("\nAfter deleting last node:");
        display();

        // Search
        System.out.print("\nEnter element to search: ");

        int key = sc.nextInt();

        if (search(key))
            System.out.println("Element Found");
        else
            System.out.println("Element Not Found");

        // Length
        System.out.println("\nLength of Linked List: " + length());

        // Reverse
        reverse();

        System.out.println("\nReversed Linked List:");
        display();

        sc.close();
    }
}