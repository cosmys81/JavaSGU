package org.knit.solutions.Task20.passwordmanager.model;

public class PasswordEntry {
    private final String site;
    private final String username;
    private final String cipherPassword;

    public PasswordEntry(String site, String username, String cipherPassword) {
        this.site = site;
        this.username = username;
        this.cipherPassword = cipherPassword;
    }

    public String getSite() {
        return site;
    }

    public String getUsername() {
        return username;
    }

    public String getCipherPassword() {
        return cipherPassword;
    }
}
