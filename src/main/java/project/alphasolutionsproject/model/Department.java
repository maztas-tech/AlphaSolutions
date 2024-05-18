package project.alphasolutionsproject.model;

public class Department {
    private int departmentNO;
    private String departmentName;

    public Department(int departmentNO, String departmentName) {
        this.departmentNO = departmentNO;
        this.departmentName = departmentName;
    }

    public int getDepartmentNO() {
        return departmentNO;
    }

    public void setDepartmentNO(int departmentNO) {
        this.departmentNO = departmentNO;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
