package project.alphasolutionsproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.model.SubProject;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class SubProjectRepositoryTest {

    @Autowired
    SubProjectRepository subProjectRepository;

    @Test
    void showAllSubProject() {
        List<SubProject> allSubProjects = subProjectRepository.showAllSubProject(1);
        assertEquals(allSubProjects.size(),subProjectRepository.showAllSubProject(1).size());
    }

    @Test
    void createSubProject() {
        List<SubProject> allSubProjects = subProjectRepository.showAllSubProject(1);
        SubProject s = new SubProject(1, "SubA", new Date(2023,10,10), new Date(2024, 10, 10), 1);
        subProjectRepository.createSubProject(s);
        assertEquals(allSubProjects.size() + 1, subProjectRepository.showAllSubProject(1).size());
    }

    @Test
    void deleteProject() {
        List<SubProject> allSubProjects = subProjectRepository.showAllSubProject(1);
        subProjectRepository.deleteProject(2);
        assertEquals(allSubProjects.size() - 1, subProjectRepository.showAllSubProject(1).size());
    }

    @Test
    void searchSubProjectID() {
        SubProject found = subProjectRepository.searchSubProjectID(1);
        assertEquals(found.getSubProjectName(),subProjectRepository.searchSubProjectID(1).getSubProjectName());
    }

    @Test
    void editSubProject() {
        SubProject found = subProjectRepository.searchSubProjectID(1);
        found.setSubProjectName("farax");
        subProjectRepository.editSubProject(found);
        assertEquals(found.getSubProjectName(),subProjectRepository.searchSubProjectID(1).getSubProjectName());
    }
}