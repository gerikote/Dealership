package db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Inventory {
    @JsonProperty("inventoryID")
    @XmlAttribute
    private int inventoryID;

    @JsonProperty("model")
    @XmlElement
    private String model;

    @JsonProperty("year")
    @XmlElement
    private int year;

    @JsonProperty("mileage")
    @XmlElement
    private int mileage;

    @JsonProperty("fuel")
    @XmlElement
    private String fuel;

    @JsonProperty("msrp")
    @XmlElement
    private int msrp;

    @JsonProperty("vin")
    @XmlElement
    private String vin;

    @JsonProperty("inStock")
    @XmlElement
    private boolean inStock;

    @JsonProperty("manufacturerID")
    @XmlElement
    private int manufacturerID;

    @JsonProperty("colorID")
    @XmlElement
    private int colorID;

    @JsonProperty("conditionID")
    @XmlElement
    private int conditionID;

    public Inventory() {
    }

    public Inventory(String model, int year, int mileage, String fuel, int msrp, String vin, boolean inStock, int manufacturerID, int colorID, int conditionID) {
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuel = fuel;
        this.msrp = msrp;
        this.vin = vin;
        this.inStock = inStock;
        this.manufacturerID = manufacturerID;
        this.colorID = colorID;
        this.conditionID = conditionID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
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

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public int getConditionID() {
        return conditionID;
    }

    public void setConditionID(int conditionID) {
        this.conditionID = conditionID;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", fuel='" + fuel + '\'' +
                ", msrp=" + msrp +
                ", vin='" + vin + '\'' +
                ", inStock=" + inStock +
                ", manufacturerID=" + manufacturerID +
                ", colorID=" + colorID +
                ", conditionID=" + conditionID +
                '}';
    }
}
