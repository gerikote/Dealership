package db.mybatis;

import db.interfaces.IManufacturerDAO;
import db.model.Manufacturer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class ManufacturerDAO implements IManufacturerDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Manufacturer entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Manufacturer getByID(int id) {
        Manufacturer manufacturer;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturer = manufacturerDAO.getByID(id);
        }
        return manufacturer;
    }

    @Override
    public void update(Manufacturer entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Manufacturer> getAll() {
        List<Manufacturer> manufacturers;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturers = manufacturerDAO.getAll();
        }
        return manufacturers;
    }
}
