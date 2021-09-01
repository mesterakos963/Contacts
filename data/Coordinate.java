package codeyard.contacts.data;

import java.io.Serializable;

public class Coordinate implements Serializable {
    String latitude;
    String longitude;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
