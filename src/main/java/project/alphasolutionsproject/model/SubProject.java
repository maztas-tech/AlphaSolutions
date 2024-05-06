package project.alphasolutionsproject.model;

import java.time.LocalDate;
import java.util.List;

public class SubProject {
    private String subProjectName;
    private int subProjectID;
    private LocalDate startDate;
    private LocalDate endDate;
    private int projectID;


    public SubProject(String subProjectName, int subProjectID, LocalDate startDate, LocalDate endDate) {
        this.subProjectName = subProjectName;
        this.subProjectID = subProjectID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SubProject(String subProjectName, LocalDate startDate, LocalDate endDate, int projectID) {
        this.subProjectName = subProjectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectID = projectID;
    }

    public String getSubProjectName() {
        return subProjectName;
    }

    public void setSubProjectName(String subProjectName) {
        this.subProjectName = subProjectName;
    }

    public int getSubProjectID() {
        return subProjectID;
    }

    public void setSubProjectID(int subProjectID) {
        this.subProjectID = subProjectID;
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

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
}
