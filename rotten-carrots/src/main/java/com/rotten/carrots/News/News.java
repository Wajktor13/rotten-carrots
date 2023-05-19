package com.rotten.carrots.News;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "news")
@Getter
@Setter
public class News {

    @Id
    private String newsID;

    private String author;

    private String title;

    private String content;

    private LocalDateTime publicationDate;

    public News(String author, String title, String content, LocalDateTime publicationDate) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
    }
}
