package com.assignment1.question1;

import java.util.Arrays;

public class ArtifactVault {
    private Artifact[] vault;
    private int size;

    // Constructor to initialize the vault with a fixed capacity
    public ArtifactVault(int capacity) {
        vault = new Artifact[capacity];
        size = 0;
    }

    // Method to add an artifact to the first empty slot
    public boolean addArtifact(Artifact artifact) {
        if (size == vault.length) {
            System.out.println("Vault is full. Cannot add more artifacts.");
            return false;
        }
        vault[size++] = artifact;
        Arrays.sort(vault, 0, size);  // Keep array sorted by artifact age
        return true;
    }

    // Method to remove an artifact by its name
    public boolean removeArtifact(String name) {
        for (int i = 0; i < size; i++) {
            if (vault[i] != null && vault[i].getName().equalsIgnoreCase(name)) {
                vault[i] = null;
                // Shift all elements to fill the gap
                for (int j = i; j < size - 1; j++) {
                    vault[j] = vault[j + 1];
                }
                vault[--size] = null;  // Clear last element
                return true;
            }
        }
        System.out.println("Artifact not found.");
        return false;
    }

    // Method to find an artifact using linear search
    public Artifact linearSearch(String name) {
        for (int i = 0; i < size; i++) {
            if (vault[i] != null && vault[i].getName().equalsIgnoreCase(name)) {
                return vault[i];
            }
        }
        System.out.println("Artifact not found.");
        return null;
    }

    // Method to find an artifact using binary search (assume array is sorted by age)
    public Artifact binarySearch(String name) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Artifact midArtifact = vault[mid];

            if (midArtifact.getName().equalsIgnoreCase(name)) {
                return midArtifact;
            } else if (midArtifact.getName().compareToIgnoreCase(name) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Artifact not found.");
        return null;
    }

    // Method to display all artifacts in the vault
    public void displayArtifacts() {
        for (int i = 0; i < size; i++) {
            if (vault[i] != null) {
                System.out.println(vault[i]);
            }
        }
    }

    // Artifact class to represent the artifact
    public static class Artifact implements Comparable<Artifact> {
        private String name;
        private int age;

        public Artifact(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Artifact other) {
            return Integer.compare(this.age, other.age);
        }

        @Override
        public String toString() {
            return "Artifact{Name='" + name + "', Age=" + age + "}";
        }
    }

    // Main method to test the ArtifactVault functionality
    public static void main(String[] args) {
        ArtifactVault vault = new ArtifactVault(5);

        Artifact artifact1 = new Artifact("Ancient Vase", 200);
        Artifact artifact2 = new Artifact("Old Coin", 50);
        Artifact artifact3 = new Artifact("Golden Statue", 500);
        Artifact artifact4 = new Artifact("Iron Sword", 300);

        // Adding artifacts
        vault.addArtifact(artifact1);
        vault.addArtifact(artifact2);
        vault.addArtifact(artifact3);
        vault.addArtifact(artifact4);

        System.out.println("All artifacts:");
        vault.displayArtifacts();

        // Removing an artifact
        vault.removeArtifact("Old Coin");
        System.out.println("\nAfter removing 'Old Coin':");
        vault.displayArtifacts();

        // Finding artifact using linear search
        Artifact foundArtifact = vault.linearSearch("Golden Statue");
        if (foundArtifact != null) {
            System.out.println("\nFound using linear search: " + foundArtifact);
        }

        // Finding artifact using binary search
        foundArtifact = vault.binarySearch("Iron Sword");
        if (foundArtifact != null) {
            System.out.println("\nFound using binary search: " + foundArtifact);
        }
    }
}
