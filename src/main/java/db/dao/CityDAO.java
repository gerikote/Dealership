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
    protected void setParameters(PreparedStatement ps, City entity) throws SQLException {
        ps.setString(1, entity.getCity());
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
        int id = rs.getInt("city_id");
        String cityName = rs.getString("city");

        City city = new City();
        city.setCityID(id);
        city.setCity(cityName);

        return city;
    }
}
