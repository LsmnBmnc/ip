import java.util.ArrayList;
public class Parser {

    public static void processInput (String input, ArrayList<String> info) throws NanaException {
        if (input.equals("blah")){
            throw new NanaException("It seems no meaning");
        }
        if (input.equals("list")) {
            listTasks();
        } else if (input.equals("mark")) {
            markTask(info);
            updateTxt();
        } else if (input.equals("unmark")) {
            unmarkTask(info);
            updateTxt();
        } else if (input.equals("todo")) {
            addTodo(info);
            updateTxt();
        } else if (input.equals("deadline")) {
            addDeadline(info);
            updateTxt();
        } else if (input.equals("event")) {
            addEvent(info);
            updateTxt();
        } else if (input.equals("delete")) {
            deleteTask(info);
            updateTxt();
        }
        else {
            addTask(input, info);
            updateTxt();
        }
    }

    public static void listTasks() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("     " + (i + 1) + "." + tasks.get(i));
        }
        System.out.println("    ____________________________________________________________");
    }

    public static void markTask(ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The marked task can't be empty.");
        }
        int taskNumber = Integer.parseInt(info.get(1));
        tasks.get(taskNumber - 1).markAsDone();
        System.out.println("    ____________________________________________________________\n" +
                "     Nice! I've marked this task as done:\n" +
                "       [X] " + tasks.get(taskNumber - 1).getDescription() + "\n" +
                "    ____________________________________________________________");
    }

    public static void unmarkTask(ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The unmarked task can't be empty.");
        }
        int taskNumber = Integer.parseInt(info.get(1));
        tasks.get(taskNumber - 1).markAsUndone();
        System.out.println("    ____________________________________________________________\n" +
                "     Nice! I've marked this task as undone:\n" +
                "       [ ] " + tasks.get(taskNumber - 1).getDescription() + "\n" +
                "    ____________________________________________________________");
    }

    public static void addTodo(ArrayList<String> info) throws NanaException {

        if (info.size() == 1) {
            throw new NanaException("The description of a todo cannot be empty.");
        }

        String taskName = "";
        info.remove(0);
        for (String element : info) {
            taskName += element + " ";
        }

        tasks.add(taskCount,new Todo(taskName));
        taskCount++;
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task:\n" + "       " + tasks.get(taskCount - 1) + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void addDeadline(ArrayList<String> info) throws NanaException {

        if (info.size() == 1) {
            throw new NanaException("The description of a deadline cannot be empty.");
        }

        String taskName = "";
        info.remove(0);
        for (String element : info) {
            if (element.equals("/by")) {
                break;
            }
            taskName += element + " ";
        }

        String by = info.get(info.size() - 1);

        tasks.add(taskCount,new Deadline(taskName, by));
        taskCount++;
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task:\n" + "       " + tasks.get(taskCount - 1) + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void addEvent(ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The description of an event cannot be empty.");
        }

        String taskName = "";
        info.remove(0);
        for (String element : info) {
            if (element.equals("/from")) {
                break;
            }
            taskName += element + " ";
        }
        String startTime = info.get(info.size() - 4) + " " + info.get(info.size() - 3);
        String endTime = info.get(info.size() - 1);

        tasks.add(taskCount,new Event(taskName, startTime, endTime));
        taskCount++;
        System.out.println("    ____________________________________________________________\n" +
                "     Got it. I've added this task:\n" + "       " + tasks.get(taskCount - 1) + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void deleteTask (ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The deleted task can't be empty.");
        }
        int taskNumber = Integer.parseInt(info.get(1));
        Task task = tasks.get(taskNumber - 1);
        tasks.remove(taskNumber - 1);
        taskCount--;
        System.out.println("    ____________________________________________________________\n" +
                "     Noted. I've removed this task:\n" +
                "       " + task + "\n" +
                "     Now you have " + taskCount + " tasks in the list.\n" +
                "    ____________________________________________________________");
    }

    public static void addTask(String input, ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The description of a task cannot be empty.");
        }

        String taskName = "";
        info.remove(0);
        for (String element : info) {
            taskName += element + " ";
        }

        tasks.add(taskCount, new Task(taskName));
        taskCount++;
        System.out.println("    ____________________________________________________________\n" +
                "     added: " + taskName + "\n" +
                "    ____________________________________________________________");
    }
}
