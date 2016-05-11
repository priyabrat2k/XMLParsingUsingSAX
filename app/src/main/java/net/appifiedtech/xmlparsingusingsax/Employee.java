package net.appifiedtech.xmlparsingusingsax;

/**
 * Created by Priyabrat on 11-05-2016.
 */
public class Employee {

    private int id;
    private String name;
    private String department;
    private String type;
    private String email;

    public Employee() {

    }

    public Employee(String name, String department, String type, String email) {
        this.name = name;
        this.department = department;
        this.type = type;
        this.email = email;
    }

    public Employee(int id, String name, String department, String type, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.type = type;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
