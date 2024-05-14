package project.alphasolutionsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.model.SubProject;
import project.alphasolutionsproject.model.Task;
import project.alphasolutionsproject.service.ProjectService;
import project.alphasolutionsproject.service.SubProjectService;
import project.alphasolutionsproject.service.TaskService;

@Controller
@RequestMapping("/alphasolutions")
public class ProjectController {

    private ProjectService projectService;
    private SubProjectService subProjectService;
    private TaskService taskService;

    public ProjectController(ProjectService projectService, SubProjectService subProjectService, TaskService taskService) {
        this.projectService = projectService;
        this.subProjectService = subProjectService;
        this.taskService = taskService;
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
    @GetMapping("/{projectID}/subProjects")
    public String showAllSubProjects(Model model, @PathVariable int projectID) {
        model.addAttribute("subProjectList", subProjectService.showAllSubProject(projectID));
        return "subProject";
    }

    @GetMapping("/{projectID}/createSubProject")
    public String createSubProjectForm(@PathVariable int projectID, Model model) {
        model.addAttribute("projectID", projectID);
        model.addAttribute("subProjectObject", new SubProject());
        return "create_subProject";
    }

    @PostMapping("/createSubProject")
    public String createSubProject(@ModelAttribute("subProjectObject") SubProject subProject) {
        subProjectService.createSubProject(subProject);
        return "redirect:/alphasolutions/" + subProject.getProjectID() + "/subProjects";
    }


    @GetMapping("/{projectID}/subProjects/{subProjectID}/remove")
    public String deleteSubProject(@PathVariable("subProjectID") int subProjectID,
                                   @PathVariable("projectID") int projectID) {
        subProjectService.deleteSubProject(subProjectID);
        return "redirect:/alphasolutions/" + projectID + "/subProjects";

    }

    @GetMapping("/{projectID}/{subProjectID}/edit_subproject")
    public String editSubProject(@PathVariable int subProjectID, Model model) {
        model.addAttribute("subProjectObject", subProjectService.getSubProjectID(subProjectID));
        model.addAttribute("projectID", subProjectService.getSubProjectID(subProjectID).getProjectID());
        return "edit_subProject";
    }

    @PostMapping("/edit_subproject")
    public String editSubProject(@ModelAttribute SubProject subProject) {
        subProjectService.editSubProject(subProject);
        return "redirect:/alphasolutions/" + subProject.getProjectID() + "/subProjects";
    }


    // Task
    @GetMapping("{projectID}/{subProjectID}/tasks")
    public String showAllTasks(Model model, @PathVariable int subProjectID) {
        model.addAttribute("taskList", taskService.showAllTask(subProjectID));
        model.addAttribute("sumOfTasks", taskService.sumOfTask(subProjectID));
        return "task";
    }

    @GetMapping("/{subProjectID}/createTask")
    public String createTask(Model model, @PathVariable int subProjectID)  {
        model.addAttribute("subProjectID", subProjectID);
        model.addAttribute("taskObject", new Task());
        return "create_task";
    }

    @PostMapping("/createTask")
    public String createTask(@ModelAttribute("taskObject") Task task) {
        SubProject subProject = subProjectService.getSubProjectID(task.getSubProjectID());
        int projectID = subProject.getProjectID();
        taskService.createTask(task);
        System.out.println(task);
        return "redirect:/alphasolutions/" + projectID + "/" + task.getSubProjectID() + "/tasks";
    }

    @GetMapping("/{subProjectID}/{taskID}/delete")
    public String deleteTask(@PathVariable int subProjectID,
                             @PathVariable int taskID){
        int projectID = taskService.findID(subProjectID);
        taskService.deleteTask(taskID);
        return "redirect:/alphasolutions/" + projectID + "/" + subProjectID + "/tasks";
    }

    @GetMapping("/{subProjectID}/{taskID}/edit_task")
    public String editTaskForm(@PathVariable int taskID, Model model, Task task){
        model.addAttribute("task",task);
        model.addAttribute("taskID",taskID);
        return "edit_task";
    }

    @PostMapping("/edit_task")
    public String editTask(@ModelAttribute Task task){
        SubProject subProject = subProjectService.getSubProjectID(task.getSubProjectID());
        int projectId = subProject.getProjectID();
        int subProjectID = task.getSubProjectID();
        taskService.editTask(task);
        return "redirect:/alphasolutions/" + projectId + "/" + subProjectID + "/tasks";
    }

}
