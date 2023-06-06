package db.model;

public class City {
    private int cityID;
    private String city;

    public City() {
    }

    public City(int cityID, String city) {
        this.cityID = cityID;
        this.city = city;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityID=" + cityID +
                ", city='" + city + '\'' +
                '}';
    }
}
