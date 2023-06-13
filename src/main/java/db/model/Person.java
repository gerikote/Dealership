package db.model;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import utils.jaxb.DateAdapter;


import java.sql.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlAttribute
    private int personID;
    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dateOfBirth;
    @XmlElement
    private String phoneNumber;
    @XmlElement
    private String email;
    @XmlElement
    private int addressID;

    public Person() {
    }

    public Person(String firstName, String lastName, Date dateOfBirth, String phoneNumber, String email, int addressID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressID = addressID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", addressID=" + addressID +
                '}';
    }
}
