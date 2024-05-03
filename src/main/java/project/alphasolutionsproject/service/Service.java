package project.alphasolutionsproject.service;

import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private Repository repository;

    public List<Project> showAllProjects() {
        return repository.showAllProjects();
    }

}
