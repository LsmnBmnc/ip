package nana;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Ui class handles all interactions with the user.
 * It reads user input and displays messages to the user.
 */
public class Ui {

    private ArrayList<String> inputArrayList;
    private String rawInput;
    private Scanner scanner;
    private String[] inputList;

    /**
     * Constructs a new Ui instance.
     * Initializes the input array list and the scanner for reading user input.
     */
    public Ui() {
        this.inputArrayList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints the greeting message to the user.
     */
    public void printGreeting() {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Hello! I'm nana.Nana\n"
                +
                "     What can I do for you?\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints the goodbye message to the user.
     */
    public void printBye() {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Bye. Hope to see you again soon!\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints the specified NanaException message to the user.
     *
     * @param e the NanaException to be printed
     */
    public static void printNanaException(NanaException e) {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Exception: " + e.getMessage() + "\n"
                +
                "    ____________________________________________________________");

    }
    /**
     * Prints the specified IOException message to the user.
     *
     * @param e the IOException to be printed
     */
    public static void printIoException(IOException e) {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Exception: " + e.getMessage() + "\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Shows a loading error message to the user.
     */
    public void showLoadingError() {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Exception: File not found\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints a message indicating that the specified task has been marked as done.
     *
     * @param task the task that has been marked as done
     */
    public static void printMarkTask(Task task) {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Nice! I've marked this task as done:\n"
                +
                "       [X] " + task.getDescription() + "\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints a message indicating that the specified task has been marked as undone.
     *
     * @param task the task that has been marked as undone
     */
    public static void printUnmarkTask(Task task) {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Nice! I've marked this task as undone:\n"
                +
                "       [ ] " + task.getDescription() + "\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints a message indicating that a new todo task has been added.
     *
     * @param task the task that has been added
     * @param taskCount the current number of tasks in the list
     */
    public static void printAddTodo(Task task, int taskCount) {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Got it. I've added this task:\n"
                +
                "       " + task + "\n"
                +
                "     Now you have " + taskCount + " tasks in the list.\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints a message indicating that a new deadline task has been added.
     *
     * @param task the task that has been added
     * @param taskCount the current number of tasks in the list
     */
    public static void printAddDeadline(Task task, int taskCount) {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Got it. I've added this task:\n"
                +
                "       " + task + "\n"
                +
                "     Now you have " + taskCount + " tasks in the list.\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints a message indicating that a new event task has been added.
     *
     * @param task the task that has been added
     * @param taskCount the current number of tasks in the list
     */
    public static void printAddEvent(Task task, int taskCount) {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Got it. I've added this task:\n" + "       " + task + "\n"
                +
                "     Now you have " + taskCount + " tasks in the list.\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints a message indicating that the specified task has been deleted.
     *
     * @param task the task that has been deleted
     * @param taskCount the current number of tasks in the list
     */
    public static void printDeleteTask(Task task, int taskCount) {
        System.out.println("    ____________________________________________________________\n"
                +
                "     Noted. I've removed this task:\n"
                +
                "       " + task + "\n"
                +
                "     Now you have " + taskCount + " tasks in the list.\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints a message indicating that the specified task has been added.
     *
     * @param task the task that has been added
     */
    public static void printAddTask(Task task) {
        System.out.println("    ____________________________________________________________\n"
                +
                "     added: " + task.getDescription() + "\n"
                +
                "    ____________________________________________________________");
    }

    /**
     * Prints the list of tasks to the user.
     *
     * @param tasks the list of tasks
     * @param taskCount the current number of tasks in the list
     */
    public static void printListTasks(ArrayList<Task> tasks, int taskCount) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("     " + (i + 1) + "." + tasks.get(i));
        }
        System.out.println("    ____________________________________________________________");
    }

    public static void printFindTasks(ArrayList<Task> tasks) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the matching tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("     " + (i + 1) + "." + tasks.get(i));
        }
        System.out.println("    ____________________________________________________________");
    }

    /**
     * Reads the user input and processes it into an array list.
     */
    public void readInput() {
        String input = this.scanner.nextLine().trim();
        rawInput = input;
        inputArrayList.clear();
        inputList = input.split("\\s+");
        for (String s: inputList) {
            inputArrayList.add(s);
        }
    }

    /**
     * Returns the raw user input.
     *
     * @return the raw user input
     */
    public String getRawInput() {
        return this.rawInput;
    }

    /**
     * Returns the first word of the user input, which is typically the command signal.
     *
     * @return the command signal
     */
    public String getSignal() {
        return inputArrayList.get(0);
    }

    /**
     * Returns the processed user input as an array list.
     *
     * @return the processed user input
     */
    public ArrayList<String> getInfo() {
        return inputArrayList;
    }


}
