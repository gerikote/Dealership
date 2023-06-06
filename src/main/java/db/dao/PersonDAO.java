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
    protected void setParameters(PreparedStatement ps, Person entity) throws SQLException {
        ps.setString(1, entity.getFirstName());
        ps.setString(2, entity.getLastName());
        ps.setDate(3, entity.getDateOfBirth());
        ps.setString(4, entity.getPhoneNumber());
        ps.setString(5, entity.getEmail());
        ps.setInt(6, entity.getAddressID());
    }

    @Override
    protected String generateInsertQuery(Person entity) {
        String tableName = "people";
        String columns = " first_name, last_name, date_of_birth, phone_number, email, address_id";
        String values = "?,?,?,?,?,?";
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        return query;
    }

    @Override
    protected String generateUpdateQuery(Person entity) {
        String tableName = "people";
        String setIdentifiers = "email=?";
        String condition = "person_id = ?";
        String query = "UPDATE " + tableName + " SET " + setIdentifiers + " WHERE " + condition;
        return query;
    }

    @Override
    protected Person mapResultSetToObject(ResultSet rs) throws SQLException {
        int addressId = rs.getInt("address_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Date dateOfBirth = rs.getDate("date_of_birth");
        String phoneNumber = rs.getString("phone_number");
        String email = rs.getString("email");

        Person person = new Person();
        person.setAddressID(addressId);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDateOfBirth(dateOfBirth);
        person.setPhoneNumber(phoneNumber);
        person.setEmail(email);

        return person;
    }
}
