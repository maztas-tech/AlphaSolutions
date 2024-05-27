package project.alphasolutionsproject.model;


public class Profile {
    private int profileID;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private int roleID;
    private int departmentNO;

    public Profile() {}

    public Profile(int profileID, String username, String firstName, String lastName, String password, int roleID, int departmentNO) {
        this.profileID = profileID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.roleID = roleID;
        this.departmentNO = departmentNO;
    }

    public Profile(String username, String firstName, String lastName, int roleID) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleID = roleID;
    }


    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getDepartmentNO() {
        return departmentNO;
    }

    public void setDepartmentNO(int departmentNO) {
        this.departmentNO = departmentNO;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileID=" + profileID +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", roleID=" + roleID +
                ", departmentNO=" + departmentNO +
                '}';
    }
}
