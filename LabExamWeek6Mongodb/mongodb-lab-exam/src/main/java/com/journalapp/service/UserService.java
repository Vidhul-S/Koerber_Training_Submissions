package com.journalapp.service;
import com.journalapp.entities.User;
import com.journalapp.repo.JournalEntryRepo;
import com.journalapp.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepo userRepo;
    private final JournalEntryService journalEntryService;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(String id) {
        journalEntryService.deleteEntriesByUserId(id);
        userRepo.deleteById(id);
    }
}

