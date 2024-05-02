package project.alphasolutionsproject.model;

public class Task {
    private String taskName;
    private String taskDescription;
    private int taskID;
    private int taskTimeEstimate;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getTaskTimeEstimate() {
        return taskTimeEstimate;
    }

    public void setTaskTimeEstimate(int taskTimeEstimate) {
        this.taskTimeEstimate = taskTimeEstimate;
    }
}
