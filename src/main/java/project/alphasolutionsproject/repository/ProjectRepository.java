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


    private Project projectSQLData;

    public List<Project> showAllProjects() {
        List<Project> projectsToShow = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "SELECT projectName, startDate, endDate FROM project";
        try (Statement statement = connection.createStatement()) {
            ResultSet rS = statement.executeQuery(sql);

            while (rS.next()) {
                projectSQLData = new Project(
                        rS.getString(1),
                        rS.getDate(2).toLocalDate(),
                        rS.getDate(3).toLocalDate()
                );
                //System.out.println(projectSQLData);
                projectsToShow.add(projectSQLData);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        //System.out.println(projectsToShow);
        return projectsToShow;

    }

    public void updateProject(Project project){
        String SQL = "UPDATE project SET projectName = ? WHERE projectID = ?";
        //Singleton
        Connection con = ConnectionManager.getConnection(db_url, db_user, db_pwd);

        try(PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setString(1, project.getProjectName());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createProject(Project project){
        Date startDate = Date.valueOf(project.getStartDate());
        Date endDate = Date.valueOf(project.getEndDate());
        Connection connection = ConnectionManager.getConnection(db_url,db_user,db_pwd);
        String sql = "INSERT INTO project (projectName,startDate,endDate) VALUES(?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,project.getProjectName());
            ps.setDate(2,startDate);
            ps.setDate(3,endDate);

            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


}
