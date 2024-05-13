package project.alphasolutionsproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import project.alphasolutionsproject.model.Task;
import project.alphasolutionsproject.repository.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;


    public List<Task> showAllTask(int projectID, int subProjectID) {
        Task taskSQLData;
        List<Task> taskToShow = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String SQL = "SELECT taskName, taskDescription, taskTimeEstimate, taskID FROM task WHERE projectID = ? AND subProjectID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, projectID);
            preparedStatement.setInt(2, subProjectID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                taskSQLData = new Task(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                );
                taskToShow.add(taskSQLData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskToShow;
    }
}
