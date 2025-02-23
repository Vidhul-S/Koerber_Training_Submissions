package com.journalapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "JournalEntry")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntry {

    @Id
    private String id;

    private String title;
    private String content;
    private LocalDateTime date;

    @DBRef
    private User user;

    public JournalEntry(String title, String content, LocalDateTime date,User user) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.user = user;
    }

}
