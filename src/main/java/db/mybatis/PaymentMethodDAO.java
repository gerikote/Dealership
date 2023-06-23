package db.mybatis;

import db.interfaces.IPaymentMethodDAO;
import db.model.PaymentMethod;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisSqlFactory;

import java.util.List;

public class PaymentMethodDAO implements IPaymentMethodDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void save(PaymentMethod entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPaymentMethodDAO paymentMethodDAO = sqlSession.getMapper(IPaymentMethodDAO.class);
            paymentMethodDAO.save(entity);
            sqlSession.commit();
        }
    }

    @Override
    public PaymentMethod getByID(int id) {
        PaymentMethod paymentMethod;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPaymentMethodDAO paymentMethodDAO = sqlSession.getMapper(IPaymentMethodDAO.class);
            paymentMethod = paymentMethodDAO.getByID(id);
        }
        return paymentMethod;
    }

    @Override
    public void update(PaymentMethod entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPaymentMethodDAO paymentMethodDAO = sqlSession.getMapper(IPaymentMethodDAO.class);
            paymentMethodDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPaymentMethodDAO paymentMethodDAO = sqlSession.getMapper(IPaymentMethodDAO.class);
            paymentMethodDAO.deleteByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<PaymentMethod> getAll() {
        List<PaymentMethod> paymentMethods;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPaymentMethodDAO paymentMethodDAO = sqlSession.getMapper(IPaymentMethodDAO.class);
            paymentMethods = paymentMethodDAO.getAll();
        }
        return paymentMethods;
    }
}

