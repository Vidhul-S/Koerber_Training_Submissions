package com.journalapp.service;

import com.journalapp.entities.JournalEntry;
import com.journalapp.entities.User;
import com.journalapp.exceptions.ResourceNotFoundException;
import com.journalapp.repo.JournalEntryRepo;
import com.journalapp.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class JournalEntryService {

    private final JournalEntryRepo journalEntryRepo;
    private final UserRepo userRepo;


    public List<JournalEntry> getAllEntries() {
        return journalEntryRepo.findAll();
    }

    public List<JournalEntry> getEntriesByUserId(String userId) {
        return journalEntryRepo.findByUserId(userId);
    }

    public JournalEntry createEntry(JournalEntry journalEntry) {
        journalEntry =journalEntryRepo.save(journalEntry);
        String userId = journalEntry.getUser().getId();
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("No such user"));
        user.getJournalEntries().add(journalEntry);
        userRepo.save(user);
        return journalEntry;
    }
    public void deleteEntriesByUserId(String userId) {
        journalEntryRepo.deleteByUserId(userId);
    }
    public void deleteEntry(String id) {
        journalEntryRepo.deleteByUserId(id);
        journalEntryRepo.deleteById(id);
    }
}

