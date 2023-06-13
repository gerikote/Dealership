package db.services;

import db.dao.AddressDAO;
import db.model.Address;

import java.util.List;

public class AddressService {
    private AddressDAO addressDAO;

    public AddressService() {
        addressDAO = new AddressDAO();
    }

    public List<Address> getAllAddresses() {
        return addressDAO.getAll();
    }

    public Address getAddressByID(int id) {
        return addressDAO.getByID(id);
    }

    public void deleteAddressByID(int id) {
        addressDAO.deleteByID(id);
    }

    public void saveAddress(Address address) {
        addressDAO.save(address);
    }

    public void updateAddress(Address address) {
        addressDAO.update(address);
    }

}
