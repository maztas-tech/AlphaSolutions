package project.alphasolutionsproject.model;

public class Task {
    private String taskName;
    private String taskDescription;
    private int taskID;
    private int taskTimeEstimate;
    private int projectID;
    private int subProjectID;

    public Task(int projectID, String taskName, String taskDescription, int taskID, int taskTimeEstimate) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskID = taskID;
        this.taskTimeEstimate = taskTimeEstimate;
        this.projectID = projectID;
    }

    public Task(String taskName, String taskDescription, int taskID, int taskTimeEstimate, int subProjectID) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskID = taskID;
        this.taskTimeEstimate = taskTimeEstimate;
        this.subProjectID = subProjectID;
    }






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

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getSubProjectID() {
        return subProjectID;
    }

    public void setSubProjectID(int subProjectID) {
        this.subProjectID = subProjectID;
    }
}
