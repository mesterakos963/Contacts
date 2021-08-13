package codeyard.contacts.data;

import java.io.Serializable;

public class Coordinate implements Serializable {
    String latitude = "20.9267";
    String longitude = "-7.9310";

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
