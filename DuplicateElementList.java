//WAP to remove all the duplicate elements from linked list without sorting

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void removeDuplicates() {
        if (head == null) return;
        Set<Integer> set = new HashSet<>();
        Node prev = null, current = head;
        while (current != null) {
            if (!set.contains(current.data)) {
                set.add(current.data);
                prev = current;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
    }

    void display() {
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DuplicateElementList{
    public static void main(String args[]){
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) list.insert(scanner.nextInt());
        list.removeDuplicates();
        System.out.println("Linked List after removing duplicates:");
        list.display();
        scanner.close();
    }
}