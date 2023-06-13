package db.dao;

import db.model.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO extends BaseDAO<City> {

    @Override
    protected String getTableName() {
        return "cities";
    }

    @Override
    protected String getIdName() {
        return "city_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, City entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getCity());
        if (isUpdate) {
            ps.setInt(2, entity.getCityID());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (city) VALUES (?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET city=? WHERE city_id=?";
        return query;
    }

    @Override
    protected City mapResultSetToObject(ResultSet rs) throws SQLException {
        City city = new City();
        city.setCityID(rs.getInt("city_id"));
        city.setCity(rs.getString("city"));
        return city;
    }
}
