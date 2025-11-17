# Page Replacement Algorithm Simulator

This project is a simulator developed in Java for the Operating Systems course. The goal is to evaluate and compare the performance of different page replacement algorithms by calculating the total number of *page faults* for a given sequence of memory references.

The simulator features a Graphical User Interface (GUI) built with Java Swing, allowing users to interactively input data and visualize comparative results.

## 📚 Implemented Algorithms

The simulator implements 4 of the main page replacement algorithms:

  * **FIFO (First-In, First-Out):** Replaces the page that has been in memory the longest.
  * **LRU (Least Recently Used):** Replaces the page that has been used least recently.
  * **Clock (Second Chance):** A more efficient implementation that gives a "second chance" to recently used pages (using an R reference bit).
  * **Optimal:** The ideal (theoretical) algorithm that replaces the page that will take the longest to be used in the future. Serves as a *benchmark* for comparison.

## 🛠️ Technologies Used

  * **Java:** Main language of the project.
  * **Java Swing:** Used for creating the graphical user interface (GUI).

## 🚀 How to Run the Project

### Prerequisites

  * Have the **Java Development Kit (JDK)** version 8 or higher installed and correctly configured on your system (with `JAVA_HOME` and `PATH` environment variables set).

-----

### Execution (Graphical Interface - GUI)

**Option 1: Via Command Line**

1.  Clone or download this repository to your machine.
2.  Open a terminal (Command Prompt, PowerShell, Terminal, etc.).
3.  Navigate to the project's root directory (the folder containing all `.java` files, like `SimuladorGUI.java`, `FIFO.java`, etc.).
4.  Compile all Java files with the following command:
    ```bash
    javac *.java
    ```
5.  After compilation (which will generate the `.class` files), run the main GUI class:
    ```bash
    java SimuladorGUI
    ```

-----

### Execution (Test Version - Terminal)

The project also includes an `App.java` class that runs the simulation directly in the terminal with fixed values (No GUI).

1.  Follow steps 1 to 4 from **Option 1** to compile the files (`javac *.java`).
2.  Run the `App` class:
    ```bash
    java App
    ```
    This will print the results to the console using the test data defined in the code.

## 🖥️ How to Use the Interface

When running `SimuladorGUI`, usage is simple:

1.  **Reference Sequence:** Enter the chain of numbers (pages) separated by commas.
      * *Example:* `7,0,1,2,0,3,0,4,2,3,0,3,2`
2.  **Number of Frames:** Enter the total number of available memory frames (physical memory size).
      * *Example:* `3`
3.  **Simulate:** Click the "Simulate" button. The results with the page faults for each algorithm will be displayed in the text area below. The program also handles invalid inputs (like letters or empty fields).

-----
