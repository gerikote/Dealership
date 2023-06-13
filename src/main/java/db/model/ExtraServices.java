package db.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtraServices {

    @XmlAttribute
    private int serviceId;
    @XmlElement
    private String serviceName;
    @XmlElement
    private String serviceDescription;
    @XmlElement
    private int price;

    public ExtraServices() {
    }

    public ExtraServices(String serviceName, String serviceDescription, int price) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.price = price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", price=" + price +
                '}';
    }
}
