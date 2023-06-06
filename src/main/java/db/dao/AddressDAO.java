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
        return "addresses_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Address entity) throws SQLException {
        ps.setString(1,entity.getAddress());
        ps.setString(2,entity.getZipCode());
        ps.setInt(3,entity.getCityID());
    }

    @Override
    protected String generateInsertQuery(Address entity) {
        String tableName = "addresses";
        String columns = " address, zip_code, city_id";
        String values = "?,?,?";
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        return query;    }

    @Override
    protected String generateUpdateQuery(Address entity) {
        String tableName = "addresses";
        String setIdentifiers = "address=?";
        String condition = "address_id = ?";
        String query = "UPDATE " + tableName + " SET " + setIdentifiers + " WHERE " + condition;
        return query;    }

    @Override
    protected Address mapResultSetToObject(ResultSet rs) throws SQLException {
        int addressID = rs.getInt("address_id");
        String address = rs.getString("address");
        String zipCode = rs.getString("zip_code");
        int cityId = rs.getInt("city_id");

        Address addressObj = new Address();
        addressObj.setAddressID(addressID);
        addressObj.setCityID(cityId);
        addressObj.setAddress(address);
        addressObj.setZipCode(zipCode);

        return addressObj;    }
}
