package db.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlAttribute
    private int addressID;
    @XmlElement
    private String address;
    @XmlElement
    private String zipCode;
    @XmlElement
    private int cityID;

    public Address() {
    }

    public Address(String address, String zipCode, int cityID) {
        this.address = address;
        this.zipCode = zipCode;
        this.cityID = cityID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressID=" + addressID +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", cityID=" + cityID +
                '}';
    }
}
