import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{

    private LocalDate by;
    private String byString;

    public Deadline (String description, String by) {
        super(description);
        this.byString = by;
        this.by = LocalDate.parse(by);
    }

    public Deadline (String description, String by, boolean isDone) {
        super(description, isDone);
        this.byString = by;
        this.by = LocalDate.parse(by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    @Override
    public String toStorage() {
        return toStorageIsDone() + " D deadline " + description + " /by " + byString;
    }
}
