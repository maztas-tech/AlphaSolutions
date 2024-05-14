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


    public List<Task> showAllTask(int subProjectID) {
        Task taskSQLData;
        List<Task> taskToShow = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String SQL = "SELECT taskName, taskDescription, taskTimeEstimate, taskID FROM task WHERE subProjectID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, subProjectID);
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

    public void deleteTask (int taskID){
        Connection connection = ConnectionManager.getConnection(db_url,db_user,db_pwd);
        String sql = "DELETE FROM task WHERE taskID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,taskID);
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int findProjectID(int subProjectID){
        int id = 0;
        Connection connection = ConnectionManager.getConnection(db_url,db_user,db_pwd);
        String sql ="SELECT projectID FROM subProject WHERE subProjectId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,subProjectID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }
}
