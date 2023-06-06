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
    protected void setParameters(PreparedStatement ps, Sale entity) throws SQLException {
        ps.setInt(1, entity.getSaleId());
        ps.setDouble(2, entity.getPrice());
        ps.setDate(3, entity.getDate());
        ps.setInt(4, entity.getEmployeeId());
        ps.setInt(5, entity.getCustomerId());
        ps.setInt(6, entity.getInventoryId());
        ps.setInt(7, entity.getInsuranceId());
        ps.setInt(8, entity.getPaymentMethodId());
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (price, date, employee_id, customer_id, inventory_id, insurance_id, payment_method_id) VALUES (?,?,?,?,?,?,?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET price=? WHERE sale_id = ?";
        return query;
    }

    @Override
    protected Sale mapResultSetToObject(ResultSet rs) throws SQLException {
        int saleId = rs.getInt("sale_id");
        double price = rs.getDouble("price");
        Date date = rs.getDate("date");
        int employeeId = rs.getInt("employee_id");
        int customerId = rs.getInt("customer_id");
        int inventoryId = rs.getInt("inventory_id");
        int insuranceId = rs.getInt("insurance_id");
        int paymentMethodId = rs.getInt("payment_method_id");

        Sale sale = new Sale();
        sale.setSaleId(saleId);
        sale.setPrice(price);
        sale.setDate(date);
        sale.setEmployeeId(employeeId);
        sale.setCustomerId(customerId);
        sale.setInventoryId(inventoryId);
        sale.setInsuranceId(insuranceId);
        sale.setPaymentMethodId(paymentMethodId);

        return sale;
    }
}
