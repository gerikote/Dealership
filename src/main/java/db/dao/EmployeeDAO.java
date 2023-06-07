package db.dao;

import db.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends BaseDAO<Employee> {
    @Override
    protected String getTableName() {
        return "employees";
    }

    @Override
    protected String getIdName() {
        return "employee_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Employee entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getPosition());
        ps.setInt(2, entity.getSalary());
        ps.setInt(3, entity.getPersonID());
        if (isUpdate) {
            ps.setInt(4, entity.getEmployeeId());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (position, salary, person_id) VALUES (?, ?, ?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET position=?,salary=?,person_id=? WHERE employee_id=?";
        return query;
    }

    @Override
    protected Employee mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("employee_id");
        String position = rs.getString("position");
        int salary = rs.getInt("salary");
        int person_id = rs.getInt("person_id");

        Employee employee = new Employee();
        employee.setEmployeeID(id);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setPersonID(person_id);

        return employee;
    }
}
