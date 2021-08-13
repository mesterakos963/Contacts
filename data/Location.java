package codeyard.contacts.data;


import java.io.Serializable;

public class Location implements Serializable {
    String street;
    String city;
    String state;
    String postcode;
    Coordinate coordinate;
    TimeZone timeZone;

    public Location(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public String getFullAddress() {
        return city + ", " + street;
    }
}
