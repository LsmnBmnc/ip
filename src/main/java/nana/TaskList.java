package nana;

import java.util.ArrayList;
public class TaskList {


    private static ArrayList<Task> tasks;
    private static int taskCount;

    public TaskList() {
        tasks = new ArrayList<>();
        taskCount = 0;
    }

    public TaskList(ArrayList<ArrayList<String>> tasks) {
        this.tasks = new ArrayList<>();

        for (ArrayList<String> task : tasks) {
            boolean isDone = Boolean.parseBoolean(task.get(0));
            task.remove(0);
            task.remove(0);
            try {
                this.process(task, isDone);
            } catch (NanaException e) {
                Ui.printNanaException(e);
            }
        }

        taskCount = tasks.size();
    }

    public void process(ArrayList<String> info) throws NanaException {
        String input = info.get(0);
        if (info.get(0).equals("blah")) {
            throw new NanaException("It seems no meaning");
        }
        if (input.equals("list")) {
            listTasks();
        } else if (input.equals("mark")) {
            markTask(Parser.parseMarkTask(info));
        } else if (input.equals("unmark")) {
            unmarkTask(Parser.parseUnmarkTask(info));
        } else if (input.equals("todo")) {
            addTodo(Parser.parseAddTodo(info));
        } else if (input.equals("deadline")) {
            addDeadline(Parser.parseAddDeadline(info));
        } else if (input.equals("event")) {
            addEvent(Parser.parseAddEvent(info));
        } else if (input.equals("delete")) {
            deleteTask(Parser.parseDeleteTask(info));
        } else if (input.equals("find")) {
            findTask(Parser.parseFindTask(info));
        }
        else {
            addTask(Parser.parseAddTask(info));

        }
    }

    public void process(ArrayList<String> info, boolean isDone) throws NanaException {
        String input = info.get(0);

        if (input.equals("todo")) {
            addTodo(Parser.parseAddTodo(info), isDone);
        } else if (input.equals("deadline")) {
            addDeadline(Parser.parseAddDeadline(info), isDone);
        } else if (input.equals("event")) {
            addEvent(Parser.parseAddEvent(info), isDone);
        } else {
            addTask(Parser.parseAddTask(info), isDone);

        }
    }

    public void findTask(ArrayList<String> parsed) {
        ArrayList<Task> matchTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(parsed.get(0))) {
                matchTasks.add(task);
            }
        }
        Ui.printFindTasks(matchTasks);
    }

    public void listTasks() {
        Ui.printListTasks(tasks, taskCount);
    }

    public static String listTxt() {
        String txt = "";
        for (int i = 0; i < taskCount; i++) {
            txt += "     " + tasks.get(i).toStorage() + "\n";
        }

        return txt;
    }

    public void addTodo(ArrayList<String> parsed) {
        tasks.add(new Todo(parsed.get(0)));
        addCount();
        Ui.printAddTodo(tasks.get(taskCount - 1), taskCount);
        Storage.updateTxt();
    }

    public void addTodo(ArrayList<String> parsed, boolean isDone) {
        tasks.add(new Todo(parsed.get(0), isDone));
        addCount();
        Ui.printAddTodo(tasks.get(taskCount - 1), taskCount);
        Storage.updateTxt();
    }

    public void addDeadline(ArrayList<String> parsed) {
        tasks.add(new Deadline(parsed.get(0), parsed.get(1)));
        addCount();
        Ui.printAddDeadline(tasks.get(taskCount - 1), taskCount);
        Storage.updateTxt();
    }

    public void addDeadline(ArrayList<String> parsed, boolean isDone) {
        tasks.add(new Deadline(parsed.get(0), parsed.get(1),isDone));
        addCount();
        Ui.printAddDeadline(tasks.get(taskCount - 1), taskCount);
        Storage.updateTxt();
    }

    public void addEvent(ArrayList<String> parsed) {
        tasks.add(new Event(parsed.get(0), parsed.get(1), parsed.get(2)));
        addCount();
        Ui.printAddEvent(tasks.get(taskCount - 1), taskCount);
        Storage.updateTxt();
    }

    public void addEvent(ArrayList<String> parsed, boolean isDone) {
        tasks.add(new Event(parsed.get(0), parsed.get(1), parsed.get(2), isDone));
        addCount();
        Ui.printAddEvent(tasks.get(taskCount - 1), taskCount);
        Storage.updateTxt();
    }

    public void deleteTask(int index) {
        Task task = tasks.get(index - 1);
        tasks.remove(index - 1);
        minsCount();
        Ui.printDeleteTask(task, taskCount);
        Storage.updateTxt();
    }

    public void markTask(int index) {
        tasks.get(index - 1).markAsDone();
        Ui.printMarkTask(tasks.get(index - 1));
        Storage.updateTxt();
    }

    public void unmarkTask(int index) {
        tasks.get(index - 1).markAsUndone();
        Ui.printUnmarkTask(tasks.get(index - 1));
        Storage.updateTxt();
    }

    public void addTask(ArrayList<String> parsed) {
        tasks.add(new Task(parsed.get(0)));
        addCount();
        Ui.printAddTask(tasks.get(taskCount - 1));
        Storage.updateTxt();
    }

    public void addTask(ArrayList<String> parsed, boolean isDone) {
        tasks.add(new Task(parsed.get(0), isDone));
        addCount();
        Ui.printAddTask(tasks.get(taskCount - 1));
        Storage.updateTxt();
    }

    private void addCount() {
        taskCount++;
    }

    private void minsCount() {
        taskCount--;
    }
}
