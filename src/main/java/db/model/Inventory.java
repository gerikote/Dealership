package db.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Inventory {

    @XmlAttribute
    private int inventoryId;
    @XmlElement
    private String model;
    @XmlElement
    private int year;
    @XmlElement
    private int mileage;
    @XmlElement
    private String fuel;
    @XmlElement
    private int msrp;
    @XmlElement
    private String vin;
    @XmlElement
    private boolean inStock;
    @XmlElement
    private int manufacturerId;
    @XmlElement
    private int colorId;
    @XmlElement
    private int conditionId;

    public Inventory() {
    }

    public Inventory(String model, int year, int mileage, String fuel, int msrp, String vin, boolean inStock, int manufacturerId, int colorId, int conditionId) {
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

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", fuel='" + fuel + '\'' +
                ", msrp=" + msrp +
                ", vin='" + vin + '\'' +
                ", inStock=" + inStock +
                ", manufacturerId=" + manufacturerId +
                ", colorId=" + colorId +
                ", conditionId=" + conditionId +
                '}';
    }
}
