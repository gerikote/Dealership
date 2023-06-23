package db.mybatis;

import db.interfaces.IExtraServicesDAO;
import db.model.ExtraServices;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class ExtraServicesDAO implements IExtraServicesDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(ExtraServices entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExtraServicesDAO extraServicesDAO = sqlSession.getMapper(IExtraServicesDAO.class);
            extraServicesDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public ExtraServices getByID(int id) {
        ExtraServices extraServices;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExtraServicesDAO extraServicesDAO = sqlSession.getMapper(IExtraServicesDAO.class);
            extraServices = extraServicesDAO.getByID(id);
        }
        return extraServices;
    }

    @Override
    public void update(ExtraServices entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExtraServicesDAO extraServicesDAO = sqlSession.getMapper(IExtraServicesDAO.class);
            extraServicesDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExtraServicesDAO extraServicesDAO = sqlSession.getMapper(IExtraServicesDAO.class);
            extraServicesDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<ExtraServices> getAll() {
        List<ExtraServices> extraServicesList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExtraServicesDAO extraServicesDAO = sqlSession.getMapper(IExtraServicesDAO.class);
            extraServicesList = extraServicesDAO.getAll();
        }
        return extraServicesList;
    }
}

