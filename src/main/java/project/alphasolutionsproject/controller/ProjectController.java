package project.alphasolutionsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.model.SubProject;
import project.alphasolutionsproject.service.ProjectService;
import project.alphasolutionsproject.service.SubProjectService;

@Controller
@RequestMapping("/alphasolutions")
public class ProjectController {

    private ProjectService projectService;
    private SubProjectService subProjectService;

    public ProjectController(ProjectService projectService, SubProjectService subProjectService) {
        this.projectService = projectService;
        this.subProjectService = subProjectService;
    }

    // Project
    @GetMapping("")
    public String showAllProjects(Model model) {
        model.addAttribute("projectList", projectService.showAllProjects());
        return "frontpage";
    }


    @GetMapping("/{projectID}/edit")
    public String getEdit(@PathVariable int projectID, ModelMap model) {
        Project project = projectService.searchProjectById(projectID);
        model.addAttribute("projectObject", project);
        return "edit_project";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Project project) {

        projectService.editProject(project);
        System.out.println(project);
        return "redirect:/alphasolutions";
    }

    @GetMapping("/createProject")
    public String createProjectForm(Model model) {
        model.addAttribute("projectObejct", new Project());
        return "create_project";
    }

    @PostMapping("/createProject")
    public String createProject(@ModelAttribute("projectObject") Project project) {
        projectService.createProject(project);
        return "redirect:/alphasolutions";
    }

    @GetMapping("/{projectID}/deleteProject")
    public String deleteProject(@PathVariable int projectID) {
        projectService.deleteProject(projectID);
        return "redirect:/alphasolutions";
    }

    // SubProject
    @GetMapping("{projectID}/subProjects")
    public String showAllSubProjects(Model model, @PathVariable int projectID) {
        model.addAttribute("subProjectList", subProjectService.showAllSubProject(projectID));
        return "subProject";
    }

    @GetMapping("/{projectID}/createSubProject")
    public String createSubProjectForm(@PathVariable int projectID, Model model) {
        model.addAttribute("projectID",projectID);
        model.addAttribute("subProjectObejct", new SubProject());
        return "create_subProject";
    }

    @PostMapping("/createSubProject")
    public String createSubProject(@ModelAttribute("subProjectObject") SubProject subProject) {
        subProjectService.createSubProject(subProject);
        return "redirect:/alphasolutions/" + subProject.getProjectID() + "/subProjects";
    }

}
