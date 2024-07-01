package Models;

public class Task {
    
    private String TaskName;
    private int TaskNumber;
    private String TaskDescription;
    private String Developer;
    private double Duration;
    private String TaskID;
    private String Status;

    public Task(String TaskName, int TaskNumber, String TaskDescription, String Developer, double Duration, String TaskID, String Status) {
        this.TaskName = TaskName;
        this.TaskNumber = TaskNumber;
        this.TaskDescription = TaskDescription;
        this.Developer = Developer;
        this.Duration = Duration;
        this.TaskID = TaskID;
        this.Status = Status;
    }

    public String getTaskName() {
        return TaskName;
    }

    public int getTaskNumber() {
        return TaskNumber;
    }

    public String getTaskDescription() {
        return TaskDescription;
    }

    public String getDeveloper() {
        return Developer;
    }

    public double getDuration() {
        return Duration;
    }

    public String getTaskID() {
        return TaskID;
    }

    public String getStatus() {
        return Status;
    }
    
}
