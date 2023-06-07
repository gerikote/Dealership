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
        int id = rs.getInt("manufacturer_id");
        String manufacturerName = rs.getString("manufacturer");
        String phone = rs.getString("phone_number");
        String email = rs.getString("email");

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(id);
        manufacturer.setManufacturer(manufacturerName);
        manufacturer.setPhoneNumber(phone);
        manufacturer.setEmail(email);

        return manufacturer;
    }
}
