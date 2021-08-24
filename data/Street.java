package codeyard.contacts.data;

import java.io.Serializable;

public class Street implements Serializable {
    int number;
    String name;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return this.name;
    }
}
