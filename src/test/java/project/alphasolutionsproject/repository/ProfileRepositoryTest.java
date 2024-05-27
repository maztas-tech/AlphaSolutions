package project.alphasolutionsproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import project.alphasolutionsproject.model.Profile;
import project.alphasolutionsproject.model.Project;
import project.alphasolutionsproject.service.ProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class ProfileRepositoryTest {

    @Autowired
    ProfileService profileService;

    @Test
    void login() {
        Profile profile = new Profile(1, "jdoe_H2", "John_H2", "Doe_H2", "første", 1, 1);
        Profile logInProfile = profileService.logIn(profile);
        assertEquals(profile.getProfileID(),logInProfile.getProfileID());
    }
}