package project.alphasolutionsproject.model;

import java.time.LocalDate;

public class Project {

    private String projectName;
    private int projectID;
    private LocalDate startDate;
    private LocalDate endDate;

    public Project(String projectName, int projectID, LocalDate startDate, LocalDate endDate) {
        this.projectName = projectName;
        this.projectID = projectID;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
