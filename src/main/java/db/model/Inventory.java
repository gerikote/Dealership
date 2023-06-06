package db.model;

import java.time.Year;

public class Inventory {
    private int inventoryId;
    private String model;
    private int year;
    private int mileage;
    private String fuel;
    private int msrp;
    private String vin;
    private boolean inStock;
    private int manufacturerId;
    private int colorId;
    private int conditionId;

    public Inventory() {
    }

    public Inventory(int inventoryId, String model, int year, int mileage, String fuel, int msrp, String vin, boolean inStock, int manufacturerId, int colorId, int conditionId) {
        this.inventoryId = inventoryId;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuel = fuel;
        this.msrp = msrp;
        this.vin = vin;
        this.inStock = inStock;
        this.manufacturerId = manufacturerId;
        this.colorId = colorId;
        this.conditionId = conditionId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getMsrp() {
        return msrp;
    }

    public void setMsrp(int msrp) {
        this.msrp = msrp;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }
}
