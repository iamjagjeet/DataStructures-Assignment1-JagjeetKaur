package com.assignment1.question5;

public class ClueTree {
    // Node class representing each clue in the binary tree
    private static class Node {
        String clue;
        Node left, right;

        public Node(String clue) {
            this.clue = clue;
            left = right = null;
        }
    }

    private Node root;

    // Constructor to initialize an empty tree
    public ClueTree() {
        root = null;
    }

    // Method to insert a new clue into the tree
    public void insert(String clue) {
        root = insertRec(root, clue);
        System.out.println("Inserted clue: " + clue);
    }

    // Recursive method to insert a new clue
    private Node insertRec(Node root, String clue) {
        if (root == null) {
            return new Node(clue);
        }
        if (clue.compareTo(root.clue) < 0) {
            root.left = insertRec(root.left, clue);
        } else if (clue.compareTo(root.clue) > 0) {
            root.right = insertRec(root.right, clue);
        }
        return root;
    }

    // Method for in-order traversal (left -> root -> right)
    public void inOrder() {
        System.out.println("In-Order Traversal:");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.clue + " ");
            inOrderRec(root.right);
        }
    }

    // Method for pre-order traversal (root -> left -> right)
    public void preOrder() {
        System.out.println("Pre-Order Traversal:");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Method for post-order traversal (left -> right -> root)
    public void postOrder() {
        System.out.println("Post-Order Traversal:");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.clue + " ");
        }
    }

    // Method to find a specific clue in the tree
    public boolean findClue(String clue) {
        boolean found = findClueRec(root, clue);
        if (found) {
            System.out.println("Clue found: " + clue);
        } else {
            System.out.println("Clue not found: " + clue);
        }
        return found;
    }

    private boolean findClueRec(Node root, String clue) {
        if (root == null) {
            return false;
        }
        if (clue.equals(root.clue)) {
            return true;
        }
        if (clue.compareTo(root.clue) < 0) {
            return findClueRec(root.left, clue);
        }
        return findClueRec(root.right, clue);
    }

    // Method to count the total number of clues in the tree
    public int countClues() {
        int count = countCluesRec(root);
        System.out.println("Total number of clues: " + count);
        return count;
    }

    private int countCluesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countCluesRec(root.left) + countCluesRec(root.right);
    }

    // Main method to test the ClueTree functionality
    public static void main(String[] args) {
        ClueTree clueTree = new ClueTree();

        // Insert clues into the tree
        clueTree.insert("Clue A");
        clueTree.insert("Clue C");
        clueTree.insert("Clue B");
        clueTree.insert("Clue D");

        // Perform in-order traversal
        System.out.println("\nPerforming in-order traversal:");
        clueTree.inOrder();

        // Perform pre-order traversal
        System.out.println("\nPerforming pre-order traversal:");
        clueTree.preOrder();

        // Perform post-order traversal
        System.out.println("\nPerforming post-order traversal:");
        clueTree.postOrder();

        // Find a specific clue
        System.out.println("\nFinding 'Clue B':");
        clueTree.findClue("Clue B");

        System.out.println("\nFinding 'Clue E':");
        clueTree.findClue("Clue E");

        // Count the total number of clues
        System.out.println("\nCounting the total number of clues:");
        clueTree.countClues();
    }
}

