package db.dao;

import db.model.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ColorDAO extends BaseDAO<Color> {

    @Override
    protected String getTableName() {
        return "colors";
    }

    @Override
    protected String getIdName() {
        return "color_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Color entity) throws SQLException {
        ps.setString(1, entity.getColor());
    }

    @Override
    protected String generateInsertQuery(Color entity) {
        String tableName = "colors";
        String columns = "color";
        String values = "?";
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        return query;
    }

    @Override
    protected String generateUpdateQuery(Color entity) {
        String tableName = "colors";
        String setIdentifiers = "color=?";
        String condition = "color_id = ?";
        String query = "UPDATE " + tableName + " SET " + setIdentifiers + " WHERE " + condition;
        return query;
    }

    @Override
    protected Color mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("color_id");
        String colorName = rs.getString("color");

        Color color = new Color();
        color.setColorId(id);
        color.setColor(colorName);

        return color;
    }
}