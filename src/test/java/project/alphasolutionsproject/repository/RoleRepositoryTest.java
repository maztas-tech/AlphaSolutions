package project.alphasolutionsproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import project.alphasolutionsproject.model.Role;
import project.alphasolutionsproject.service.RoleService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class RoleRepositoryTest {
    @Autowired
    RoleService roleService;

    @Test
    void showRoles() {
        List<Role> roles = roleService.showRoles();
        assertEquals(2,roles.size());
    }
}