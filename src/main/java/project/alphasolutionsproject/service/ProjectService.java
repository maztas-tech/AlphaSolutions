package project.alphasolutionsproject.service;

import org.springframework.stereotype.Service;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.repository.ProjectRepository;

@Service
public class ProjectService {
    ProjectRepository projectRepository;

    public void editProject(Project project) {
        projectRepository.updateProject(project);
    }
}
