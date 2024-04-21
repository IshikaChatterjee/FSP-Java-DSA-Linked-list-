import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class MiddleElementList {
    Node head; 

    void printMiddle() {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is: " + slow_ptr.data);
        }
    }

    public void push(int new_data) {
    
        Node new_node = new Node(new_data);

    
        new_node.next = head;

        head = new_node;
    }


    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            llist.push(data);
        }
        System.out.println("Linked List:");
        llist.printList();
        System.out.println("Finding the middle element:");
        llist.printMiddle();
        scanner.close();
    }
}


// AN Automobile company manufactures both 2 wheelers and 4 wheelers . A Company Manager wants to make the produiction of four types of vehicles 
//using the data given :
//1.) Total number of vehicles (T.W + F.W)
//2.)Total number of wheels = W
// tHE TASK IS TO FIND HOW MANY TWO- WHEELERS AS WELL AS 4_wHEELERS NEEDS TO BE MANUFACTURED AS PER THE GIVEN DATA