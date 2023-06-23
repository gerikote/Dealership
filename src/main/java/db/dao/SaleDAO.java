package db.dao;

import db.model.Sale;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleDAO extends BaseDAO<Sale> {

    @Override
    protected String getTableName() {
        return "sales";
    }

    @Override
    protected String getIdName() {
        return "sale_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Sale entity, boolean isUpdate) throws SQLException {
        ps.setInt(1, entity.getPrice());
        ps.setDate(2, entity.getDate());
        ps.setInt(3, entity.getEmployeeID());
        ps.setInt(4, entity.getCustomerID());
        ps.setInt(5, entity.getInventoryID());
        ps.setInt(6, entity.getInsuranceID());
        ps.setInt(7, entity.getPaymentMethodID());
        if (isUpdate) {
            ps.setInt(8, entity.getSaleID());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (price, date, employee_id, customer_id, inventory_id, insurance_id, payment_method_id) VALUES (?,?,?,?,?,?,?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET price=?, date=?, employee_id=?, customer_id=?, inventory_id=?, insurance_id=?, payment_method_id=? WHERE sale_id = ?";
        return query;
    }

    @Override
    protected Sale mapResultSetToObject(ResultSet rs) throws SQLException {
        Sale sale = new Sale();
        sale.setSaleID(rs.getInt("sale_id"));
        sale.setPrice(rs.getInt("price"));
        sale.setDate(rs.getDate("date"));
        sale.setEmployeeID(rs.getInt("employee_id"));
        sale.setCustomerID(rs.getInt("customer_id"));
        sale.setInventoryID(rs.getInt("inventory_id"));
        sale.setInsuranceID(rs.getInt("insurance_id"));
        sale.setPaymentMethodID(rs.getInt("payment_method_id"));
        return sale;
    }
}
