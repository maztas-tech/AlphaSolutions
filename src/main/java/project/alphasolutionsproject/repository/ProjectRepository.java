package project.alphasolutionsproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.repository.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepository {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;


    public List<Project> showAllProjects() {
        Project projectSQLData;
        List<Project> projectsToShow = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "SELECT projectID, projectName, startDate, endDate FROM project";
        try (Statement statement = connection.createStatement()) {
            ResultSet rS = statement.executeQuery(sql);

            while (rS.next()) {
                projectSQLData = new Project(
                        rS.getInt(1),
                        rS.getString(2),
                        rS.getDate(3),
                        rS.getDate(4)
                );
                projectsToShow.add(projectSQLData);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return projectsToShow;

    }

    public Project searchID(int projectID) {
        String SQL = "SELECT projectID, projectName, startDate, endDate FROM project WHERE projectID = ?";
        Project projectObject = null;
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        try (PreparedStatement ps = connection.prepareStatement(SQL)) {
            ps.setInt(1, projectID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                projectObject = new Project(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectObject;
    }

    //UPDATE project SET projectName = ?, startDate = ?, endDate = ? WHERE projectID = ?
    public void updateProject(Project project) {
        String SQL = """       
                UPDATE project
                SET
                    projectName = ?,
                    startDate = ?,
                    endDate = ?
                WHERE projectID = ?;
                        
                        """;
        //Singleton
        Connection con = ConnectionManager.getConnection(db_url, db_user, db_pwd);

        try (PreparedStatement ps = con.prepareStatement(SQL)) {

            ps.setString(1, project.getProjectName());
            ps.setDate(2, project.getStartDate());
            ps.setDate(3, project.getEndDate());
            ps.setInt(4, project.getProjectID());


            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createProject(Project project) {
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "INSERT INTO project (projectName,startDate,endDate) VALUES(?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, project.getProjectName());
            ps.setDate(2, project.getStartDate());
            ps.setDate(3, project.getEndDate());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteProject(int projectID) {
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "DELETE FROM task WHERE subProjectID IN (SELECT subProjectID FROM subProject WHERE projectID = ?)";
        String sql2 = "DELETE FROM subProject WHERE projectID = ?";
        String sql3 = "DELETE FROM project WHERE projectID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
             PreparedStatement preparedStatement3 = connection.prepareStatement(sql3))
        {

            //Removing tasks
            preparedStatement.setInt(1, projectID);
            preparedStatement.executeUpdate();

            //Removing a subProject
            preparedStatement2.setInt(1, projectID);
            preparedStatement2.executeUpdate();

            //Removing a project
            preparedStatement3.setInt(1, projectID);
            preparedStatement3.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
