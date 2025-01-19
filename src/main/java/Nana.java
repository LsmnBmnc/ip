import java.util.Scanner;
public class Nana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm Nana\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________");

        String[] tasks = new String[100];

        int taskCount = 0;

        while (true) {
            String input = scanner.nextLine();
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
                } else {
                    tasks[taskCount] = input;
                    taskCount++;
                    System.out.println("    ____________________________________________________________\n" +
                            "     added: " + input + "\n" +
                            "    ____________________________________________________________");
                }

            }
        }
    }
}
