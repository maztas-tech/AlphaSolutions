package project.alphasolutionsproject.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class SubProject {
    private String subProjectName;
    private int subProjectID;
    private Date startDate;
    private Date endDate;
    private int projectID;


    public SubProject(String subProjectName, int subProjectID, Date startDate, Date endDate) {
        this.subProjectName = subProjectName;
        this.subProjectID = subProjectID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SubProject(String subProjectName, Date startDate, Date endDate, int projectID) {
        this.subProjectName = subProjectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectID = projectID;
    }

    public SubProject(String subProjectName, Date startDate, Date endDate) {
        this.subProjectName = subProjectName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SubProject(String subProjectName, int subProjectID, Date startDate, Date endDate, int projectID) {
        this.subProjectName = subProjectName;
        this.subProjectID = subProjectID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectID = projectID;
    }

    public SubProject() {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    @Override
    public String toString() {
        return "SubProject{" +
                "subProjectName='" + subProjectName + '\'' +
                ", subProjectID=" + subProjectID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", projectID=" + projectID +
                '}';
    }
}
