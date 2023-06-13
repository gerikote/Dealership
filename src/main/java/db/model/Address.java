package db.model;

public class Address {

    private int addressID;
    private String address;
    private String zipCode;
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
