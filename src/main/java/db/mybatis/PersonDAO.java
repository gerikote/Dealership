package db.mybatis;

import db.interfaces.IPersonDAO;
import db.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class PersonDAO implements IPersonDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Person entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDAO = sqlSession.getMapper(IPersonDAO.class);
            personDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Person getByID(int id) {
        Person person;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDAO = sqlSession.getMapper(IPersonDAO.class);
            person = personDAO.getByID(id);
        }
        return person;
    }

    @Override
    public void update(Person entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDAO = sqlSession.getMapper(IPersonDAO.class);
            personDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDAO = sqlSession.getMapper(IPersonDAO.class);
            personDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDAO = sqlSession.getMapper(IPersonDAO.class);
            persons = personDAO.getAll();
        }
        return persons;
    }
}
