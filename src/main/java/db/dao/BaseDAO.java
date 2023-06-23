package db.dao;

import db.interfaces.IBaseDAO;
import db.conection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> implements IBaseDAO<T> {

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

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                T object = mapResultSetToObject(rs);
                resultList.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, connection);
        }

        return resultList;
    }

    public T getByID(int id) {
        T object = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM " + getTableName() + " WHERE " + getIdName() + " = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                object = mapResultSetToObject(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, connection);
        }

        return object;
    }

    public void deleteByID(int id) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.getConnection();
            ps = connection.prepareStatement("DELETE FROM " + getTableName() + " WHERE " + getIdName() + " = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, connection);
        }
    }

    public void save(T entity) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.getConnection();
            ps = connection.prepareStatement(generateInsertQuery());
            setParameters(ps, entity, false);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, connection);
        }
    }

    public void update(T entity) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.getConnection();
            ps = connection.prepareStatement(generateUpdateQuery());
            setParameters(ps, entity, true);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, ps, connection);
        }
    }

    private void closeResources(ResultSet rs, PreparedStatement ps, Connection connection) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            connectionPool.releaseConnection(connection);
        }
    }
}
