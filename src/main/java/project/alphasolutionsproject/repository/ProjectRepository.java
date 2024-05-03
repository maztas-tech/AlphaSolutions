package project.alphasolutionsproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.repository.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ProjectRepository {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;

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


}
