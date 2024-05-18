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
        String SQL = "SELECT taskID, taskName, taskDescription, taskTimeEstimate FROM task WHERE subProjectID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, subProjectID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                taskSQLData = new Task(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );
                taskToShow.add(taskSQLData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskToShow;
    }

    public void createTask(Task task) {
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String SQL = "INSERT INTO task (taskName, taskDescription, taskTimeEstimate, subProjectID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, task.getTaskName());
            preparedStatement.setString(2, task.getTaskDescription());
            preparedStatement.setInt(3, task.getTaskTimeEstimate());
            preparedStatement.setInt(4, task.getSubProjectID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int taskID) {
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "DELETE FROM task WHERE taskID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, taskID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int findProjectID(int subProjectID) {
        int id = 0;
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "SELECT projectID FROM subProject WHERE subProjectId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, subProjectID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void editTask(Task task) {
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "UPDATE task SET taskName = ?, taskDescription = ?, taskTimeEstimate = ?  WHERE taskID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, task.getTaskName());
            ps.setString(2, task.getTaskDescription());
            ps.setInt(3, task.getTaskTimeEstimate());
            ps.setInt(4, task.getTaskID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int sumOfTaskTime(int subProjectID) {
        int sum = 0;
        String SQL = "SELECT SUM(taskTimeEstimate) FROM task WHERE subProjectID = ?";
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        try (PreparedStatement ps = connection.prepareStatement(SQL)) {
            ps.setInt(1, subProjectID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sum += rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Task searchTaskByID(int taskID) {
        String SQL = "SELECT taskID, taskName, taskDescription, taskTimeEstimate FROM task WHERE taskID = ?";
        Task taskObject = null;
        Connection connection = ConnectionManager.getConnection(db_url,db_user,db_pwd);
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, taskID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                taskObject = new Task(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskObject;
    }
}
