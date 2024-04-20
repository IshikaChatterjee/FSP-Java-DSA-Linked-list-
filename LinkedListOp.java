//WAP to create a linked list and to perform all the basic operations of the linked list

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

        if (head == null)
        {
            head = newNode;
        } else
        {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }


    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println(data + " not found in the list");
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

public class LinkedListOp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

   
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

     
        list.display();

       
        list.delete(3);

        list.display();
    }
}
