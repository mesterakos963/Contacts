package codeyard.contacts.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Name implements Serializable {
    String title;
    @SerializedName("first")
    String firstName;
    @SerializedName("last")
    String lastName;

    public Name(String title, String firstName, String lastName){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        if (title == null) {
            return firstName + " " + lastName;
        } else { return title + " " + firstName + " " + lastName; }

    }
}
