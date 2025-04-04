package Assignment_2_1.Task2;

// Implementation of a doubly linked list
class DoublyLinkedList<T> {
    // Node structure representing an element in the list
    private static class Node<T> {
        T data; // Data stored in the node
        Node<T> prev, next; // References to the previous and next nodes

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head; // Head references

    // Adds a new node at the beginning of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Adds a new node at the end of the list
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Removes a node with the specified data
    public void remove(T data) {
        Node<T> current = head;
        while (current != null) {
            if (data == null ? current.data == null : current.data.equals(data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                return; // Remove only the first occurrence
            }
            current = current.next;
        }
    }

    // Checks if the list contains a node with the specified data
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (data == null ? current.data == null : current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Prints the elements of the list
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Reverses the order of the linked list
    public void reverse() {
        if (head == null || head.next == null) return; // Empty or single-node list
        Node<T> current = head;
        Node<T> temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Finds and returns the middle element of the list
    public T findMiddle() {
        if (head == null) return null;
        Node<T> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        System.out.println("Testing a doubly-linked list");

        System.out.println("\nTest 1: Insertion at the beginning");
        list.addFirst(2);
        list.addFirst(1);
        System.out.println("After adding 2, then 1 to the beginning:");
        list.display();

        System.out.println("\nTest 2: Unfolding the list");
        list.addLast(3);
        list.addLast(4);
        System.out.println("Before turning around (list: 1, 2, 3, 4):");
        list.display();
        list.reverse();
        System.out.println("After turning around:");
        list.display();


        System.out.println("\nTest 3: Finding the middle element");
        System.out.println("The list: ");
        list.display();
        System.out.println("Middle element: " + list.findMiddle());
    }
}