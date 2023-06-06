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
    protected void setParameters(PreparedStatement ps, Condition entity) throws SQLException {
        ps.setString(1, entity.getCondition());
    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (`condition`) VALUES (?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET `condition`=?, `condition_id`=? WHERE `condition_id`=?";
        return query;
    }

    @Override
    protected Condition mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("condition_id");
        String conditionName = rs.getString("condition");

        Condition condition = new Condition();
        condition.setConditionId(id);
        condition.setCondition(conditionName);

        return condition;
    }
}
