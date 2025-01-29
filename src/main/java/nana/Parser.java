package nana;

import java.util.ArrayList;
public class Parser {

    public static int parseMarkTask(ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The marked task can't be empty.");
        }
        return Integer.parseInt(info.get(1));

    }

    public static int parseUnmarkTask(ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The unmarked task can't be empty.");
        }
        return Integer.parseInt(info.get(1));

    }

    public static ArrayList<String> parseAddTodo(ArrayList<String> info) throws NanaException {

        if (info.size() == 1) {
            throw new NanaException("The description of a todo cannot be empty.");
        }

        ArrayList<String> parsed = new ArrayList<>();
        String taskName = "";
        info.remove(0);
        for (String element : info) {
            taskName += element + " ";
        }
        parsed.add(taskName);
        return parsed;

    }

    public static ArrayList<String> parseAddDeadline(ArrayList<String> info) throws NanaException {

        if (info.size() == 1) {
            throw new NanaException("The description of a deadline cannot be empty.");
        }

        ArrayList<String> parsed = new ArrayList<>();
        String taskName = "";
        info.remove(0);
        for (String element : info) {
            if (element.equals("/by")) {
                break;
            }
            taskName += element + " ";
        }

        String by = info.get(info.size() - 1);
        parsed.add(taskName);
        parsed.add(by);

        return parsed;
    }

    public static ArrayList<String> parseAddEvent(ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The description of an event cannot be empty.");
        }

        ArrayList<String> parsed = new ArrayList<>();
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

        parsed.add(taskName);
        parsed.add(startTime);
        parsed.add(endTime);

        return parsed;
    }

    public static int parseDeleteTask(ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The deleted task can't be empty.");
        }
        return Integer.parseInt(info.get(1));

    }

    public static ArrayList<String> parseAddTask(ArrayList<String> info) throws NanaException {
        if (info.size() == 1) {
            throw new NanaException("The description of a task cannot be empty.");
        }

        ArrayList<String> parsed = new ArrayList<>();
        String taskName = "";
        info.remove(0);
        for (String element : info) {
            taskName += element + " ";
        }
        parsed.add(taskName);
        return parsed;
    }

}

