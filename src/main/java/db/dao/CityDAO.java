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
    protected String generateInsertQuery(City entity) {
        String tableName = "cities";
        String columns = "city";
        String values = "?";
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        return query;
    }

    @Override
    protected String generateUpdateQuery(City entity) {
        String tableName = "cities";
        String setIdentifiers = "city=?";
        String condition = "city_id = ?";
        String query = "UPDATE " + tableName + " SET " + setIdentifiers + " WHERE " + condition;
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
