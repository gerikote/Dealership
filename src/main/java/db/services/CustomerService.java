package db.services;

import db.dao.CustomerDAO;
import db.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAll();
    }

    public Customer getCustomerByID(int id) {
        return customerDAO.getByID(id);
    }

    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }

    public void deleteCustomerByID(int id) {
        customerDAO.deleteByID(id);
    }
}

