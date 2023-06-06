package db.model;

import java.sql.Date;
import java.time.LocalDate;

public class Employee {
    private int employeeID;
    private String position;
    private int salary;
    private int personID;

    public Employee() {
    }

    public Employee(int employeeID, String position, int salary, int personID) {
        this.employeeID = employeeID;
        this.position = position;
        this.salary = salary;
        this.personID = personID;
    }

    public int getEmployeeId() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personId) {
        this.personID = personId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", personID=" + personID +
                '}';
    }
}
