package db.dao;

import db.interfaces.IBaseDao;
import db.conection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> implements IBaseDao<T> {

    private ConnectionPool connectionPool;

    protected abstract String getTableName();

    protected abstract String getIdName();

    protected abstract void setParameters(PreparedStatement ps, T entity, boolean isUpdate) throws SQLException;

    protected abstract String generateInsertQuery();

    protected abstract String generateUpdateQuery();

    protected abstract T mapResultSetToObject(ResultSet rs) throws SQLException;

    public BaseDAO() {
        connectionPool = ConnectionPool.getInstance();
    }

    public List<T> getAll() {
        List<T> resultList = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                T object = mapResultSetToObject(rs);
                resultList.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public T getByID(int id) {
        T object = null;

        try {
            Connection connection = connectionPool.getConnection();
            String query = "SELECT * FROM " + getTableName() + " WHERE " + getIdName() + " = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                object = mapResultSetToObject(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    public void deleteByID(int id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM " + getTableName() + " WHERE " + getIdName() + " = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void save(T entity) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(generateInsertQuery())) {
            setParameters(ps, entity, false);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(T entity) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(generateUpdateQuery())) {
            setParameters(ps, entity, true);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
