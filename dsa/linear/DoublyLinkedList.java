package dsa.linear;

public class DoublyLinkedList {
    
    // Node class with prev and next pointers
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    // Add element to end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Delete node by value
    public boolean delete(int key) {
        if (head == null) return false;

        Node curr = head;
        while (curr != null) {
            if (curr.data == key) {
                // If it's the head node
                if (curr == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null; // List became empty
                    }
                }
                // If it's the tail node
                else if (curr == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                // If it's in the middle
                else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // Print list from head to tail (Forward)
    public void displayForward() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        System.out.print("Forward: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Print list from tail to head (Backward)
    public void displayBackward() {
        if (tail == null) {
            System.out.println("Empty List");
            return;
        }
        System.out.print("Backward: ");
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("--- Doubly Linked List Test ---");
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.displayForward(); // Forward: 10 <-> 20 <-> 30 <-> null
        list.displayBackward(); // Backward: 30 <-> 20 <-> 10 <-> null

        list.delete(20);
        list.displayForward(); // Forward: 10 <-> 30 <-> null
    }
}
