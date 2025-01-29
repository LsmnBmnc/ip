package nana;

import java.io.IOException;

public class Nana {



    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Nana(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
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
                    tasks.process(ui.getInfo());
                } catch (NanaException e) {
                    ui.printNanaException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Nana("./data/Nana.txt").run();

    }
}
