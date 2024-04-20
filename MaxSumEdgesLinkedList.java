//WAP in java and reaarange the list in such a way that edges gives the maximum sum in the l;inked list
//(logic - create two separate functions for max and min and then swap the first largest element with the first element 
//and the second largest element with the last element)
//input: [12,8,17,14,9,-7]
//output: [17,12,8,-7,9,14]

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MaxSumEdgesLinkedList {

    public static ListNode rearrangeEdges(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Empty or single-node list
        }

        // Find the maximum and minimum elements
        ListNode maxNode = head;
        ListNode minNode = head;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val > maxNode.val) {
                maxNode = curr;
            }
            if (curr.val < minNode.val) {
                minNode = curr;
            }
            curr = curr.next;
        }

        // Swap the first largest element with the first element
        int temp = head.val;
        head.val = maxNode.val;
        maxNode.val = temp;

        // Swap the second largest element with the last element
        curr = head;
        while (curr.next != null) {
            if (curr.next.val == maxNode.val) {
                temp = curr.next.val;
                curr.next.val = minNode.val;
                minNode.val = temp;
                break;
            }
            curr = curr.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example input: [12, 8, 17, 14, 9, -7]
        ListNode head = new ListNode(12);
        head.next = new ListNode(8);
        head.next.next = new ListNode(17);
        head.next.next.next = new ListNode(14);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(-7);

        System.out.println("Original list:");
        printList(head);

        ListNode rearrangedHead = rearrangeEdges(head);

        System.out.println("Rearranged list:");
        printList(rearrangedHead);
    }
}
