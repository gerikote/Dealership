package db.dao;

import db.model.Manufacturer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManufacturerDAO extends BaseDAO<Manufacturer> {

    @Override
    protected String getTableName() {
        return "manufacturer";
    }

    @Override
    protected String getIdName() {
        return "manufacturer_id";
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (manufacturer, phone_number, email) VALUES (?,?,?)";
        return query;
    }

    @Override
    protected void setParameters(PreparedStatement ps, Manufacturer entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getManufacturer());
        ps.setString(2, entity.getPhoneNumber());
        ps.setString(3, entity.getEmail());
        if (isUpdate) {
            ps.setInt(4, entity.getManufacturerId());
        }
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET  manufacturer = ? , phone_number =? , email =? WHERE manufacturer_id=?";
        return query;
    }

    @Override
    protected Manufacturer mapResultSetToObject(ResultSet rs) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(rs.getInt("manufacturer_id"));
        manufacturer.setManufacturer(rs.getString("manufacturer"));
        manufacturer.setPhoneNumber(rs.getString("phone_number"));
        manufacturer.setEmail(rs.getString("email"));
        return manufacturer;
    }
}
