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
    protected void setParameters(PreparedStatement ps, Color entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getColor());
        if (isUpdate) {
            ps.setInt(2, entity.getColorID());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (color) VALUES (?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET color=? WHERE color_id=?";
        return query;
    }

    @Override
    protected Color mapResultSetToObject(ResultSet rs) throws SQLException {
        Color color = new Color();
        color.setColorID(rs.getInt("color_id"));
        color.setColor(rs.getString("color"));

        return color;
    }
}
