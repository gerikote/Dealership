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
        ps.setInt(3, entity.getEmployeeId());
        ps.setInt(4, entity.getCustomerId());
        ps.setInt(5, entity.getInventoryId());
        ps.setInt(6, entity.getInsuranceId());
        ps.setInt(7, entity.getPaymentMethodId());
        if (isUpdate) {
            ps.setInt(8, entity.getSaleId());
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
        sale.setSaleId(rs.getInt("sale_id"));
        sale.setPrice(rs.getInt("price"));
        sale.setDate(rs.getDate("date"));
        sale.setEmployeeId(rs.getInt("employee_id"));
        sale.setCustomerId(rs.getInt("customer_id"));
        sale.setInventoryId(rs.getInt("inventory_id"));
        sale.setInsuranceId(rs.getInt("insurance_id"));
        sale.setPaymentMethodId(rs.getInt("payment_method_id"));
        return sale;
    }
}
