package project.alphasolutionsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.repository.ProjectRepository;
import project.alphasolutionsproject.service.ProjectService;

@Controller
@RequestMapping("/alphasolutions")
public class ProjectController {

    private ProjectService projectService;
    private Project project;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
        this.project = new Project();
    }

    @GetMapping("")
    public String showAllProjects(Model model) {
        model.addAttribute("projectList", projectService.showAllProjects());
        return "frontpage";
    }


    @GetMapping("/edit")
    public String edit(ModelMap model) {
        return "edit_project";
    }
}
