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
public class ProfileRepository {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;

    public Profile login(Profile profile) {
        Connection conn = ConnectionManager.getConnection(db_url, db_user, db_pwd);

        String SQL = "SELECT firstName, lastName, roleID,userName,profileID,pw,departmentNO FROM profile WHERE username = ? AND pw = ?";
        try(PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, profile.getUsername());
            ps.setString(2, profile.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                int roleID = rs.getInt(3);
                String userName = rs.getString(4);
                int profileID = rs.getInt(5);
                String pw = rs.getString(6);
                int departmentNO = rs.getInt(7);
                Profile newProfile = new Profile(userName,firstName,lastName,roleID);

                newProfile.setProfileID(profileID);
                newProfile.setPassword(pw);
                newProfile.setDepartmentNO(departmentNO);

                return newProfile;

            } else {
                System.out.println("not valid user name or password");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void registrerBruger(Profile profile){
        if (profile.getUsername() != null){
            Connection connection = ConnectionManager.getConnection(db_url,db_user,db_pwd);
            String sql = "INSERT INTO profile(userName, firstName, lastName, pw, roleID, departmentNO) VALUES(?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)){

                ps.setString(1,profile.getUsername());
                ps.setString(2,profile.getFirstName());
                ps.setString(3,profile.getLastName());
                ps.setString(4,profile.getPassword());
                ps.setInt(5,profile.getRoleID());
                ps.setInt(6,profile.getDepartmentNO());

                ps.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
