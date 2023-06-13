package db.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlAttribute
    private int employeeID;
    @XmlElement
    private String position;
    @XmlElement
    private int salary;
    @XmlElement
    private int personID;

    public Employee() {
    }

    public Employee(String position, int salary, int personID) {
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
