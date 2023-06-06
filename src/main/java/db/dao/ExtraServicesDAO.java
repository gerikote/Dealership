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
    protected void setParameters(PreparedStatement ps, ExtraServices entity) throws SQLException {
        ps.setString(1, entity.getServiceName());
        ps.setString(2, entity.getServiceDescription());
        ps.setInt(3, entity.getPrice());

    }

    @Override
    protected String generateInsertQuery(ExtraServices entity) {
        String tableName = "extra_services";
        String columns = "sevice_name,service_description,price";
        String values = "?,?,?";
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        return query;
    }

    @Override
    protected String generateUpdateQuery(ExtraServices entity) {
        String tableName = "extra_services";
        String setIdentifiers = "price=?";
        String condition = "service_id = ?";
        String query = "UPDATE " + tableName + " SET " + setIdentifiers + " WHERE " + condition;
        return query;
    }

    @Override
    protected ExtraServices mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("service_id");
        String serviceName = rs.getString("service_name");
        String serviceDescription = rs.getString("service_description");
        int price = rs.getInt("price");

        ExtraServices extraServices = new ExtraServices();
        extraServices.setServiceId(id);
        extraServices.setServiceName(serviceName);
        extraServices.setServiceDescription(serviceDescription);
        extraServices.setPrice(price);

        return extraServices;
    }
}
