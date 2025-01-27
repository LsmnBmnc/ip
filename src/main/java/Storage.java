import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Storage {

    public Storage(String filepath) {

    }

    public static void load() {

    }
    public static void updateTxt() {
        try {
            Path directory = Paths.get("./data/Nana.txt");
            if (!Files.exists(directory)) {
                throw new IOException("File not found");
            }
            FileWriter fw = new FileWriter("./data/Nana.txt");
            fw.write(listTxt());
            fw.close();
        } catch (IOException e) {
            System.out.println("    ____________________________________________________________\n" +
                    "     Exception: " + e.getMessage() + "\n" +
                    "    ____________________________________________________________");
        }
    }

    public static String listTxt() {
        String txt = "";
        for (int i = 0; i < taskCount; i++) {
            txt += "     " + (i + 1) + "." + tasks.get(i) + "\n";
        }
        return txt;
    }

    public static void deleteTxt() {
        try {
            Path directory = Paths.get("./data/Nana.txt");
            Files.delete(directory);
        } catch (IOException e) {
            System.out.println("    ____________________________________________________________\n" +
                    "     Exception: " + e.getMessage() + "\n" +
                    "    ____________________________________________________________");
        }
    }
}
