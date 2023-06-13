package db.dao;

import db.model.ExtraServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtraServicesDAO extends BaseDAO<ExtraServices> {

    @Override
    protected String getTableName() {
        return "extra_services";
    }

    @Override
    protected String getIdName() {
        return "service_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, ExtraServices entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getServiceName());
        ps.setString(2, entity.getServiceDescription());
        ps.setInt(3, entity.getPrice());
        if (isUpdate) {
            ps.setInt(4, entity.getServiceId());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (service_name, service_description, price) VALUES (?, ?, ?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET service_name = ? , service_description=? , price=?  WHERE service_id=?";
        return query;
    }

    @Override
    protected ExtraServices mapResultSetToObject(ResultSet rs) throws SQLException {
        ExtraServices extraServices = new ExtraServices();
        extraServices.setServiceId(rs.getInt("service_id"));
        extraServices.setServiceName(rs.getString("service_name"));
        extraServices.setServiceDescription(rs.getString("service_description"));
        extraServices.setPrice(rs.getInt("price"));
        return extraServices;
    }
}
