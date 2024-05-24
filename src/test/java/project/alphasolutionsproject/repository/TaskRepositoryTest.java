package project.alphasolutionsproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.model.SubProject;
import project.alphasolutionsproject.model.Task;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("dev")
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void showAllTask() {
        List<Task> allTasks = taskRepository.showAllTask(1);
        assertEquals(allTasks.size(),taskRepository.showAllTask(1).size());
    }

    @Test
    void createTask() {
        List<Task> allTasks = taskRepository.showAllTask(1);
        Task t = new Task(4, "Task 77", "Testing", 15, 1);
        taskRepository.createTask(t);
        assertEquals(allTasks.size() + 1, taskRepository.showAllTask(1).size());
    }

    @Test
    void deleteTask() {
        List<Task> allTasks = taskRepository.showAllTask(1);
        taskRepository.deleteTask(2);
        assertEquals(allTasks.size() - 1, taskRepository.showAllTask(1).size());

    }

    @Test
    void editTask() {
        Task found = taskRepository.searchTaskByID(1);
        found.setTaskName("farax");
        taskRepository.editTask(found);
        assertEquals(found.getTaskName(), taskRepository.searchTaskByID(1).getTaskName());
    }

    @Test
    void sumOfTaskTime() {
       int actualValue = taskRepository.sumOfTaskTime(1);
        int sumValue = 0;
        for (Task task: taskRepository.showAllTask(1)) {
            sumValue += task.getTaskTimeEstimate();
        }

        assertEquals(actualValue, sumValue);
    }

    @Test
    void searchTaskByID() {
        Task found = taskRepository.searchTaskByID(1);
        assertEquals(found.getTaskName(), taskRepository.searchTaskByID(1).getTaskName());
    }
}