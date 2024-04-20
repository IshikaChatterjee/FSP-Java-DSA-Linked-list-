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

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    void rearrangeEdgesMaxSum() {
        if (head == null || head.next == null) return;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Node current = head;
        while (current != null) {
            if (current.data > max) max = current.data;
            if (current.data < min) min = current.data;
            current = current.next;
        }

    
        LinkedList newList = new LinkedList();

        newList.insert(max);

        newList.insert(min);

        current = head;
        while (current != null) {
            if (current.data > min && current.data < max) {
                newList.insert(current.data);
            }
            current = current.next;
        }

        head = newList.head;
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

public class EdgesMaxSumList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] input = {12, 8, 17, 14, 9, -7};
        for (int num : input) {
            list.insert(num);
        }
        System.out.println("Original Linked List:");
        list.display();

        list.rearrangeEdgesMaxSum();
        System.out.println("Linked List after rearranging to maximize edge sum:");
        list.display();
    }
}
