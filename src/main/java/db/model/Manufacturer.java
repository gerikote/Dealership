package db.model;
import jakarta.xml.bind.annotation.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Manufacturer {

    @XmlAttribute
    private int manufacturerId;
    @XmlElement
    private String manufacturer;
    @XmlElement
    private String phoneNumber;
    @XmlElement
    private String email;

    public Manufacturer() {
    }

    public Manufacturer(String manufacturer, String phoneNumber, String email) {
        this.manufacturer = manufacturer;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
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
                "manufacturerId=" + manufacturerId +
                ", manufacturer='" + manufacturer + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
