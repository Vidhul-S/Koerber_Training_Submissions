package com.journalapp.controller;

import com.journalapp.entities.JournalEntry;
import com.journalapp.service.JournalEntryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @GetMapping
    public List<JournalEntry> getAllEntries() {
        return journalEntryService.getAllEntries();
    }

    @GetMapping("/user/{userId}")
    public List<JournalEntry> getEntriesByUserId(@PathVariable String userId) {
        return journalEntryService.getEntriesByUserId(userId);
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry journalEntry) {
        return journalEntryService.createEntry(journalEntry);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEntry(@PathVariable String id) {
        journalEntryService.deleteEntry(id);
    }
}

