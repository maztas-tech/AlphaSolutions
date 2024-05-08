package project.alphasolutionsproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.model.SubProject;
import project.alphasolutionsproject.repository.util.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SubProjectRepository {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;

    public List<SubProject> showAllSubProject(int projectID) {
        SubProject subProjectSQLData;
        List<SubProject> subProjectsToShow = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String SQL = "SELECT subProjectName, startDate, endDate FROM subproject WHERE projectID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, projectID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                subProjectSQLData = new SubProject(
                        resultSet.getString(1),
                        resultSet.getDate(2),
                        resultSet.getDate(3)
                );
                subProjectsToShow.add(subProjectSQLData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subProjectsToShow;
    }

    public void createSubProject(SubProject subProject){
        Connection connection = ConnectionManager.getConnection(db_url,db_user,db_pwd);
        String sql2 = "INSERT INTO subProject (subProjectName, startDate, endDate, projectID) VALUES (?,?,?,?)";
         try(PreparedStatement ps = connection.prepareStatement(sql2)) {

             ps.setString(1,subProject.getSubProjectName());
             ps.setDate(2,subProject.getStartDate());
             ps.setDate(3,subProject.getEndDate());
             ps.setInt(4,subProject.getProjectID());

             ps.executeUpdate();

         }catch (SQLException e){
             e.printStackTrace();
         }
    }

}
