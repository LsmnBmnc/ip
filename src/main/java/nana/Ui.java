package nana;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Ui {

    private ArrayList<String> inputArrayList;
    private String rawInput;
    private Scanner scanner;
    private String[] inputList;

    public Ui() {
        this.inputArrayList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void printGreeting() {
        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm nana.Nana\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________");
    }

    public void printBye() {
        System.out.println("    ____________________________________________________________\n" +
                "     Bye. Hope to see you again soon!\n" +
                "    ____________________________________________________________");
    }

    public static void printNanaException(NanaException e) {
        System.out.println("    ____________________________________________________________\n" +
                "     Exception: " + e.getMessage() + "\n" +
                "    ____________________________________________________________");

    }

    public static void printIoException(IOException e) {
        System.out.println("    ____________________________________________________________\n" +
                "     Exception: " + e.getMessage() + "\n" +
                "    ____________________________________________________________");
    }

    public void showLoadingError() {
        System.out.println("    ____________________________________________________________\n" +
                "     Exception: File not found\n" +
                "    ____________________________________________________________");
    }

    public static void printMarkTask(Task task) {
        System.out.println("    ____________________________________________________________\n" +
                "     Nice! I've marked this task as done:\n" +
                "       [X] " + task.getDescription() + "\n" +
                "    ____________________________________________________________");
    }

    public static void printUnmarkTask(Task task) {
        System.out.println("    ____________________________________________________________\n" +
                "     Nice! I've marked this task as undone:\n" +
                "       [ ] " + task.getDescription() + "\n" +
                "    ____________________________________________________________");
    }

    public static void printAddTodo(Task task, int taskCount) {
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task:\n" +
                "       " + task + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void printAddDeadline(Task task, int taskCount) {
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task:\n" +
                "       " + task + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void printAddEvent(Task task, int taskCount) {
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task:\n" + "       " + task + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void printDeleteTask(Task task, int taskCount) {
        System.out.println("    ____________________________________________________________\n" +
                "     Noted. I've removed this task:\n" +
                "       " + task + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void printAddTask(Task task) {
        System.out.println("    ____________________________________________________________\n" +
                "     added: " + task.getDescription() + "\n" +
                "    ____________________________________________________________");
    }

    public static void printListTasks(ArrayList<Task> tasks, int taskCount) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("     " + (i + 1) + "." + tasks.get(i));
        }
        System.out.println("    ____________________________________________________________");
    }

    public void readInput() {
        String input = this.scanner.nextLine().trim();
        rawInput = input;
        inputArrayList.clear();
        inputList = input.split("\\s+");
        for (String s: inputList) {
            inputArrayList.add(s);
        }
    }

    public String getRawInput() {
        return this.rawInput;
    }

    public String getSignal() {
        return inputArrayList.get(0);
    }

    public ArrayList<String> getInfo() {
        return inputArrayList;
    }


}
