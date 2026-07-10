package dsa.linear;

public class SinglyLinkedList {
    
    // Node representation
    private static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head = null;
    
    // Insert a new node at the end of the list
    public void insert(int data) {
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
    
    // Delete the first occurrence of a value from the list
    public boolean delete(int key) {
        if (head == null) return false;
        
        if (head.data == key) {
            head = head.next;
            return true;
        }
        
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data == key) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }
    
    // Print the elements of the list
    public void display() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("--- Singly Linked List Test ---");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display(); // 10 -> 20 -> 30 -> null
        
        System.out.println("Deleting 20: " + list.delete(20));
        list.display(); // 10 -> 30 -> null
        
        System.out.println("Deleting 40: " + list.delete(40));
        list.display(); // 10 -> 30 -> null
    }
}
