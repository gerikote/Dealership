package db.mybatis;

import db.interfaces.IAddressDAO;
import db.model.Address;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;


public class AddressDAO implements IAddressDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Address entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAddressDAO addressDAO = sqlSession.getMapper(IAddressDAO.class);
            addressDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Address getByID(int id) {
        Address address;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAddressDAO addressDAO = sqlSession.getMapper(IAddressDAO.class);
            address = addressDAO.getByID(id);
        }
        return address;
    }

    @Override
    public void update(Address entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAddressDAO addressDAO = sqlSession.getMapper(IAddressDAO.class);
            addressDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAddressDAO addressDAO = sqlSession.getMapper(IAddressDAO.class);
            addressDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAddressDAO addressDAO = sqlSession.getMapper(IAddressDAO.class);
            addresses = addressDAO.getAll();
        }
        return addresses;
    }
}
