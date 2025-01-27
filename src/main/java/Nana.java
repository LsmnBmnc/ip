import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.time.LocalDate;

public class Nana {

    /**
     * private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskCount = 0;
     **/

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Nana(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (NanaException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.printGreeting();

        while (true) {
            ui.readInput();

            if (ui.getSignal().equals("bye")) {
                ui.printBye();
                break;
            } else {
                try {
                    Parser.processInput(ui.getSignal(), ui.getInfo());
                } catch (NanaException e) {
                    ui.printException(e);
            }
    }

    public static void main(String[] args) {
        new Nana("./data/Nana.txt").run();

    }

    }
}
}

