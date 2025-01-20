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
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println("     " + (i + 1) + ". " + tasks[i]);
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
