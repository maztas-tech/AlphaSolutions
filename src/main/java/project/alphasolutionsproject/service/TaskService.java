package project.alphasolutionsproject.service;

import org.springframework.stereotype.Service;
import project.alphasolutionsproject.model.Task;
import project.alphasolutionsproject.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> showAllTask(int subProjectID) {
        return taskRepository.showAllTask(subProjectID);
    }

    public void createTask(Task task) {
        taskRepository.createTask(task);
    }

    public void deleteTask(int taskID) {
        taskRepository.deleteTask(taskID);
    }

    public int findID(int subProjectID) {
        return taskRepository.findProjectID(subProjectID);
    }

    public void editTask(Task task) {
        taskRepository.editTask(task);
    }

    public int sumOfTask(int subProjectID) {
        return taskRepository.sumOfTaskTime(subProjectID);
    }
}
