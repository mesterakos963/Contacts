package codeyard.contacts.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public enum Gender implements Serializable {
        @SerializedName("male")
        MALE,
        @SerializedName("female")
        FEMALE
}
