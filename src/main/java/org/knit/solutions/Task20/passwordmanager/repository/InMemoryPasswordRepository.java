package org.knit.solutions.Task20.passwordmanager.repository;

import org.knit.solutions.Task20.passwordmanager.model.PasswordEntry;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryPasswordRepository implements PasswordRepository {
    private final Map<String, PasswordEntry> storage = new HashMap<>();

    @Override
    public void add(PasswordEntry entry) {
        storage.put(entry.getSite(), entry);
    }

    @Override
    public List<PasswordEntry> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public PasswordEntry findBySite(String site) {
        return storage.get(site);
    }

    @Override
    public void delete(String site) {
        storage.remove(site);
    }
}
