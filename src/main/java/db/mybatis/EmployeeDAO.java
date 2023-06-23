package db.mybatis;

import db.interfaces.IEmployeeDAO;
import db.model.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(Employee entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public Employee getByID(int id) {
        Employee employee;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employee = employeeDAO.getByID(id);
        }
        return employee;
    }

    @Override
    public void update(Employee entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employees = employeeDAO.getAll();
        }
        return employees;
    }
}
