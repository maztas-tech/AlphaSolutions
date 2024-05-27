package project.alphasolutionsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.alphasolutionsproject.model.Role;
import project.alphasolutionsproject.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    RoleRepository repository;

    public RoleService (RoleRepository repository){
        this.repository = repository;
    }

    public List<Role> showRoles(){
        return repository.showRoles();
    }
}
