package db.dao;

import db.model.Person;

import java.sql.*;

public class PersonDAO extends BaseDAO<Person> {

    @Override
    protected String getTableName() {
        return "people";
    }

    @Override
    protected String getIdName() {
        return "person_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Person entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getFirstName());
        ps.setString(2, entity.getLastName());
        ps.setDate(3, entity.getDateOfBirth());
        ps.setString(4, entity.getPhoneNumber());
        ps.setString(5, entity.getEmail());
        ps.setInt(6, entity.getAddressID());
        if (isUpdate) {
            ps.setInt(7, entity.getPersonID());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (first_name, last_name, date_of_birth, phone_number, email, address_id) VALUES (?,?,?,?,?,?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET first_name=?, last_name=?, date_of_birth=?, phone_number=?, email=?, address_id=? WHERE person_id=?";
        return query;
    }

    @Override
    protected Person mapResultSetToObject(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setAddressID(rs.getInt("address_id"));
        person.setFirstName(rs.getString("first_name"));
        person.setLastName(rs.getString("last_name"));
        person.setDateOfBirth(rs.getDate("date_of_birth"));
        person.setPhoneNumber(rs.getString("phone_number"));
        person.setEmail(rs.getString("email"));

        return person;
    }
}
