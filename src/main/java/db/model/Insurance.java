package db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Insurance {

    @JsonProperty("insuranceID")
    @XmlAttribute
    private int insuranceID;

    @XmlElement
    private String insuranceCompany;

    @XmlElement
    private int coverage;

    public Insurance() {
    }

    public Insurance(String insuranceCompany, int coverage) {
        this.insuranceCompany = insuranceCompany;
        this.coverage = coverage;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public int getCoverage() {
        return coverage;
    }

    public void setCoverage(int coverage) {
        this.coverage = coverage;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceId=" + insuranceID +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", coverage=" + coverage +
                '}';
    }
}
