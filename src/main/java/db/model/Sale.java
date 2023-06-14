package db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import utils.jaxb.DateAdapter;
import jakarta.xml.bind.annotation.*;

import java.sql.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sale {

    @JsonProperty("saleID")
    @XmlAttribute
    private int saleID;
    @JsonProperty("price")
    @XmlElement
    private int price;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;
    @JsonProperty("employeeID")
    @XmlElement
    private int employeeID;
    @JsonProperty("customerID")
    @XmlElement
    private int customerID;
    @JsonProperty("inventoryID")
    @XmlElement
    private int inventoryID;
    @JsonProperty("insuranceID")
    @XmlElement
    private int insuranceID;
    @JsonProperty("paymentMethodID")
    @XmlElement
    private int paymentMethodID;

    public Sale() {
    }

    public Sale(int price, Date date, int employeeID, int customerID, int inventoryID, int insuranceID, int paymentMethodID) {
        this.price = price;
        this.date = date;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.inventoryID = inventoryID;
        this.insuranceID = insuranceID;
        this.paymentMethodID = paymentMethodID;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(int paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleID +
                ", price=" + price +
                ", date=" + date +
                ", employeeId=" + employeeID +
                ", customerId=" + customerID +
                ", inventoryId=" + inventoryID +
                ", insuranceId=" + insuranceID +
                ", paymentMethodId=" + paymentMethodID +
                '}';
    }
}
