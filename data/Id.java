package codeyard.contacts.data;

import java.io.Serializable;

public class Id implements Serializable {
    String name;
    String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
