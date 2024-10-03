package com.assignment1.question3;

import java.util.Stack;

public class ScrollStack {
    // Stack to hold scrolls
    private Stack<String> scrolls;

    // Constructor to initialize the stack
    public ScrollStack() {
        scrolls = new Stack<>();
    }

    // Method to push a new scroll onto the stack
    public void pushScroll(String scroll) {
        scrolls.push(scroll);
        System.out.println("Pushed scroll: " + scroll);
    }

    // Method to pop the top scroll off the stack
    public void popScroll() {
        if (scrolls.isEmpty()) {
            System.out.println("The stack is empty. No scroll to pop.");
        } else {
            String poppedScroll = scrolls.pop();
            System.out.println("Popped scroll: " + poppedScroll);
        }
    }

    // Method to peek at the top scroll without removing it
    public void peekScroll() {
        if (scrolls.isEmpty()) {
            System.out.println("The stack is empty. No scroll to peek.");
        } else {
            System.out.println("Top scroll: " + scrolls.peek());
        }
    }

    // Method to check if a specific scroll title exists in the stack
    public boolean containsScroll(String scrollTitle) {
        boolean exists = scrolls.contains(scrollTitle);
        if (exists) {
            System.out.println("The scroll titled '" + scrollTitle + "' exists in the stack.");
        } else {
            System.out.println("The scroll titled '" + scrollTitle + "' does not exist in the stack.");
        }
        return exists;
    }

    // Method to display all scrolls in the stack (from top to bottom)
    public void displayScrolls() {
        if (scrolls.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("Scrolls in stack (top to bottom):");
            for (int i = scrolls.size() - 1; i >= 0; i--) {
                System.out.println(scrolls.get(i));
            }
        }
    }

    // Main method to test the ScrollStack functionality
    public static void main(String[] args) {
        ScrollStack stack = new ScrollStack();

        // Push scrolls onto the stack
        stack.pushScroll("Ancient Scroll of Wisdom");
        stack.pushScroll("Scroll of Fire Magic");
        stack.pushScroll("Scroll of Earth Power");

        // Peek at the top scroll
        System.out.println("\nPeeking at the top scroll:");
        stack.peekScroll();

        // Check if a specific scroll exists
        System.out.println("\nChecking if 'Scroll of Water Magic' exists:");
        stack.containsScroll("Scroll of Water Magic");

        System.out.println("\nChecking if 'Scroll of Fire Magic' exists:");
        stack.containsScroll("Scroll of Fire Magic");

        // Display all scrolls in the stack
        System.out.println("\nDisplaying all scrolls in the stack:");
        stack.displayScrolls();

        // Pop the top scroll
        System.out.println("\nPopping the top scroll:");
        stack.popScroll();

        // Display all scrolls again after popping
        System.out.println("\nDisplaying scrolls after popping:");
        stack.displayScrolls();
    }
}
