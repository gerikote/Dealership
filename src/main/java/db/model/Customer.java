package db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @JsonProperty("customerID")
    @XmlAttribute
    private int customerID;

    @JsonProperty("vipStatus")
    @XmlElement
    private boolean vipStatus;

    @JsonProperty("personID")
    @XmlElement
    private int personID;

    public Customer() {
    }

    public Customer(boolean vipStatus, int personID) {
        this.vipStatus = vipStatus;
        this.personID = personID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(boolean vipStatus) {
        this.vipStatus = vipStatus;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }
}
