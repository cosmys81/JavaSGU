package org.knit.solutions.Task20.passwordmanager.security;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MasterPasswordHolder {
    private char[] secret;

    public void set(char[] secret) {
        this.secret = secret;
    }

    public char[] get() {
        return secret;
    }

    public void clear() {
        if (secret != null) {
            Arrays.fill(secret, '\0');
        }
    }
}
