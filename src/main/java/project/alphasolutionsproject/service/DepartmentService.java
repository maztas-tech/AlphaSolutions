package project.alphasolutionsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.alphasolutionsproject.model.Department;
import project.alphasolutionsproject.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> showDepartments(){
        return departmentRepository.showDepartments();
    }
}
