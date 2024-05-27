package project.alphasolutionsproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import project.alphasolutionsproject.model.Department;
import project.alphasolutionsproject.repository.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;

    public List<Department> showDepartments(){
        List<Department> allDepartments = new ArrayList<>();
        Department department;
        Connection connection = ConnectionManager.getConnection(db_url,db_user,db_pwd);
        String sql = "SELECT departmentNO,departmentName FROM department";
        try(Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                department = new Department(
                        rs.getInt(1),
                        rs.getString(2)
                );
                allDepartments.add(department);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return allDepartments;
    }

}
