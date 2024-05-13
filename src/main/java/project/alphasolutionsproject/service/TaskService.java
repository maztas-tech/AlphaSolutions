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

    public List<Task> showAllTask(int projectID, int subProjectID) {
        return taskRepository.showAllTask(projectID, subProjectID);
    }
}
