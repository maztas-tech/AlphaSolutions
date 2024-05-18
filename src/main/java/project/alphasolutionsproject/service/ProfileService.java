package project.alphasolutionsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.alphasolutionsproject.model.Profile;
import project.alphasolutionsproject.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public Profile logIn(Profile profile){
        return profileRepository.login(profile);
    }

}
