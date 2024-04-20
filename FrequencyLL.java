// wap to accept a linked list and to find the frequency of the largest element

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    int frequencyOfLargest()
        {
        if (head == null)
                return 0;
        int max = head.data,
        frequency = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.data > max)
        {
            max = temp.data;
            frequency = 1;
        }
            else if (temp.data == max) frequency++;
        }
        return frequency;
    }
}

    public class FrequencyLL {
        public static void main(String args[])
        {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();

        System.out.println("Enter the elemenmts :");
        for(int i =0; i < n; i++)
        {
            list.insert(scanner.nextInt());
        }
        System.out.println("Frequency of largest element is :" + list.frequencyOfLargest());

        scanner.close();


        }
    }

    //WAP to find the sum o all the even numbers present in the linked list