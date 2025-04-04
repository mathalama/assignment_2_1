package Assignment_2_1.Task2;

// Implementation of a doubly linked list
class DoublyLinkedList<T> {
    // Node structure representing an element in the list
    private static class Node<T> {
        T data; // Data stored in the node
        Node<T> prev, next; // References to the previous and next nodes

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail; // Head and tail references

    // Adds a new node at the beginning of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Adds a new node at the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Removes a node with the specified data
    public void remove(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    // Checks if the list contains a node with the specified data
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Prints the elements of the list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Reverses the order of the linked list
    public void reverse() {
        Node<T> current = head, temp = null;
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
        list.addFirst(1);
        list.add(2);
        list.add(3);
        list.printList();
        list.reverse();
        list.printList();
        System.out.println("Middle Element: " + list.findMiddle());
        list.remove(2);
        list.printList();
        System.out.println("Contains 3: " + list.contains(3));
    }
}