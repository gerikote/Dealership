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
    protected void setParameters(PreparedStatement ps, PaymentMethod entity, boolean isUpdate) throws SQLException {
        ps.setString(1, "payment_method");
        if (isUpdate) {
            ps.setInt(2, entity.getPaymentMethodId());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (payment_method) VALUES (?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET payment_method=? WHERE payment_method_id=?";
        return query;
    }

    @Override
    protected PaymentMethod mapResultSetToObject(ResultSet rs) throws SQLException {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentMethodId(rs.getInt("payment_method_id"));
        paymentMethod.setPaymentMethod(rs.getString("payment_method"));
        return paymentMethod;
    }
}
