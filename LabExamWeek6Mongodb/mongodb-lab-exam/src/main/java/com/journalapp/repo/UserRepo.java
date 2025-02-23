package com.journalapp.repo;

import com.journalapp.entities.User;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    @Aggregation(pipeline = {
            "{ $lookup: { from: 'journalEntry', localField: '_id', foreignField: 'user.id', as: 'journalEntries' } }",
            "{ $addFields: { journalEntries: { $ifNull: [ '$journalEntries', [] ] } } }"
    })
    List <User> findAll();
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);
}
