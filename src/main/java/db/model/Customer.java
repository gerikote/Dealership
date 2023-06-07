package db.model;

import java.sql.Date;
import java.time.LocalDate;

public class Customer {
    private int customerId;
    private boolean vipStatus;
    private int personID;

    public Customer() {
    }

    public Customer(boolean vipStatus, int personID) {
        this.vipStatus = vipStatus;
        this.personID = personID;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
