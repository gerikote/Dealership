package db.services;

import db.dao.ExtraServicesDAO;
import db.model.ExtraServices;

import java.util.List;

public class ExtraServicesService {
    private ExtraServicesDAO extraServicesDAO;

    public ExtraServicesService() {
        extraServicesDAO = new ExtraServicesDAO();
    }

    public List<ExtraServices> getAllExtraServices() {
        return extraServicesDAO.getAll();
    }

    public ExtraServices getExtraServiceByID(int id) {
        return extraServicesDAO.getByID(id);
    }

    public void saveExtraService(ExtraServices extraService) {
        extraServicesDAO.save(extraService);
    }

    public void updateExtraService(ExtraServices extraService) {
        extraServicesDAO.update(extraService);
    }

    public void deleteExtraServiceByID(int id) {
        extraServicesDAO.deleteByID(id);
    }
}

