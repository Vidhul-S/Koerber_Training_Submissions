//package com.journalapp.util;
//
//import com.journalapp.entities.JournalEntry;
//import com.journalapp.entities.User;
//import com.journalapp.repo.JournalEntryRepo;
//import com.journalapp.repo.UserRepo;
//import lombok.AllArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Component
//@AllArgsConstructor
//public class DataInitializer implements CommandLineRunner {
//
//    private final UserRepo userRepo;
//    private final JournalEntryRepo journalEntryRepo;
//
//
//    @Override
//    public void run(String... args) {
//        // Clear existing data (optional)
//        userRepo.deleteAll();
//        journalEntryRepo.deleteAll();
//
//        // Create sample users
//        User user1 = new User("Alice Johnson", "alice@example.com");
//        User user2 = new User("Bob Smith", "bob@example.com");
//        User user3 = new User("Charlie Brown", "charlie@example.com");
//
//        // Save users
//        user1 = userRepo.save(user1);
//        user2 = userRepo.save(user2);
//        user3 = userRepo.save(user3);
//
//        // Create sample journal entries
//        JournalEntry entry1 = new JournalEntry("Alice's First Entry", "This is Alice's first journal entry.", LocalDateTime.now(), user1);
//        JournalEntry entry2 = new JournalEntry("Bob's Thoughts", "Bob shares his thoughts for today.", LocalDateTime.now(), user2);
//        JournalEntry entry3 = new JournalEntry("Another Day for Alice", "Alice writes another entry.", LocalDateTime.now(), user1);
//
//        // Save journal entries
//        journalEntryRepo.saveAll(List.of(entry1, entry2, entry3));
//
//        // Print confirmation to console
//        System.out.println("Sample data inserted!");
//    }
//}
//
//
