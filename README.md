# DataStructures-Assignment1-JagjeetKaur
Assignment 1 submission

Name: Jagjeet Kaur Randhawa
Student Id: C0903290

Ques1:

Key Components:
ArtifactVault Class: Manages an array of Artifact objects.
Add Artifact: Adds artifacts to the first empty slot and ensures the array remains sorted.
Remove Artifact: Removes an artifact by its name and shifts the array to fill the gap.
Linear Search: Searches the array element by element for the artifact.
Binary Search: Performs a binary search on the sorted array to find an artifact by name.
Artifact Class: Contains artifact details (name and age) and implements Comparable to help with sorting.


Ques2:

Key Components:
Node Class: Represents each location in the path. Contains the location name and a reference to the next node.
Add Location: Adds a new location to the end of the linked list.
Remove Last Location: Removes the last location from the linked list by traversing to the second last node and updating the pointers.
Check for Loop: Uses Floyd’s Cycle-Finding Algorithm (slow and fast pointers) to detect if there's a loop (trap) in the path.
Print Path: Traverses the list and prints all locations.

Explanation:
Adding Locations: Locations are added at the end of the singly linked list.
Removing Last Location: The last location is removed by traversing to the second-to-last node and updating the tail.
Loop Detection: The algorithm detects a cycle if slow and fast pointers meet, indicating a loop in the path.
Manual Loop: For testing purposes, I created a loop by connecting the last node back to an earlier node in the list (Maze -> Hallway). This simulates a trap in the labyrinth.



Ques3:

Key Components:
Stack<String>: The stack is implemented using Java’s built-in Stack class to store the scroll titles.
Push Operation: Adds a scroll to the top of the stack.
Pop Operation: Removes and returns the top scroll from the stack.
Peek Operation: Shows the top scroll without removing it from the stack.
Search Operation: Checks if a particular scroll exists in the stack using the contains() method.
Display: Prints all scrolls in the stack from top to bottom.

Explanation:
Push Scroll: Adds scrolls like "Ancient Scroll of Wisdom," "Scroll of Fire Magic," and "Scroll of Earth Power" to the stack.
Peek Scroll: Shows the top scroll, "Scroll of Earth Power," without removing it.
Contains Scroll: Checks whether "Scroll of Water Magic" exists in the stack (it does not), but "Scroll of Fire Magic" does exist.
Pop Scroll: Removes the top scroll ("Scroll of Earth Power") from the stack.
Display Stack: Shows the scrolls in order, from top to bottom. After popping, only the two remaining scrolls are displayed.


Ques4:

Key Components:
Circular Queue: The queue uses a circular array to handle enqueueing and dequeueing, with both front and rear pointers wrapping around using the modulus operator.
Enqueue: Adds an explorer to the queue at the rear, wraps around if necessary.
Dequeue: Removes an explorer from the front and adjusts the pointer to the next element.
Peek: Shows the explorer at the front without removing them.
Is Full: Checks if the queue is full by comparing the size with the capacity.
Is Empty: Checks if the queue is empty by comparing the size with 0.
Display Queue: Prints all explorers currently in the queue in order.

Explanation:
Enqueue: Adds explorers "A," "B," "C," "D," and "E" to the queue. When trying to enqueue "F," it detects the queue is full.
Dequeue: Removes explorers starting from the front. The queue wraps around as necessary due to the circular nature.
Peek: Displays the next explorer in line (front) without removing them.
Full/Empty Check: Verifies if the queue is full or empty at various stages.

Ques5:

Key Components:
Binary Tree Structure: A Node class is defined to represent each clue, containing left and right children for the binary tree structure.
Insertion: The insert method inserts clues while maintaining the binary search tree (BST) property where left children are smaller and right children are larger.
Tree Traversals:
In-order Traversal: Visits nodes in left -> root -> right order.
Pre-order Traversal: Visits nodes in root -> left -> right order.
Post-order Traversal: Visits nodes in left -> right -> root order.
Find Clue: Searches for a specific clue using the binary search tree logic.
Count Clues: Counts the total number of clues in the tree recursively.

Explanation:
Insert Clues: Clues are inserted into the tree while maintaining the binary search tree property.
Traversals: The in-order, pre-order, and post-order traversals are demonstrated to visit the nodes in different orders.
Find Clue: The method successfully finds "Clue B" and reports that "Clue E" is not found.
Count Clues: The total number of clues in the tree is counted and returned.

--------------------------------------------------------------------------------------------------------------------------------------------------------------
### Challenge Descriptions and Approach:

1. **The Array Artifact**
   - **Description**: Implemented a class `ArtifactVault` to manage an array of artifacts, with methods for adding, removing, and searching (both linear and binary).
   - **Approach**: I used an array to store the artifacts, ensuring that binary search functionality was possible by keeping the array sorted after each insertion. Removal by name was handled by shifting elements. Linear search was straightforward, while binary search required maintaining a sorted array.
   - **Assumptions/Design**: The array has a fixed size, and binary search assumes the array is sorted.
   - **Run**: The class can be run in any Java environment. Instantiate the class and call the methods for adding, removing, and searching artifacts.

2. **The Linked List Labyrinth**
   - **Description**: Created a `LabyrinthPath` class using a singly linked list with methods to add a location, remove the last visited location, detect loops, and print the path.
   - **Approach**: I used a singly linked list for efficient addition and removal of locations. Loop detection was implemented using Floyd’s cycle-finding algorithm (tortoise and hare).
   - **Assumptions/Design**: The list is unbounded, and no duplicate locations need special handling.
   - **Run**: Create a `LabyrinthPath` instance, use methods to manipulate and traverse the list. The loop detection function can be tested with cyclic or acyclic data.

3. **The Stack of Ancient Texts**
   - **Description**: Developed a `ScrollStack` class that manages a stack of scrolls, with methods for pushing, popping, peeking, and searching for specific scroll titles.
   - **Approach**: I implemented a basic stack data structure using an array and managed the standard stack operations (push, pop, peek). The search operation was linear through the stack.
   - **Assumptions/Design**: Stack overflow was not explicitly handled, and the stack had a fixed size.
   - **Run**: Create a `ScrollStack` instance, and use the methods to manipulate the stack. Push and pop operations simulate the scroll management.

4. **The Queue of Explorers**
   - **Description**: Implemented a `ExplorerQueue` class using a circular queue to manage explorers, including enqueue, dequeue, peek, and check if full or empty.
   - **Approach**: The queue was implemented as a circular array with wrap-around handling for the front and rear pointers. I ensured that both full and empty queue states were correctly managed.
   - **Assumptions/Design**: The queue has a fixed size and explorers are enqueued in the order they arrive.
   - **Run**: Instantiate the `ExplorerQueue` class, enqueue/dequeue explorers, and use the methods to manipulate the queue.

5. **The Binary Tree of Clues**
   - **Description**: Created a `ClueTree` class representing a binary search tree of clues, with methods for insertion, traversal (in-order, pre-order, post-order), finding clues, and counting the total number of clues.
   - **Approach**: A binary search tree was implemented with recursive insertion and traversal methods. The tree is designed for efficient search and traversal of clues.
   - **Assumptions/Design**: The tree assumes unique clues and is not self-balancing.
   - **Run**: Instantiate the `ClueTree` class and insert clues. The traversal and search methods can be called to view the tree structure.


### How to Run the Code:

1. **Environment**: The code can be run in any Java environment (e.g., IntelliJ IDEA, Eclipse, or the command line with JDK installed).
2. **Compilation**: Each class can be compiled separately using the following command:
   
   javac ClassName.java
  
3. **Execution**: Run the compiled class using:
   
   java ClassName
   
   Replace `ClassName` with the respective class name (e.g., `ArtifactVault`, `LabyrinthPath`, etc.). The methods inside each class are self-explanatory and can be invoked to perform the corresponding operations.
