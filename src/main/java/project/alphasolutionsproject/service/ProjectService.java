package project.alphasolutionsproject.service;

import org.springframework.stereotype.Service;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {
    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> showAllProjects() {
        List<Project> projects = projectRepository.showAllProjects();
        //System.out.println(projects);
        return projects;
    }

    public void editProject(Project project) {
        projectRepository.updateProject(project);
    }

    public void createProject(Project project){
        projectRepository.createProject(project);
    }
}
