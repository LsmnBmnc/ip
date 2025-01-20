import java.util.Scanner;
public class Nana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm Nana\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________");

        Task[] tasks = new Task[100];

        int taskCount = 0;

        while (true) {
            String input = scanner.next();
            if (input.equals("bye")) {
                System.out.println("    ____________________________________________________________\n" +
                        "     Bye. Hope to see you again soon!\n" +
                        "    ____________________________________________________________");
                break;
            } else {
                if (input.equals("list")) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Here are the tasks in your list:");
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println("     " + (i + 1) + "." + tasks[i]);
                    }
                    System.out.println("    ____________________________________________________________");
                } else if (input.equals("mark")) {
                    int taskNumber = scanner.nextInt();
                    tasks[taskNumber - 1].markAsDone();
                    System.out.println("    ____________________________________________________________\n" +
                            "     Nice! I've marked this task as done:\n" +
                            "       [X] " + tasks[taskNumber - 1].getDescription() + "\n" +
                            "    ____________________________________________________________");
                } else if (input.equals("unmark")) {
                    int taskNumber = scanner.nextInt();
                    tasks[taskNumber - 1].markAsUndone();
                    System.out.println("    ____________________________________________________________\n" +
                            "     Nice! I've marked this task as undone:\n" +
                            "       [ ] " + tasks[taskNumber - 1].getDescription() + "\n" +
                            "    ____________________________________________________________");
                } else if (input.equals("todo")) {
                    String taskName = scanner.nextLine();
                    tasks[taskCount] = new Todo(taskName);
                    taskCount++;
                    System.out.println("    ____________________________________________________________\n" +
                            "     Got it. I've added this task:\n" + "       " + tasks[taskCount - 1].toString() + "\n" +
                            "     Now you have " + taskCount + " tasks in the list.\n" +
                            "    ____________________________________________________________");
                } else if (input.equals("deadline")) {
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
                } else if (input.equals("event")) {
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
                } else {

                    String taskName = input + scanner.nextLine();

                    tasks[taskCount] = new Task(taskName);
                    taskCount++;
                    System.out.println("    ____________________________________________________________\n" +
                            "     added: " + taskName + "\n" +
                            "    ____________________________________________________________");
                }

            }
        }
    }
}
