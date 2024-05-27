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
        return projects;
    }

    public Project searchProjectById(int projectID) {
        return projectRepository.searchID(projectID);
    }

    public void editProject(Project project) {
        projectRepository.updateProject(project);
    }

    public void createProject(Project project) {
        projectRepository.createProject(project);
    }

    public void deleteProject(int projectID) {
        projectRepository.deleteProject(projectID);
    }

    public int findID(int subProjectID) {
        return projectRepository.findProjectID(subProjectID);
    }
}
