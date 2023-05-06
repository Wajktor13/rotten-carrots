package com.rotten.carrots.News;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "news")
public class News {

    @Id
    private String newsID;

    private String author;

    private String title;
    private String content;
    private Date publicationDate;

    public News(String author, String title, String content, Date publicationDate) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
    }

    public String getNewsID() {
        return newsID;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }
}
