package db.mybatis;


import db.interfaces.ICityDAO;
import db.model.City;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class CityDAO implements ICityDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(City entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            cityDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public City getByID(int id) {
        City city;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            city = cityDAO.getByID(id);
        }
        return city;
    }

    @Override
    public void update(City entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            cityDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            cityDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<City> getAll() {
        List<City> cities;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            cities = cityDAO.getAll();
        }
        return cities;
    }
}