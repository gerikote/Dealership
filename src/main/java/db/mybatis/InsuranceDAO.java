package db.mybatis;

import db.interfaces.IInsuranceDAO;
import db.model.Insurance;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class InsuranceDAO implements IInsuranceDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Insurance entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInsuranceDAO insuranceDAO = sqlSession.getMapper(IInsuranceDAO.class);
            insuranceDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Insurance getByID(int id) {
        Insurance insurance;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInsuranceDAO insuranceDAO = sqlSession.getMapper(IInsuranceDAO.class);
            insurance = insuranceDAO.getByID(id);
        }
        return insurance;
    }

    @Override
    public void update(Insurance entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInsuranceDAO insuranceDAO = sqlSession.getMapper(IInsuranceDAO.class);
            insuranceDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInsuranceDAO insuranceDAO = sqlSession.getMapper(IInsuranceDAO.class);
            insuranceDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Insurance> getAll() {
        List<Insurance> insuranceList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInsuranceDAO insuranceDAO = sqlSession.getMapper(IInsuranceDAO.class);
            insuranceList = insuranceDAO.getAll();
        }
        return insuranceList;
    }
}

