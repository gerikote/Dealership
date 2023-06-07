package db.services;

import db.dao.ConditionDAO;
import db.model.Condition;

import java.util.List;

public class ConditionService {
    private ConditionDAO conditionDAO;

    public ConditionService() {
        conditionDAO = new ConditionDAO();
    }

    public List<Condition> getAllConditions() {
        return conditionDAO.getAll();
    }

    public Condition getConditionByID(int id) {
        return conditionDAO.getByID(id);
    }

    public void saveCondition(Condition condition) {
        conditionDAO.save(condition);
    }

    public void updateCondition(Condition condition) {
        conditionDAO.update(condition);
    }

    public void deleteConditionByID(int id) {
        conditionDAO.deleteByID(id);
    }
}
