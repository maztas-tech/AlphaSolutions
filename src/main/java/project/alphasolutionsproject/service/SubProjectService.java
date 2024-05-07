package project.alphasolutionsproject.service;

import org.springframework.stereotype.Service;
import project.alphasolutionsproject.repository.SubProjectRepository;

@Service
public class SubProjectService {

    SubProjectRepository subProjectRepository;

    public SubProjectService(SubProjectRepository subProjectRepository) {
        this.subProjectRepository = subProjectRepository;
    }



}
