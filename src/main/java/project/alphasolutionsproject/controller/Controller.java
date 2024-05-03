package project.alphasolutionsproject.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.alphasolutionsproject.service.Service;

@org.springframework.stereotype.Controller
@RequestMapping("alphasolutions")
public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;

    }

    @GetMapping("")
    public String showAllProjects(Model model) {
        model.addAttribute("projectList", service.showAllProjects());
        return "frontpage";
    }

}
