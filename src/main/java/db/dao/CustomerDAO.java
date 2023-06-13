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
    protected void setParameters(PreparedStatement ps, Customer entity, boolean isUpdate) throws SQLException {
        ps.setBoolean(1, entity.getVipStatus());
        ps.setInt(2, entity.getPersonID());
        if (isUpdate) {
            ps.setInt(3, entity.getCustomerId());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (vip_status, person_id) VALUES (?, ?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET vip_status=?, person_id WHERE customer_id=?";
        return query;
    }

    @Override
    protected Customer mapResultSetToObject(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setVipStatus(rs.getBoolean("vip_status"));
        customer.setPersonID(rs.getInt("person_id"));
        return customer;
    }
}
