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
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM " + getTableName();

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
            closeResources(connection, ps, rs);
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
            closeResources(connection, ps, rs);
        }
        return object;
    }

    public void deleteByID(int id) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.getConnection();
            String query = "DELETE FROM " + getTableName() + " WHERE " + getIdName() + " = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, ps);
        }
    }

    public void save(T entity) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.getConnection();
            String query = generateInsertQuery();
            ps = connection.prepareStatement(query);
            setParameters(ps, entity, false);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, ps);
        }
    }

    public void update(T entity) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.getConnection();
            String query = generateUpdateQuery();

            ps = connection.prepareStatement(query);
            setParameters(ps, entity, true);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, ps);
        }
    }

    private void closeResources(Connection connection, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResources(Connection connection, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
