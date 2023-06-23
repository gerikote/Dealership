package db.mybatis;

import db.interfaces.IConditionDAO;
import db.model.Condition;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class ConditionDAO implements IConditionDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Condition entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IConditionDAO conditionDAO = sqlSession.getMapper(IConditionDAO.class);
            conditionDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Condition getByID(int id) {
        Condition condition;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IConditionDAO conditionDAO = sqlSession.getMapper(IConditionDAO.class);
            condition = conditionDAO.getByID(id);
        }
        return condition;
    }

    @Override
    public void update(Condition entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IConditionDAO conditionDAO = sqlSession.getMapper(IConditionDAO.class);
            conditionDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IConditionDAO conditionDAO = sqlSession.getMapper(IConditionDAO.class);
            conditionDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Condition> getAll() {
        List<Condition> conditions;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IConditionDAO conditionDAO = sqlSession.getMapper(IConditionDAO.class);
            conditions = conditionDAO.getAll();
        }
        return conditions;
    }
}
