package project.alphasolutionsproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.alphasolutionsproject.model.Project;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectRepositoryTest {


    @Autowired
    ProjectRepository repository;

    @Test
    void showAllProjects() {
        List<Project> allProjects = repository.showAllProjects();
        assertEquals(allProjects.size(),repository.showAllProjects().size());
    }

    @Test
    void searchID() {
        Project found = repository.searchID(1);
        assertEquals(found.getProjectName(),repository.searchID(1).getProjectName());
    }

    @Test
    void updateProject() {
        Project found = repository.searchID(1);
        found.setProjectName("farax");
        repository.updateProject(found);
        assertEquals(found.getProjectName(),repository.searchID(1).getProjectName());
    }

    @Test
    void createProject() {
        List<Project> allProjects = repository.showAllProjects();
        Project p = new Project(4, "abdi", new Date(2024, 6, 15), new Date(2024, 8, 15));
        repository.createProject(p);
        assertEquals(allProjects.size() + 1, repository.showAllProjects().size());
    }

    @Test
    void deleteProject() {
        List<Project> allProjects = repository.showAllProjects();
        repository.deleteProject(2);
        assertEquals(allProjects.size() - 1, repository.showAllProjects().size());
    }
}