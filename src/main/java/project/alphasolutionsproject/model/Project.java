package project.alphasolutionsproject.model;

import java.time.LocalDate;
import java.util.List;

public class Project {

    private String projectName;
    private int projectID;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<SubProject> subProjectList;
    private List<Task> taskListProject;

    public Project(String projectName, int projectID, LocalDate startDate, LocalDate endDate) {
        this.projectName = projectName;
        this.projectID = projectID;
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
}
