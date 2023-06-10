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
    protected void setParameters(PreparedStatement ps, Insurance entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getInsuranceCompany());
        ps.setInt(2, entity.getCoverage());
        if (isUpdate) {
            ps.setInt(3, entity.getInsuranceId());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (insurance_company, coverage) VALUES (?, ?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET insurance_company=?, coverage=? WHERE insurance_id=?";
        return query;
    }

    @Override
    protected Insurance mapResultSetToObject(ResultSet rs) throws SQLException {
        Insurance insurance = new Insurance();
        insurance.setInsuranceId(rs.getInt("insurance_id"));
        insurance.setInsuranceCompany(rs.getString("insurance_company"));
        insurance.setCoverage(rs.getInt("coverage"));
        return insurance;
    }
}
