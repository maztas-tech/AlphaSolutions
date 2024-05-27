package project.alphasolutionsproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import project.alphasolutionsproject.model.Department;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository departmentRepository;


    @Test
    void showDepartments() {
        List<Department> departments = departmentRepository.showDepartments();
        assertEquals(3,departments.size());
    }
}