package db.services;

import db.dao.PaymentMethodDAO;
import db.model.PaymentMethod;

import java.util.List;

public class PaymentMethodService {
    private PaymentMethodDAO paymentMethodDAO;

    public PaymentMethodService() {
        paymentMethodDAO = new PaymentMethodDAO();
    }

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodDAO.getAll();
    }

    public PaymentMethod getPaymentMethodByID(int id) {
        return paymentMethodDAO.getByID(id);
    }

    public void savePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodDAO.save(paymentMethod);
    }

    public void updatePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodDAO.update(paymentMethod);
    }

    public void deletePaymentMethodByID(int id) {
        paymentMethodDAO.deleteByID(id);
    }
}

