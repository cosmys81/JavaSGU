package org.knit.solutions.Task20.passwordmanager.crypto;

import org.knit.solutions.Task20.passwordmanager.security.MasterPasswordHolder;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

@Component
public class AesEncryptionService implements EncryptionService {
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final int KEY_LENGTH = 256;
    private static final int ITERATION_COUNT = 65536;
    private static final int SALT_SIZE = 16;
    private static final int IV_SIZE = 16;

    private final MasterPasswordHolder masterPassword;

    public AesEncryptionService(MasterPasswordHolder masterPassword) {
        this.masterPassword = masterPassword;
    }

    @Override
    public String encrypt(String input) {
        try {
            byte[] salt = randomBytes(SALT_SIZE);
            byte[] iv = randomBytes(IV_SIZE);
            SecretKeySpec keySpec = deriveKey(salt);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv));

            byte[] result = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
            byte[] full = new byte[salt.length + iv.length + result.length];

            System.arraycopy(salt, 0, full, 0, salt.length);
            System.arraycopy(iv, 0, full, salt.length, iv.length);
            System.arraycopy(result, 0, full, salt.length + iv.length, result.length);

            return Base64.getEncoder().encodeToString(full);
        } catch (Exception ex) {
            throw new RuntimeException("Encryption failed", ex);
        }
    }

    @Override
    public String decrypt(String input) {
        try {
            byte[] data = Base64.getDecoder().decode(input);
            byte[] salt = new byte[SALT_SIZE];
            byte[] iv = new byte[IV_SIZE];
            byte[] encrypted = new byte[data.length - SALT_SIZE - IV_SIZE];

            System.arraycopy(data, 0, salt, 0, SALT_SIZE);
            System.arraycopy(data, SALT_SIZE, iv, 0, IV_SIZE);
            System.arraycopy(data, SALT_SIZE + IV_SIZE, encrypted, 0, encrypted.length);

            SecretKeySpec keySpec = deriveKey(salt);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));

            byte[] original = cipher.doFinal(encrypted);
            return new String(original, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            throw new RuntimeException("Decryption failed", ex);
        }
    }

    private SecretKeySpec deriveKey(byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(masterPassword.get(), salt, ITERATION_COUNT, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }

    private byte[] randomBytes(int size) {
        byte[] bytes = new byte[size];
        new SecureRandom().nextBytes(bytes);
        return bytes;
    }
}
