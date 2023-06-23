package db.mybatis;

import db.interfaces.IInventoryDAO;
import db.model.Inventory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class InventoryDAO implements IInventoryDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Inventory entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Inventory getByID(int id) {
        Inventory inventory;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventory = inventoryDAO.getByID(id);
        }
        return inventory;
    }

    @Override
    public void update(Inventory entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> inventories;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventories = inventoryDAO.getAll();
        }
        return inventories;
    }
}
