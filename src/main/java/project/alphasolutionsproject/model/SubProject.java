package project.alphasolutionsproject.model;

import java.time.LocalDate;

public class SubProject {
    private String subProjectName;
    private int subProjectID;
    private LocalDate startDate;
    private LocalDate endDate;


    public SubProject(String subProjectName, int subProjectID, LocalDate startDate, LocalDate endDate) {
        this.subProjectName = subProjectName;
        this.subProjectID = subProjectID;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
