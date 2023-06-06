package db.dao;

import db.model.Insurance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsuranceDAO extends BaseDAO<Insurance> {
    @Override
    protected String getTableName() {
        return "insurance";
    }

    @Override
    protected String getIdName() {
        return "service_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Insurance entity) throws SQLException {
        ps.setString(1, entity.getInsuranceCompany());
        ps.setInt(2,entity.getCoverage());
    }

    @Override
    protected String generateInsertQuery(Insurance entity) {
        String tableName = "insurance";
        String columns = "insurance_company,coverage";
        String values = "?,?";
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        return query;
    }

    @Override
    protected String generateUpdateQuery(Insurance entity) {
        String tableName = "insurance";
        String setIdentifiers = "insurance_company=?";
        String condition = "insurance_id = ?";
        String query = "UPDATE " + tableName + " SET " + setIdentifiers + " WHERE " + condition;
        return query;
    }

    @Override
    protected Insurance mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("insurance_id");
        String company = rs.getString("insurance_company");
        int coverage = rs.getInt("coverage");

        Insurance insurance = new Insurance();
        insurance.setInsuranceId(id);
        insurance.setInsuranceCompany(company);
        insurance.setCoverage(coverage);

        return insurance;    }
}
