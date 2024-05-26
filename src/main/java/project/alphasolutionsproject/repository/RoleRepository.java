package project.alphasolutionsproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import project.alphasolutionsproject.model.Role;
import project.alphasolutionsproject.repository.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleRepository {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;

    public List<Role> showRoles(){
        List<Role> allRoles = new ArrayList<>();
        Role role;
        Connection connection = ConnectionManager.getConnection(db_url,db_user,db_pwd);
        String sql = "SELECT roleID,roleName FROM role";
        try(Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                role = new Role(
                        rs.getInt(1),
                        rs.getString(2)
                );
                allRoles.add(role);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return allRoles;
    }

}
