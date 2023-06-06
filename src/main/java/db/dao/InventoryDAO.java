package db.dao;

import db.model.Inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryDAO extends BaseDAO<Inventory> {
    @Override
    protected String getTableName() {
        return "inventory";
    }

    @Override
    protected String getIdName() {
        return "inventory_id";
    }

    @Override
    protected void setParameters(PreparedStatement ps, Inventory entity) throws SQLException {
        ps.setString(1, entity.getModel());
        ps.setInt(2, entity.getYear());
        ps.setInt(3, entity.getMileage());
        ps.setString(4, entity.getFuel());
        ps.setInt(5, entity.getMsrp());
        ps.setString(6, entity.getVin());
        ps.setBoolean(7, entity.isInStock());
        ps.setInt(8, entity.getManufacturerId());
        ps.setInt(9, entity.getColorId());
        ps.setInt(10, entity.getColorId());


    }

    @Override
    protected String generateInsertQuery(Inventory entity) {
        String tableName = "inventory";
        String columns = " model, year, mileage, fuel, msrp, vin, in_stock, manufacturer_id, color_id, condition_id";
        String values = "?,?,?,?,?,?,?,?,?,?";
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        return query;
    }

    @Override
    protected String generateUpdateQuery(Inventory entity) {
        String tableName = "inventory";
        String setIdentifiers = "msrp=?";
        String condition = "inventory_id = ?";
        String query = "UPDATE " + tableName + " SET " + setIdentifiers + " WHERE " + condition;
        return query;
    }

    @Override
    protected Inventory mapResultSetToObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("inventory_id");
        String model = rs.getString("model");
        int year = rs.getInt("year"); // Assuming the column name is "year"
        int mileage = rs.getInt("mileage");
        String fuel = rs.getString("fuel");
        int msrp = rs.getInt("msrp");
        String vin = rs.getString("vin");
        boolean inStock = rs.getBoolean("in_stock");
        int manufacturerId = rs.getInt("manufacturer_id");
        int colorId = rs.getInt("color_id");
        int conditionId = rs.getInt("condition_id");

        Inventory inventory = new Inventory();
        inventory.setInventoryId(id);
        inventory.setModel(model);
        inventory.setYear(year);
        inventory.setMileage(mileage);
        inventory.setFuel(fuel);
        inventory.setMsrp(msrp);
        inventory.setVin(vin);
        inventory.setInStock(inStock);
        inventory.setManufacturerId(manufacturerId);
        inventory.setColorId(colorId);
        inventory.setConditionId(conditionId);

        return inventory;
    }
}
