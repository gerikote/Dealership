package db.model;

import java.sql.Date;
import java.time.LocalDate;

public class Sale {

    private int saleId;
    private int price;
    private Date date;
    private int employeeId;
    private int customerId;
    private int inventoryId;
    private int insuranceId;
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
