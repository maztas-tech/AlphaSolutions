package project.alphasolutionsproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.model.SubProject;
import project.alphasolutionsproject.repository.util.ConnectionManager;

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
