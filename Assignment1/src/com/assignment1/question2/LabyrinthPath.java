package com.assignment1.question2;

public class LabyrinthPath {
    // Node class representing each location in the path
    private static class Node {
        String location;
        Node next;

        public Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Constructor to initialize an empty path
    public LabyrinthPath() {
        head = null;
        tail = null;
    }

    // Method to add a new location to the path
    public void addLocation(String location) {
        Node newNode = new Node(location);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Added location: " + location);
    }

    // Method to remove the last visited location
    public void removeLastLocation() {
        if (head == null) {
            System.out.println("The path is empty. No location to remove.");
            return;
        }

        // If there's only one location, remove it
        if (head == tail) {
            System.out.println("Removed last location: " + head.location);
            head = null;
            tail = null;
            return;
        }

        // Traverse the list to find the second last node
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        System.out.println("Removed last location: " + tail.location);
        current.next = null;
        tail = current;
    }

    // Method to check if the path contains a loop (trap)
    public boolean containsLoop() {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        // Use Floyd’s Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast pointers meet, there is a loop
            if (slow == fast) {
                System.out.println("Loop detected in the path!");
                return true;
            }
        }

        System.out.println("No loop detected in the path.");
        return false;
    }

    // Method to print the entire path
    public void printPath() {
        if (head == null) {
            System.out.println("The path is empty.");
            return;
        }

        System.out.print("Current Path: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.location + " -> ");
            current = current.next;
        }
        System.out.println("End");
    }

    // Main method to test the LabyrinthPath functionality
    public static void main(String[] args) {
        LabyrinthPath path = new LabyrinthPath();

        // Adding locations
        path.addLocation("Entrance");
        path.addLocation("Hallway");
        path.addLocation("Chamber");
        path.addLocation("Secret Room");

        // Print the current path
        System.out.println("\nPath after adding locations:");
        path.printPath();

        // Remove last visited location
        path.removeLastLocation();
        System.out.println("\nPath after removing the last location:");
        path.printPath();

        // Check if the path contains a loop (no loop yet)
        path.containsLoop();

        // Adding more locations and create a loop for testing
        path.addLocation("Cave");
        path.addLocation("Maze");

        // Manually creating a loop for testing (Maze -> Hallway)
        path.tail.next = path.head.next; // Create a loop for testing purposes

        // Check if the path contains a loop (now it has a loop)
        path.containsLoop();
    }
}

