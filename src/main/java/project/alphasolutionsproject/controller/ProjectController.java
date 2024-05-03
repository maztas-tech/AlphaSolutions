package project.alphasolutionsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.repository.ProjectRepository;
import project.alphasolutionsproject.service.ProjectService;

@Controller
public class ProjectController {

    private ProjectService projectService;
    private Project project;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
        this.project = new Project();
    }
}
