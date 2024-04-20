    //WAP to find the sum o all the even numbers present in the linked list

    
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

        int SumOfEvenNumbers()
        {
            int sum = 0;
            for (Node temp = head; temp != null; temp = temp.next) {
                if (temp.data % 2 == 0)
                sum += temp.data;
            }
            return sum;
            }
        }

        public class SumEvenList{
            public static void main(String args[]){
                LinkedList list = new LinkedList();
                Scanner scanner = new Scanner(System.in);
        
                System.out.print("Enter the number of elements: ");
                int n = scanner.nextInt();
        
                System.out.println("Enter the elements:");
                for (int i = 0; i < n; i++) list.insert(scanner.nextInt());
        
                int sum = list.SumOfEvenNumbers();
                System.out.println("Sum of even numbers: " + sum);
        
                scanner.close();

            }
        }
    

