package nl.bartnotelaers.hashutil;

import nl.bartnotelaers.service.PepperService;

public class Hash {
    private String salt;
    private String hash;

    public Hash(String salt, String password, String pepper) {
        this.salt = salt;
        this.hash = HashHelper.hash(salt + password + pepper);
    }

    public Hash() {
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public String getHash() {
        return hash;
    }
}
