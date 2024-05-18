package project.alphasolutionsproject.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import project.alphasolutionsproject.model.Profile;
import project.alphasolutionsproject.repository.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;

    public Profile login(String username, String password) {
        Connection conn = ConnectionManager.getConnection(db_url, db_user, db_pwd);

        String SQL = "SELECT firstName, lastName, roleName,userName,profileID,pw,departmentNO FROM profile WHERE username = ? AND password = ?";
        try(PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                String roleName = rs.getString(3);
                String userName = rs.getString(4);
                int profileID = rs.getInt(5);
                String pw = rs.getString(6);
                int departmentNO = rs.getInt(7);
                Profile profile = new Profile(userName,firstName,lastName,roleName);

                profile.setProfileID(profileID);
                profile.setPassword(pw);
                profile.setDepartmentNO(departmentNO);

                return profile;

            } else {
                System.out.println("not valid user name or password");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
