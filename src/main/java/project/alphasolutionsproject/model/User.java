package project.alphasolutionsproject.model;


public class User {
    private int userID;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
    private int departmentNO;
    private int ekspertiseID;

    public User() {}

    public User(int userID, String username, String firstName, String lastName, String password, String role, int departmentNO, int ekspertiseID) {
        this.userID = userID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.departmentNO = departmentNO;
        this.ekspertiseID = ekspertiseID;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepartmentNO() {
        return departmentNO;
    }

    public void setDepartmentNO(int departmentNO) {
        this.departmentNO = departmentNO;
    }

    public int getEkspertiseID() {
        return ekspertiseID;
    }

    public void setEkspertiseID(int ekspertiseID) {
        this.ekspertiseID = ekspertiseID;
    }
}
