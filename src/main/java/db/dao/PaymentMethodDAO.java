package db.dao;

import db.model.PaymentMethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodDAO extends BaseDAO<PaymentMethod> {
    @Override
    protected String getTableName() {
        return "payment_methods";
    }

    @Override
    protected String getIdName() {
        return "payment_method_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, PaymentMethod entity) throws SQLException {
        ps.setString(1, "payment_method");
    }

    @Override
    protected String generateInsertQuery(PaymentMethod entity) {
        String tableName = "payment_methods";
        String columns = "payment_method";
        String values = "?";
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        return query;
    }

    @Override
    protected String generateUpdateQuery(PaymentMethod entity) {
        String tableName = "payment_methods";
        String setIdentifiers = "payment_method=?";
        String condition = "payment_method_id = ?";
        String query = "UPDATE " + tableName + " SET " + setIdentifiers + " WHERE " + condition;
        return query;
    }

    @Override
    protected PaymentMethod mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("payment_method_id");
        String paymentMethod = rs.getString("payment_method");

       PaymentMethod paymentMethod1= new PaymentMethod();
        paymentMethod1.setPaymentMethodId(id);
        paymentMethod1.setPaymentMethod(paymentMethod);

        return paymentMethod1;    }
}
