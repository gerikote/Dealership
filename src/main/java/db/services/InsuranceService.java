package db.services;

import db.dao.InsuranceDAO;
import db.model.Insurance;

import java.util.List;

public class InsuranceService {
    private InsuranceDAO insuranceDAO;

    public InsuranceService() {
        insuranceDAO = new InsuranceDAO();
    }

    public List<Insurance> getAllInsurance() {
        return insuranceDAO.getAll();
    }

    public Insurance getInsuranceByID(int id) {
        return insuranceDAO.getByID(id);
    }

    public void saveInsurance(Insurance insurance) {
        insuranceDAO.save(insurance);
    }

    public void updateInsurance(Insurance insurance) {
        insuranceDAO.update(insurance);
    }

    public void deleteInsuranceByID(int id) {
        insuranceDAO.deleteByID(id);
    }
}

