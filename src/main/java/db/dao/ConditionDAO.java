package db.dao;

import db.model.Condition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConditionDAO extends BaseDAO<Condition> {

    @Override
    protected String getTableName() {
        return "conditions";
    }

    @Override
    protected String getIdName() {
        return "condition_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Condition entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getCondition());
        if (isUpdate) {
            ps.setInt(2, entity.getConditionID());
        }
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (`condition`) VALUES (?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET `condition`=? WHERE `condition_id`=?";
        return query;
    }

    @Override
    protected Condition mapResultSetToObject(ResultSet rs) throws SQLException {
        Condition condition = new Condition();
        condition.setConditionID(rs.getInt("condition_id"));
        condition.setCondition(rs.getString("condition"));
        return condition;
    }
}
