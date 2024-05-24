package project.alphasolutionsproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import project.alphasolutionsproject.model.Project;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class ProjectRepositoryTest {


    @Autowired
    ProjectRepository projectRepository;

    @Test
    void showAllProjects() {
        List<Project> allProjects = projectRepository.showAllProjects();
        assertEquals(allProjects.size(), projectRepository.showAllProjects().size());
    }

    @Test
    void searchID() {
        Project found = projectRepository.searchID(1);
        assertEquals(found.getProjectName(), projectRepository.searchID(1).getProjectName());
    }

    @Test
    void updateProject() {
        Project found = projectRepository.searchID(1);
        found.setProjectName("farax");
        projectRepository.updateProject(found);
        assertEquals(found.getProjectName(), projectRepository.searchID(1).getProjectName());
    }

    @Test
    void createProject() {
        List<Project> allProjects = projectRepository.showAllProjects();
        Project p = new Project(4, "abdi", new Date(2024, 6, 15), new Date(2024, 8, 15));
        projectRepository.createProject(p);
        assertEquals(allProjects.size() + 1, projectRepository.showAllProjects().size());
    }

    @Test
    void deleteProject() {
        List<Project> allProjects = projectRepository.showAllProjects();
        projectRepository.deleteProject(2);
        assertEquals(allProjects.size() - 1, projectRepository.showAllProjects().size());
    }

    @Test
    void findProjectID(){
        int projectID = projectRepository.findProjectID(1);
        int actualProjectID = 0;
        for (Project project : projectRepository.showAllProjects()) {
            if (project.getProjectID() == projectID) {
                actualProjectID = project.getProjectID();
            }
        }

        assertEquals(projectID, actualProjectID);
    }
}