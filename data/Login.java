package codeyard.contacts.data;

import java.io.Serializable;

public class Login implements Serializable {
    String uuid;
    String userName;
    String password;
    String salt;
    String md5;
    String sha1;
    String sha256;

    public String getUuid() {
        return uuid;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getMd5() {
        return md5;
    }

    public String getSha1() {
        return sha1;
    }

    public String getSha256() {
        return sha256;
    }
}
