package db.dao;

import db.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends BaseDAO<Customer> {
    @Override
    protected String getTableName() {
        return "customers";
    }

    @Override
    protected String getIdName() {
        return "customer_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Customer entity) throws SQLException {
        ps.setBoolean(1, entity.getVipStatus());
        ps.setInt(2, entity.getPersonID());
    }

    @Override
    protected String generateInsertQuery(Customer entity) {
        String tableName = "customers";
        String columns = "vip_status,person_id";
        String values = "?,?";
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        return query;
    }

    @Override
    protected String generateUpdateQuery(Customer entity) {
        String tableName = "customers";
        String setIdentifiers = "vip_status=?";
        String condition = "customer_id = ?";
        String query = "UPDATE " + tableName + " SET " + setIdentifiers + " WHERE " + condition;
        return query;
    }

    @Override
    protected Customer mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("customer_id");
        Boolean isVip = rs.getBoolean("vip_status");
        int personID = rs.getInt("person_id");

        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setVipStatus(isVip);
        customer.setPersonID(personID);

        return customer;
    }
}
