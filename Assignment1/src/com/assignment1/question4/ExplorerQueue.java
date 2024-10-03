package com.assignment1.question4;

public class ExplorerQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the queue with a fixed capacity
    public ExplorerQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to enqueue a new explorer
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("The queue is full. Cannot add more explorers.");
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = explorer;
        size++;
        System.out.println("Enqueued explorer: " + explorer);
    }

    // Method to dequeue an explorer when they enter the temple
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorer to dequeue.");
            return;
        }
        System.out.println("Dequeued explorer: " + queue[front]);
        front = (front + 1) % capacity; // Circular increment
        size--;
    }

    // Method to display the next explorer in line (front of the queue)
    public void peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorer in line.");
        } else {
            System.out.println("Next explorer in line: " + queue[front]);
        }
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to display all explorers in the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.print("Explorers in queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the ExplorerQueue functionality
    public static void main(String[] args) {
        ExplorerQueue explorerQueue = new ExplorerQueue(5);

        // Enqueue explorers
        explorerQueue.enqueue("Explorer A");
        explorerQueue.enqueue("Explorer B");
        explorerQueue.enqueue("Explorer C");

        // Display next explorer in line
        System.out.println("\nPeek at the next explorer:");
        explorerQueue.peek();

        // Display all explorers
        System.out.println("\nDisplaying all explorers:");
        explorerQueue.displayQueue();

        // Dequeue explorer
        System.out.println("\nDequeue an explorer:");
        explorerQueue.dequeue();

        // Display all explorers after dequeue
        System.out.println("\nDisplaying all explorers after dequeue:");
        explorerQueue.displayQueue();

        // Enqueue more explorers
        explorerQueue.enqueue("Explorer D");
        explorerQueue.enqueue("Explorer E");
        explorerQueue.enqueue("Explorer F"); // Should not add because queue is full

        // Check if queue is full
        System.out.println("\nIs the queue full? " + explorerQueue.isFull());

        // Display all explorers again
        System.out.println("\nDisplaying all explorers:");
        explorerQueue.displayQueue();

        // Dequeue until the queue is empty
        System.out.println("\nDequeue all explorers:");
        while (!explorerQueue.isEmpty()) {
            explorerQueue.dequeue();
        }

        // Check if queue is empty
        System.out.println("\nIs the queue empty? " + explorerQueue.isEmpty());
    }
}

