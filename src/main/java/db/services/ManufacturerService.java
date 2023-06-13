package db.services;

import db.dao.ManufacturerDAO;
import db.model.Manufacturer;

import java.util.List;

public class ManufacturerService {
    private ManufacturerDAO manufacturerDAO;

    public ManufacturerService() {
        manufacturerDAO = new ManufacturerDAO();
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerDAO.getAll();
    }

    public Manufacturer getManufacturerByID(int id) {
        return manufacturerDAO.getByID(id);
    }

    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerDAO.save(manufacturer);
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerDAO.update(manufacturer);
    }

    public void deleteManufacturerByID(int id) {
        manufacturerDAO.deleteByID(id);
    }
}

