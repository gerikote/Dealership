package db.mybatis;

import db.interfaces.ICustomerDAO;
import db.model.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Customer entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Customer getByID(int id) {
        Customer customer;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customer = customerDAO.getByID(id);
        }
        return customer;
    }

    @Override
    public void update(Customer entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customers = customerDAO.getAll();
        }
        return customers;
    }
}

