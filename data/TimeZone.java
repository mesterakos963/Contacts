package codeyard.contacts.data;

import java.io.Serializable;

public class TimeZone implements Serializable {
    String offset;
    String description;

    public String getOffset() {
        return offset;
    }

    public String getDescription() {
        return description;
    }
}
