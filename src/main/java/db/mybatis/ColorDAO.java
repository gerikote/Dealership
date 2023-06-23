package db.mybatis;


import db.interfaces.IColorDAO;
import db.model.Color;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class ColorDAO implements IColorDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Color entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IColorDAO colorDAO = sqlSession.getMapper(IColorDAO.class);
            colorDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Color getByID(int id) {
        Color color;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IColorDAO colorDAO = sqlSession.getMapper(IColorDAO.class);
            color = colorDAO.getByID(id);
        }
        return color;
    }

    @Override
    public void update(Color entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IColorDAO colorDAO = sqlSession.getMapper(IColorDAO.class);
            colorDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IColorDAO colorDAO = sqlSession.getMapper(IColorDAO.class);
            colorDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Color> getAll() {
        List<Color> colors;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IColorDAO colorDAO = sqlSession.getMapper(IColorDAO.class);
            colors = colorDAO.getAll();
        }
        return colors;
    }
}