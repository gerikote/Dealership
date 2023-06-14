package db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtraServices {

    @JsonProperty("serviceID")
    @XmlAttribute
    private int serviceID;
    @JsonProperty("serviceName")
    @XmlElement
    private String serviceName;
    @JsonProperty("serviceDescription")
    @XmlElement
    private String serviceDescription;
    @JsonProperty("price")
    @XmlElement
    private int price;

    public ExtraServices() {
    }

    public ExtraServices(String serviceName, String serviceDescription, int price) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.price = price;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ExtraServices{" +
                "serviceId=" + serviceID +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", price=" + price +
                '}';
    }
}
