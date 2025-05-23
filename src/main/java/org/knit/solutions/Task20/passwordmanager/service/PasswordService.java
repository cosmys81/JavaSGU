package org.knit.solutions.Task20.passwordmanager.service;

import org.knit.solutions.Task20.passwordmanager.clipboard.ClipboardService;
import org.knit.solutions.Task20.passwordmanager.crypto.EncryptionService;
import org.knit.solutions.Task20.passwordmanager.model.PasswordEntry;
import org.knit.solutions.Task20.passwordmanager.repository.PasswordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {
    private final PasswordRepository repo;
    private final EncryptionService crypto;
    private final ClipboardService clip;

    public PasswordService(PasswordRepository repo, EncryptionService crypto, ClipboardService clip) {
        this.repo = repo;
        this.crypto = crypto;
        this.clip = clip;
    }

    public void add(String site, String user, String password) {
        String encrypted = crypto.encrypt(password);
        repo.add(new PasswordEntry(site, user, encrypted));
    }

    public List<PasswordEntry> list() {
        return repo.findAll();
    }

    public void delete(String site) {
        repo.delete(site);
    }

    public boolean copy(String site) {
        PasswordEntry entry = repo.findBySite(site);
        if (entry != null) {
            String decoded = crypto.decrypt(entry.getCipherPassword());
            clip.copyToClipboard(decoded);
            return true;
        }
        return false;
    }
}
