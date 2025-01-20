import java.util.Scanner;
public class Nana {

    private static Task[] tasks = new Task[100];
    private static int taskCount = 0;

    public static void processInput (String input, Scanner scanner) throws NanaException {
        if (input.equals("blah")){
            throw new NanaException("It seems nonsense");
        }
        if (input.equals("list")) {
            listTasks();
        } else if (input.equals("mark")) {
            markTask(scanner);
        } else if (input.equals("unmark")) {
            unmarkTask(scanner);
        } else if (input.equals("todo")) {
            addTodo(scanner);
        } else if (input.equals("deadline")) {
            addDeadline(scanner);
        } else if (input.equals("event")) {
            addEvent(scanner);
        } else {
            addTask(input, scanner);
        }
    }

    public static void listTasks() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("     " + (i + 1) + "." + tasks[i]);
        }
        System.out.println("    ____________________________________________________________");
    }

    public static void markTask(Scanner scanner) {
        int taskNumber = scanner.nextInt();
        tasks[taskNumber - 1].markAsDone();
        System.out.println("    ____________________________________________________________\n" +
                "     Nice! I've marked this task as done:\n" +
                "       [X] " + tasks[taskNumber - 1].getDescription() + "\n" +
                "    ____________________________________________________________");
    }

    public static void unmarkTask(Scanner scanner) {
        int taskNumber = scanner.nextInt();
        tasks[taskNumber - 1].markAsUndone();
        System.out.println("    ____________________________________________________________\n" +
                "     Nice! I've marked this task as undone:\n" +
                "       [ ] " + tasks[taskNumber - 1].getDescription() + "\n" +
                "    ____________________________________________________________");
    }

    public static void addTodo(Scanner scanner) throws NanaException {

        String taskName = scanner.nextLine();
        if (taskName.equals("")) {
            throw new NanaException("The description of a todo cannot be empty.");
        }
        tasks[taskCount] = new Todo(taskName);
        taskCount++;
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task:\n" + "       " + tasks[taskCount - 1].toString() + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void addDeadline(Scanner scanner) throws NanaException {
        scanner.useDelimiter(" /by");
        String taskName = scanner.next();

        scanner.useDelimiter(" ");
        scanner.next();
        String by = scanner.nextLine();

        scanner.useDelimiter("\\p{javaWhitespace}+");

        tasks[taskCount] = new Deadline(taskName, by);
        taskCount++;
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task:\n" + "       " + tasks[taskCount - 1] + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void addEvent(Scanner scanner) throws NanaException {
        scanner.useDelimiter(" /from");
        String taskName = scanner.next();

        scanner.useDelimiter(" ");
        scanner.next();
        scanner.useDelimiter(" /to");
        String startTime = scanner.next();
        scanner.useDelimiter(" ");
        scanner.next();
        String endTime = scanner.nextLine();
        scanner.useDelimiter("\\p{javaWhitespace}+");
        tasks[taskCount] = new Event(taskName, startTime, endTime);
        taskCount++;
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task:\n" + "       " + tasks[taskCount - 1] + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void addTask(String input, Scanner scanner) throws NanaException {
        String taskName = input + scanner.nextLine();

        tasks[taskCount] = new Task(taskName);
        taskCount++;
        System.out.println("    ____________________________________________________________\n" +
                "     added: " + taskName + "\n" +
                "    ____________________________________________________________");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm Nana\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________");

        while (true) {
            String input = scanner.next();
            if (input.equals("bye")) {
                System.out.println("    ____________________________________________________________\n" +
                        "     Bye. Hope to see you again soon!\n" +
                        "    ____________________________________________________________");
                break;
            } else {
                try {
                    processInput(input, scanner);
                } catch (NanaException e) {
                    System.out.println("    ____________________________________________________________\n" +
                            "     Exception: " + e.getMessage() + "\n" +
                            "    ____________________________________________________________");

                }
            }
        }



    }
}

