package Assignment_2_1.Task1;

// Class for a singly linked list with a generic type T
public class SinglyLinkedList<T> {

    // Nested static class representing a node in the list
    static class Node<T> {
        T data; // Node data
        Node<T> next; // Reference to the next node

        // Node constructor
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Head of the list

    // Method to add an element to the beginning of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to add an element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Method to remove an element by value
    public void remove(T data) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        if (head.data != null && head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data != null && current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Method to remove an element by index
    public void removeAtIndex(int index) {
        if (head == null || index < 0) {
            System.out.println("Invalid index or empty list");
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        int i = 0;
        while (i < index - 1 && current.next != null) {
            current = current.next;
            i++;
        }

        if (current.next == null) {
            System.out.println("Index too large");
            return;
        }
        current.next = current.next.next;
    }

    // Method to search for an element by value
    public boolean search(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data != null && temp.data.equals(data)) {
                System.out.println("Found element: " + temp.data);
                return true;
            }
            temp = temp.next;
        }
        System.out.println("Element not found: " + data);
        return false;
    }

    // Method to clear the list
    public void clear() {
        head = null;
    }

    // Method to print the list to the console
    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to get an element by index
    public T get(int index) {
        if (index < 0 || head == null) {
            System.out.println("Index: " + index);
            return null; // Return null in case of error
        }

        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                System.out.println("Found element: " + current.data);
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }
        System.out.println("Index too large: " + index);
        return null;
    }

    // Method to get the length of the list
    public int length() {
        Node<T> temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        System.out.println("Empty list size: " + list.length());
        list.display();

        System.out.println("\nAdding 10, 20, 30 to our list...");
        list.add(10);
        list.add(20);
        list.add(30);
        list.display();
        System.out.println("Size: " + list.length());

        System.out.println("\nRemoving 20 from our list...");
        list.remove(20);
        list.display();
        System.out.println("Size after removing 20: " + list.length());


        System.out.printf("\nAdding 5 to the first turn on the list...");
        list.addFirst(5);
        list.display();
        System.out.println("Element at index 0: " + list.get(0));

        System.out.println("\nSearch for 10: " + list.search(10));
        System.out.println("Search for 99: " + list.search(99) + "\n");

        try {
            list.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        list.clear();
        list.display();
        System.out.println("Size after clear: " + list.length());
    }
}