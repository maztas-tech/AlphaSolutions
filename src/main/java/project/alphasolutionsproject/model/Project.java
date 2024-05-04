package project.alphasolutionsproject.model;

import java.time.LocalDate;
import java.util.List;

public class Project {

    private int projectID;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<SubProject> subProjectList;
    private List<Task> taskListProject;

    public Project(int projectID, String projectName,  LocalDate startDate, LocalDate endDate) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project(String projectName, LocalDate startDate, LocalDate endDate) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project(String projectName, LocalDate startDate, LocalDate endDate, List<SubProject> subProjectList, List<Task> taskListProject) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subProjectList = subProjectList;
    }

    public Project(String projectName, LocalDate startDate, LocalDate endDate, List<Task> taskListProject) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskListProject = taskListProject;
    }

    public Project() {}

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", projectID=" + projectID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", subProjectList=" + subProjectList +
                ", taskListProject=" + taskListProject +
                '}';
    }
}
