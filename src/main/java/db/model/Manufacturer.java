package db.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Manufacturer {

    @JsonProperty("manufacturerID")
    @XmlAttribute
    private int manufacturerID;
    @JsonProperty("manufacturer")
    @XmlElement
    private String manufacturer;
    @JsonProperty("phoneNumber")
    @XmlElement
    private String phoneNumber;
    @JsonProperty("email")
    @XmlElement
    private String email;

    public Manufacturer() {
    }

    public Manufacturer(String manufacturer, String phoneNumber, String email) {
        this.manufacturer = manufacturer;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerId=" + manufacturerID +
                ", manufacturer='" + manufacturer + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
