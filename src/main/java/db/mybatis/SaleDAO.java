package db.mybatis;

import db.interfaces.ISaleDAO;
import db.model.Sale;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class SaleDAO implements ISaleDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Sale entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISaleDAO saleDAO = sqlSession.getMapper(ISaleDAO.class);
            saleDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Sale getByID(int id) {
        Sale sale;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISaleDAO saleDAO = sqlSession.getMapper(ISaleDAO.class);
            sale = saleDAO.getByID(id);
        }
        return sale;
    }

    @Override
    public void update(Sale entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISaleDAO saleDAO = sqlSession.getMapper(ISaleDAO.class);
            saleDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISaleDAO saleDAO = sqlSession.getMapper(ISaleDAO.class);
            saleDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Sale> getAll() {
        List<Sale> sales;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISaleDAO saleDAO = sqlSession.getMapper(ISaleDAO.class);
            sales = saleDAO.getAll();
        }
        return sales;
    }
}
