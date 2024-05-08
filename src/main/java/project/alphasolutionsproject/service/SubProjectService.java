package project.alphasolutionsproject.service;

import org.springframework.stereotype.Service;
import project.alphasolutionsproject.model.SubProject;
import project.alphasolutionsproject.repository.SubProjectRepository;

import java.util.List;

@Service
public class SubProjectService {

    SubProjectRepository subProjectRepository;

    public SubProjectService(SubProjectRepository subProjectRepository) {
        this.subProjectRepository = subProjectRepository;
    }


    public List<SubProject> showAllSubProject(int projectID) {
        return subProjectRepository.showAllSubProject(projectID);
    }


}
