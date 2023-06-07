package db.services;

import db.dao.ColorDAO;
import db.model.Color;

import java.util.List;

public class ColorService {

    private ColorDAO colorDAO;

    public ColorService() {
        colorDAO = new ColorDAO();
    }

    public List<Color> getAllColors() {
        return colorDAO.getAll();
    }

    public Color getColorByID(int id) {
        return colorDAO.getByID(id);
    }

    public void saveColor(Color color) {
        colorDAO.save(color);
    }

    public void updateColor(Color color) {
        colorDAO.update(color);
    }

    public void deleteColorByID(int id) {
        colorDAO.deleteByID(id);
    }
}


