package db.services;

import db.dao.EmployeeDAO;
import db.model.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }

    public Employee getEmployeeByID(int id) {
        return employeeDAO.getByID(id);
    }

    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    public void deleteEmployeeByID(int id) {
        employeeDAO.deleteByID(id);
    }
}

