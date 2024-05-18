package project.alphasolutionsproject.model;


import java.util.List;
import java.sql.Date;

public class Project {

    private int projectID;
    private String projectName;
    private Date startDate;
    private Date endDate;
    private int userID;

    public Project(int projectID, String projectName, Date startDate, Date endDate) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project(String projectName, Date startDate, Date endDate) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project(int projectID, String projectName, Date startDate, Date endDate, int userID) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userID = userID;
    }

    public Project() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", projectID=" + projectID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
