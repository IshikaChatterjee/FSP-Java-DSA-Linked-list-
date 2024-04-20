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

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    void removeDuplicates() {
        if (head == null) return;
        head = mergeSort(head);
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) current.next = current.next.next;
            else current = current.next;
        }
    }

    Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);
        return merge(left, right);
    }

    Node merge(Node left, Node right) {
        Node result = null;
        if (left == null) return right;
        if (right == null) return left;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    Node getMiddle(Node head) {
        if (head == null) return head;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

public class DuplicateElementSortList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) list.insert(scanner.nextInt());
        list.removeDuplicates();
    }
}
