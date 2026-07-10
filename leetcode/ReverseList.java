package leetcode;

/**
 * LeetCode 206: Reverse Linked List
 * Difficulty: Easy
 * 
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return its reversed list.
 * 
 * Time Complexity: O(N) - Linear pass through the list.
 * Space Complexity:
 * - Iterative: O(1)
 * - Recursive: O(N) - Stack call depth.
 */
public class ReverseList {

    // Node representation
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Iterative approach
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // Store next node
            curr.next = prev;              // Reverse pointer direction
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }
        return prev; // New head of the reversed list
    }

    // Recursive approach
    public static ListNode reverseListRecursive(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Reverse sublist
        ListNode newHead = reverseListRecursive(head.next);
        
        // Readjust current node pointers
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }

    // Display helper
    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("--- LeetCode 206: Reverse Linked List ---");
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        System.out.print("Original List: ");
        display(head);

        ListNode revIter = reverseListIterative(head);
        System.out.print("Reversed (Iterative): ");
        display(revIter);

        // Reverse back using recursive
        ListNode revRec = reverseListRecursive(revIter);
        System.out.print("Reversed Back (Recursive): ");
        display(revRec);
    }
}
