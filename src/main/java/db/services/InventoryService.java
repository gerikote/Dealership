package db.services;

import db.dao.InventoryDAO;
import db.model.Inventory;

import java.util.List;

public class InventoryService {
    private InventoryDAO inventoryDAO;

    public InventoryService() {
        inventoryDAO = new InventoryDAO();
    }

    public List<Inventory> getAllInventory() {
        return inventoryDAO.getAll();
    }

    public Inventory getInventoryByID(int id) {
        return inventoryDAO.getByID(id);
    }

    public void saveInventory(Inventory inventory) {
        inventoryDAO.save(inventory);
    }

    public void updateInventory(Inventory inventory) {
        inventoryDAO.update(inventory);
    }

    public void deleteInventoryByID(int id) {
        inventoryDAO.deleteByID(id);
    }
}
