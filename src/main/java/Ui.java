import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    private ArrayList<String> inputArrayList;
    private Scanner scanner;
    private String[] inputList;

    public Ui() {
        this.inputArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
    }
    public void printGreeting() {
        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm Nana\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________");
    }

    public void printBye() {
        System.out.println("    ____________________________________________________________\n" +
                "     Bye. Hope to see you again soon!\n" +
                "    ____________________________________________________________");
    }

    public void printException(NanaException e) {
        System.out.println("    ____________________________________________________________\n" +
                "     Exception: " + e.getMessage() + "\n" +
                "    ____________________________________________________________");

    }

    public void showLoadingError() {
        System.out.println("    ____________________________________________________________\n" +
                "     Exception: File not found\n" +
                "    ____________________________________________________________");
    }


    public void readInput() {
        String input = scanner.nextLine().trim();
        inputList = input.split("\\s+");
        for (String s: inputList) {
            inputArrayList.add(s);
        }
    }

    public String getSignal() {
        return inputArrayList.get(0);
    }

    public ArrayList<String> getInfo() {
        return inputArrayList;
    }


}
