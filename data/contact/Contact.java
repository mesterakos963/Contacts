package codeyard.contacts.data.contact;

import java.io.Serializable;

import codeyard.contacts.data.Date;
import codeyard.contacts.data.Gender;
import codeyard.contacts.data.Id;
import codeyard.contacts.data.Location;
import codeyard.contacts.data.Login;
import codeyard.contacts.data.Name;
import codeyard.contacts.data.Picture;

public class Contact implements Serializable {
    Name name;
    Gender gender;
    String email;
    Login login;
    Date dateOfBirth;
    Date registered;
    String phone;
    String cell;
    Id id;
    Picture picture;
    String nat;
    Location location;

    public Contact(Name name, String email, Location location, Picture picture) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.picture = picture;
    }

    public Name getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Login getLogin() {
        return login;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getRegistered() {
        return registered;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public Id getId() {
        return id;
    }

    public Picture getPicture() {
        return picture;
    }

    public Location getLocation() {
        return location;
    }

    public String getNat() {
        return nat;
    }
}
