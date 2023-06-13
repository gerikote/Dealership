package db.model;

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

    @XmlAttribute
    private int saleId;
    @XmlElement
    private int price;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;
    @XmlElement
    private int employeeId;
    @XmlElement
    private int customerId;
    @XmlElement
    private int inventoryId;
    @XmlElement
    private int insuranceId;
    @XmlElement
    private int paymentMethodId;

    public Sale() {
    }

    public Sale(int price, Date date, int employeeId, int customerId, int inventoryId, int insuranceId, int paymentMethodId) {
        this.price = price;
        this.date = date;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.inventoryId = inventoryId;
        this.insuranceId = insuranceId;
        this.paymentMethodId = paymentMethodId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", price=" + price +
                ", date=" + date +
                ", employeeId=" + employeeId +
                ", customerId=" + customerId +
                ", inventoryId=" + inventoryId +
                ", insuranceId=" + insuranceId +
                ", paymentMethodId=" + paymentMethodId +
                '}';
    }
}
