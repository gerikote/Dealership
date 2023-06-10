package db.dao;

import db.model.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO extends BaseDAO<Address> {

    @Override
    protected String getTableName() {
        return "addresses";
    }

    @Override
    protected String getIdName() {
        return "address_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Address entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getAddress());
        ps.setString(2, entity.getZipCode());
        ps.setInt(3, entity.getCityID());
        if (isUpdate) {
            ps.setInt(4, entity.getAddressID());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (address, zip_code, city_id) VALUES (?,?,?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET address=?, zip_code=?, city_id=? WHERE address_id=?";
        return query;
    }

    @Override
    protected Address mapResultSetToObject(ResultSet rs) throws SQLException {
        Address addressObj = new Address();
        addressObj.setAddressID(rs.getInt("address_id"));
        addressObj.setCityID(rs.getInt("city_id"));
        addressObj.setAddress(rs.getString("address"));
        addressObj.setZipCode(rs.getString("zip_code"));
        return addressObj;
    }
}
