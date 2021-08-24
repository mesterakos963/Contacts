package codeyard.contacts.data;

import java.io.Serializable;

public class Picture implements Serializable {
    String large;
    String medium;
    String thumbnail;

    public Picture(String url){
        this.large = url;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
