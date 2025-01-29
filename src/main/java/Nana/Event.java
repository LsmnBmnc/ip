package Nana;

public class Event extends Task{

    private String startTime;
    private String endTime;

    public Event (String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Event (String description, String startTime, String endTime, boolean isDone) {
        super(description, isDone);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + startTime + " to:" + endTime + ")";
    }

    @Override
    public String toStorage() {
        return toStorageIsDone() + " E event " + description + " /from " + startTime + " /to " + endTime;
    }

}
