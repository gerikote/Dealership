package db.services;

import db.dao.CityDAO;
import db.model.City;

import java.util.List;

public class CityService {
    private CityDAO cityDAO;

    public CityService() {
        cityDAO = new CityDAO();
    }

    public List<City> getAllCities() {
        return cityDAO.getAll();
    }

    public City getCityByID(int id) {
        return cityDAO.getByID(id);
    }

    public void saveCity(City city) {
        cityDAO.save(city);
    }

    public void updateCity(City city) {
        cityDAO.update(city);
    }

    public void deleteCityByID(int id) {
        cityDAO.deleteByID(id);
    }
}
