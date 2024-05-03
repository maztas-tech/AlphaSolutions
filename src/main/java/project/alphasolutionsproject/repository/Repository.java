package project.alphasolutionsproject.repository;

import org.springframework.beans.factory.annotation.Value;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.repository.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

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
                projectsToShow.add(projectSQLData);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return projectsToShow;
    }


}
