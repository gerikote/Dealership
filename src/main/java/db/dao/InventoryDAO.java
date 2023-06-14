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
    protected void setParameters(PreparedStatement ps, Inventory entity, boolean isUpdate) throws SQLException {
        ps.setString(1, entity.getModel());
        ps.setInt(2, entity.getYear());
        ps.setInt(3, entity.getMileage());
        ps.setString(4, entity.getFuel());
        ps.setInt(5, entity.getMsrp());
        ps.setString(6, entity.getVin());
        ps.setBoolean(7, entity.isInStock());
        ps.setInt(8, entity.getManufacturerID());
        ps.setInt(9, entity.getColorID());
        ps.setInt(10, entity.getConditionID());
        if (isUpdate) {
            ps.setInt(11, entity.getInventoryID());
        }


    }

    @Override
    protected String generateInsertQuery() {
        String query = "INSERT INTO " + getTableName() + " (model, year, mileage, fuel, msrp, vin, in_stock, manufacturer_id, color_id, condition_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
        return query;
    }

    @Override
    protected String generateUpdateQuery() {
        String query = "UPDATE " + getTableName() + " SET  model=?, year=?, mileage=?, fuel=?, msrp=?, vin=?, in_stock=?, manufacturer_id=?, color_id=?, condition_id=? WHERE inventory_id=?";
        return query;
    }

    @Override
    protected Inventory mapResultSetToObject(ResultSet rs) throws SQLException {
        Inventory inventory = new Inventory();
        inventory.setInventoryID(rs.getInt("inventory_id"));
        inventory.setModel(rs.getString("model"));
        inventory.setYear(rs.getInt("year"));
        inventory.setMileage(rs.getInt("mileage"));
        inventory.setFuel(rs.getString("fuel"));
        inventory.setMsrp(rs.getInt("msrp"));
        inventory.setVin(rs.getString("vin"));
        inventory.setInStock(rs.getBoolean("in_stock"));
        inventory.setManufacturerID(rs.getInt("manufacturer_id"));
        inventory.setColorID(rs.getInt("color_id"));
        inventory.setConditionID(rs.getInt("condition_id"));
        return inventory;
    }
}
