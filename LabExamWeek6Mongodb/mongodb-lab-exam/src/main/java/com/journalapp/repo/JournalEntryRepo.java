package com.journalapp.repo;

import com.journalapp.entities.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface JournalEntryRepo extends MongoRepository<JournalEntry, String> {
    Optional<JournalEntry> findByTitle(String title);
    Optional<JournalEntry> findByDate(LocalDateTime date);
    List<JournalEntry> findByUserId(String userId);
    void deleteByUserId(String userId);
}
